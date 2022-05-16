#!/usr/bin/env zsh

cd "${0:A:h}"

if [ -z "$1" ]
then
  echo "You must specify servername"
  exit 1
fi
cp -v ./$1/target/*.war out/wlp/usr/servers/$1/apps
cmdline="/liberty/wlp/bin/server start $1 && tail -f /logs/messages.log"
echo "exec -itt websphere_liberty bash -c \"$cmdline\""
docker exec -itt websphere_liberty bash -c "$cmdline"
