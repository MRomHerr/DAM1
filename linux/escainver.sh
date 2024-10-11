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
indini2="0"
indifin2=$1
linea=""

while [ $indini -lt $escalones ]; do

 indini=$(($indini+1))
 indini2="0"
 linea=""
 while [ $indini2 -lt $indifin2 ]; do
   
  linea=$linea$simbolo
  indini2=$(($indini2+1))
 
 done

 indifin2=$(($indifin2-1))

 echo $linea

done

exit 0