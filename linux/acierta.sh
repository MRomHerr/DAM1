#!/bin/bash


if [ $# -ne 1 ]; then

 echo "hay que meter el numero de intentos"
 exit 0

fi 

numok="4"
intentos=$1
salida="0"
acierto="0"
contador="0"

while [ $salida -eq "0" ]; do
 read -p "adivina el numero que estoy pensando: " usunum

 if [ $usunum == $numok ]; then
  salida="1"
  acierto="1"
 
 else 
   contador=$(($contador+1))
   if [ $contador -eq $intentos ]; then
    salida="1"
    acierto="0"
   fi
 fi 

done

if [ $acierto -eq "1" ]; then

 echo "HAS GANADO"

else
 echo "has perdido numero, $intetos, intentos superado"
fi
