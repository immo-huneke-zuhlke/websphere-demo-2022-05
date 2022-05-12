#!/usr/bin/env zsh

docker exec -it websphere_liberty /liberty/wlp/bin/server create RestDemo
cp -v /Users/gapo/Project/GitHub/websphere-demo-2022-05/RestDemo/server.xml out/wlp/usr/servers/RestDemo
cp -v /Users/gapo/Project/GitHub/websphere-demo-2022-05/RestDemo/target/RestDemo-1.0-SNAPSHOT.war out/wlp/usr/servers/RestDemo/apps
