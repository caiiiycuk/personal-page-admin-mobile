#!/bin/sh

CHANGES=`git diff-tree --diff-filter=ACMRTUXB --name-only --no-commit-id -r $1 | grep -P "\.coffee$"`

if [ "$CHANGES" != "" ]; then
  ./stalin/node_modules/.bin/coffeelint -q -f ./stalin/coffeelint.json $CHANGES
fi
