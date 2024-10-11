#!/bin/bash

if [ $# -ne "2" ]; then

 echo "introduce dos parametros"
 echo "1- el numero escalones"
 echo "2- el simbolo (NO: *)"
 exit 1
fi 

escalones=$1
simbolo=$2
indini="0"
linea=""

while [ $indini -lt $escalones ]; do

 indini=$(($indini+1))
 linea=$linea$simbolo
 echo $linea

done

exit 0