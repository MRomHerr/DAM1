#!/bin/bash



fichero=$(cat confinfnota.txt | grep -i fichero | cut -d "=" -f2)

if  [ ! -f $fichero ];then
 echo "el fichero: $fichero con los datos no existe"
 exit 1
 
fi


contapr="0"
contsusp="0"

nombre=""
apellido1=""
apellido2=""
nomapenota=""

rm aprobados.txt
rm suspensos.txt
rm ficheroOK.txt


cat $fichero | tail -n +2 | tr -d " " | sed '/^$/d'>ficheroOK.txt

 



while read linea;do 

 trim1=$(echo $linea | cut -d ";" -f6)
 trim2=$(echo $linea | cut -d ";" -f7)
 trim3=$(echo $linea | cut -d ";" -f8)

 nombre=$(echo $linea | cut -d ";" -f3)
 apellido1=$(echo $linea | cut -d ";" -f1)
 apellido2=$(echo $linea | cut -d ";" -f2)

 nota=$((($trim1+$trim2+$trim3)/3))
 nomapenota=$nombre";"$apellido1";"$apellido2";"$nota


 if [ $nota -ge 5 ]; then
    contapr=$(($contapr+1))
    echo $nomapenota >> aprobados.txt        
 else
    contsusp=$(($contsusp+1))
    echo $nomapenota >> suspensos.txt
    
 fi

done<ficheroOK.txt




echo "el numero de usuarios aprobados es: $contapr" 
echo "el numero de usuario suspensos es: $contsusp"
