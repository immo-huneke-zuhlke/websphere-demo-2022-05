# How to initialise, start and stop the REST demo

## Introduction

This application demonstrates how to expose a
RESTful API using Jax-RS under Websphere Liberty.

It is a very simple CRUD application to manage a
table of users in a PostgreSQL database server.

This application demonstrates a typical three-tier
architecture consisting of
* User layer (the complementary 
  [UserManager app](../usermanager/README.md))
* Combined Resource / Business / Service layer
* Data layer

The user layer in this case runs in the host
operating system, while the other two occupy
separate Docker containers.

## Initialising the application

Assuming that you have followed the 
[instructions for initialisation](../README.md)
of the Websphere Liberty container,
start the container by
running the script `./start.sh` in the root
directory of this repository clone.
Note that this will monopolise a terminal.
Open another terminal for the next command.

Connect to the container by running `./exec.sh`.

Stop the container by running the script
`./stop.sh` in the root directory of this
repository clone.

When the container is running and you have
connected a terminal to it, you can create
a new application:

`/liberty/wlp/bin/server create restdemo`

Do not start the application yet.

Copy the file
`RestDemo/server.xml` into the newly created
server home directory
`out/wlp/usr/servers/restdemo`, overwriting
the default `server.xml`.

## Start the PostgreSQL container

Before starting the REST demo app, you need
to start the database server.

In the root directory of this repository clone,
run

`./start-pg.sh`

The container can be terminated using the command

`./stop-pg.sh`

Note that at this point, you will lose any data
in the database and will have to re-establish
it next time.

## Populate the PostgreSQL database

Using a local installation of PGAdmin4,
register the database server using these
criteria:

|Field |Value |
|:---- |:--------------- |
|Name  |postgres-docker |
|Host  |localhost |
|Port  |5432 |
|User  |postgres |
|Password |postgrespw |

Once connected, navigate to the schema
`restdemo` and open a psql prompt by clicking
the icon `>_` at the top left of the PGAdmin
window.

Under `RestDemo/src/main/sql` in this repository
clone, you will find the following SQL scripts,
which you should copy and paste into the psql
interpreter:

* `create_db.sql`
* `create_table_user.sql`
* `insert_table_user.sql`

The database is now ready to support the REST
demo application.

## Build and start the web application

If the `RestDemo` application is not shown in
the Maven tab, right-click the file
`RestDemo/pom.xml` and select 
**Add as Maven Project**.

To build the project, open the Maven tab at top
right and multi-select **clean** and **install**.
Then click the green triangle to build the
WAR file.

Once built, you can copy or drag the WAR file
into `out/wlp/usr/servers/restdemo/apps`.

If the server is already running, it should
automatically discover the new file and
unpack it into the folder `expanded`.

Otherwise, from your terminal connected to
the Websphere container, run

`/liberty/wlp/bin/server start restdemo`

to start it (this usually takes 5-15 seconds).

## Sanity test

You can run the queries in
`RestDemo/test/smoke_api.http` [here](./test/smoke_api.http) directly from within your IDE or paste them one at a time into
a web browser.