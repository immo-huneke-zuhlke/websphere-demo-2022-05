#!/usr/bin/env zsh

docker run -p 5432:5432 --name docker-postgres -e POSTGRES_PASSWORD=postgrespw -d postgres