#!/bin/sh

./stalin/scalastyle.sh $1 || exit 1
./stalin/coffeestyle.sh $1 || exit 1
./stalin/cpplint.sh $1 || exit 1
