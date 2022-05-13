#!/usr/bin/env zsh

if [ -z "$1" ]
then
  echo "You must specify servername"
  exit 1
fi

docker exec -it websphere_liberty /liberty/wlp/bin/server create $1
cp -v /Users/gapo/Project/GitHub/websphere-demo-2022-05/$1/server.xml out/wlp/usr/servers/$1
cp -v /Users/gapo/Project/GitHub/websphere-demo-2022-05/$1/target/*.war out/wlp/usr/servers/$1/apps
