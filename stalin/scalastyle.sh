#!/bin/sh

CHANGES=`git diff-tree --diff-filter=ACMRTUXB --name-only --no-commit-id -r $1 | grep -P "\.scala$" |grep -vP "Build.scala$|Test.scala$"`

if [ "$CHANGES" != "" ]; then
  java -jar stalin/scalastyle.jar -v true -w true -c stalin/scalastyle_config.xml $CHANGES
fi
