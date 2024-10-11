#!/bin/bash


if [ $# -ne 1 ]; then

 echo "hay que meter la ciudad a buscar"
 exit 1

fi

fichero=$(cat confciudad.txt | grep -i fichero | cut -d "=" -f2)

if  [ ! -f $fichero ];then
 echo "el fichero: $fichero con los datos no existe"
 exit 1
 
fi


contador="0"



cat $fichero | tail -n +2 | tr -d " " | sed '/^$/d'>ficheroOK.txt
#cat ficheroOK.txt

ciudadusu=$(echo $1 | tr "a-z" "A-Z")
echo " "
echo CIUDADES DEL FICHERO
echo "--------------------"
cat ficheroOK.txt | cut -d ";" -f5 | sort | uniq
echo " "

while read linea;do 

 ciudad=$(echo $linea | cut -d ";" -f5 | tr "a-z" "A-Z")
 #echo $ciudad
  
 if [ $ciudadusu == $ciudad ]; then
    contador=$(($contador+1))
 fi

done<ficheroOK.txt

echo "El numero de usuarios con la ciudad, $ciudadusu, es: $contador" 
