#!/bin/sh

function random() {
  min=$1
  max=$2-$1
  num=$(date +%s+%N)
  ((retnum = num % max + min))
  echo $retnum
}

while true; do
  curl http://localhost:8088/student/1
  sleep $(echo "scale=2; $(random 100 1000)/1000" | bc)
done
