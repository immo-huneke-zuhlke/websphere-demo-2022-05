#!/usr/bin/env zsh

cd "${0:A:h}"

if [ -z "$1" ]
then
  echo "You must specify servername"
  exit 1
fi

docker exec websphere_liberty //liberty/wlp/bin/server create $1
cp -v $1/server.xml out/wlp/usr/servers/$1
cp -v $1/target/*.war out/wlp/usr/servers/$1/apps
