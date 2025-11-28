#!/bin/bash

while [ true ]; do
  curl --request GET -sL -I \
       --url 'http://localhost:8080/api/hero/1'
done
