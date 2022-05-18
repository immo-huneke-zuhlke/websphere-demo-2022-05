#!/usr/bin/env zsh

if [[ -x winpty ]]; then
	echo "using winpty"
else
	export winpty=''
fi
winpty docker exec -it websphere_liberty //bin/bash
