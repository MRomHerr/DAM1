#!/bin/bash


salir="0"
while [ $salir == "0" ];do

echo "--MI CALCULADORA--"
echo " "
echo " "
echo "1.Sumar"
echo "2.Restar"
echo "3.Multiplicar"
echo "4.Salir"
echo " "
echo " "
read -p "Selecciona una opcion: " opcion

if [[ $opcion =~ ^[^1-4] ]]; then

#if [[ $opcion =~ ^[^0-9] ]] || [ $opcion -lt 1 ] || [ $opcion -gt 4 ]; then

 echo "err. Elige una opcion del 1 al 4 "
 read -p "Pulse enter para seguir"
 clear

 

else
 # ini: esta partede codigo solo coge el primer carater
 # ejemplo 3rpeqr cogeria el 3 
 opcionaux="${opcion:0:1}"
 opcion=$opcionaux
 # fin

 if [ $opcion -eq 4 ]; then

  salir="1"
 
 else
  echo " "
  read -p "introduce el operando 1: " ope1
  read -p "introduce el operando 2: " ope2




  echo " "

  if [ $opcion -eq 1 ]; then
 
    suma=$(($ope1+$ope2))
    echo "Resultado de la suma: $suma"  
  fi
  if [ $opcion -eq 2 ]; then
 
    resta=$(($ope1-$ope2))
    echo "Resultado de la suma: $resta"  
  fi
  if [ $opcion -eq 3 ]; then
 

 
    multi=$(($ope1*$ope2))
    echo "Resultado de la multiplicacion: $multi"  
  fi
  
  read -p "pulse enter para seguir"
  clear
 fi
  


fi 
done

echo "saliendo ....."
sleep 4
exit 1
