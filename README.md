# Playground for learning WebSphere Liberty and PostgreSQL

## Prerequisites

The examples all use IntelliJ Idea, but any other
IDE should do equally well.
After cloning the repository, it is advisable to
use IntelliJ's File --> Open menu command to
select the folder that encloses the cloned repo.

You need Docker Desktop.
Download and install it from https://www.docker.com/products/docker-desktop/ .

## Initialising

From a Mac OS or Linux command line, run the script
`./init.sh`.

## Starting and stopping

Start the container by running the script `./start.sh`.
Note that this will monopolise a terminal.
Open another terminal for the next command.

Connect to the container by running `./exec.sh`.

Stop the container by running the script `./stop.sh`.

When the container is running, you can access the default server like this:

http://localhost:9080/openapi/ui/

See the standard output from the server to check what other endpoints are exposed.

## Deploying an application

You can connect to the container and run server
management commands such as

`/liberty/wlp/bin/server create SERVERNAME`

`/liberty/wlp/bin/server start SERVERNAME`

`/liberty/wlp/bin/server stop SERVERNAME`

If you add an application (such as `helloworld`) in
this project and build it, e.g. using the Maven `package`
target,
you should find that a WAR file has been created under
the `target` directory.

Move it to the folder `out/wlp/usr/servers/SERVERNAME/apps`
by dragging and dropping in the IDE project explorer view.

You'll have to modify the `server.xml` file
appropriately.
Most of the necessary settings can be cribbed
from the `helloworld` example.

You will also then have to run further commands
inside the container:

`/liberty/wlp/bin/featureUtility installServerFeatures SERVERNAME`

`/liberty/wlp/bin/installUtility install SERVERNAME`

After this it should be possible to start the
server SERVERNAME successfully.

Connect to it using the url
http://localhost/SERVERNAME/xyz-servlet

(where the name of the servlet can be found in
the `index.jsp` file auto-generated for you
by the IDE when you created the servlet project).