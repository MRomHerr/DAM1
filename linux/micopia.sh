#!/bin/bash

midir=$1
mifich=$2


if [ $# -ne 2 ]; then

 echo " tienes que introducir dos parametros"
 echo " 1 - directorio "
 echo " 2 - fichero "
 exit 1

fi

if [ -d $midir ]; then

 midirtot=$midir"/"$mifich
 
 if [ -f $midirtot ]; then
 
  echo " "
  echo "-----contenido del directorio origen  $midir -----"
  ls -lrt $midirtot
  echo " "  
  echo "-----------------------------------------"
  read -p "introduce un directorio destino: " midirdest
 
  if [ -z $midirdest ]; then
   echo "el directorio destino no puede estar vacio: '$midirdest'"
   exit 1
  
  elif [ -d $midirdest ]; then

   cp $midirtot $midirdest
  echo " "
   echo "------contenido del directorio $midirdest -----"
   ls -lrt $midirdest
   exit 0 

  else
   echo "el directorio destino, $midirdest, no existe"
   exit 1 
  
  fi  


 else
  echo "error, $mifich, no es un fichero valido"
  exit 1
 fi
else
 echo "error, $midir, no es un directorio valido"
 exit 1
fi


