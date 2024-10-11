#!/bin/bash

if [ $# -ne "2" ]; then

 echo "introduce dos parametros"
 echo "1- el numero escalones"
 echo "2- el simbolo (NO: *)"
 exit 0
fi 

escalones=$1
simbolo=$2
indini="0"
indini2="0"
indblanc=$(($escalones-1))

linea=""
blancos=""
lineafi=""

while [ $indini -lt $escalones ]; do

 indini=$(($indini+1))
 indini2="0"


 if [ $indini -eq "1" ]; then

   linea=$simbolo

 else

   linea=$linea$simbolo$simbolo 
 fi
  
 indini2="0"
 blancos="" 
 lineafi=""

 while [ $indini2 -lt $indblanc ];do
 
     blancos=$blancos"-"
     indini2=$(($indini2+1))     

 done
 
 indblanc=$(($indblanc-1))
 lineafi=$blancos$linea
 echo $lineafi

done
