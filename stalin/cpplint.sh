#!/bin/sh

CHANGES=`git diff-tree --diff-filter=ACMRTUXB --name-only --no-commit-id -r $1 | grep -P "\.cpp$|\.h$"`

if [ "$CHANGES" != "" ]; then
  python ./stalin/cpplint.py --filter=-whitespace/tab,-build/include_order,-legal/copyright,-readability/function,-whitespace/labels 2>&1 $CHANGES
fi
