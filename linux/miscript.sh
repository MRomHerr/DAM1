#!/bin/bash

#La línea #!/bin/bash siempre hay que ponerla para decirle al terminal que programa interpreta el script

#Esto es un comentario no aparece por pantalla
#echo muestra mensajes por la pantalla. NO escribir ni acentos, ni ñ.
echo -----------------------------------
echo MI PRIMER SCRIPT DE LINUX
echo -----------------------------------

#DECLARACION DE VARIABLES

#1 VARIABLES POR TECLADO

read -p "Introduce tu nombre: " nombreusu
#Para poder usar una variable, mostrar su contenido, pongo un $ delante
echo "El valor de la variable nombreusu es: $nombreusu" 

#2 VARIABLES INTERNAS
#Si guardo texto hay que poner " "
ciclo="SRMC"
modulo="Sistemas Operativos Monopuesto"
grupo=3

echo " "
echo "Estas matriculado en el ciclo $ciclo"
echo "Estas en la clase $modulo y en el grupo $grupo"
echo " "

#3 VARIALBES POR ENTRADA SCRIPT
#son las variables que se meten a la vez que se ejecuta el script

# $0 saca el nombre del script
echo "El script se llama: " $0

# $* saca la cadena de los parametos de entrada
echo "La cadena de los valores de entrada: " $*

# $# saca el numero de parametros de entrada
echo "Se han introducido este numero de parametros: " $#

# $? muestra si la salida del ultimo operando ejecutado fue exitosa
echo "La ultima ejecución del comando fue: " $?

# $numero saca los valores que se meten con la ejecucion del script
#Hay desde $1 hasta $7
echo "El primer parametro es: " $1

#4 EJECUTAR COMANDOS
# Se pone directamente el comando

echo "este es el contenido del directorio"
ls -l

# Guardar ejecucion de un comando en una variable
# nombrevariable=$(comando a ejecutar)
# otra forma para versiones antiguas Linux -> nombrevariable=`comando a ejecutar`

usulog=$(whoami)
echo " "
echo "eres el usuario: " $usulog 
echo " "
fecha=$(date)
echo "esta es la hora: " $fecha

#5 SENTENCIAS CONDICIONALES IF
# IF Comparar texto se pone cadena == cadena2. OJO NO PONER UN SOLO =
if [ $nombreusu == "carlos" ]; then
	echo "eres el profesor"
else
	echo "eres un alumno"
	exit 0
	
fi

#IF anidado
if [ $nombreusu == "carlos" ]; then
	echo "eres el profesor"
elif [ $nombreusu == "ana" ]; then
	echo "eres la profesora"
else
	echo "eres un alumno"
	exit 0
fi

# OR -> || con que se cumpla una de las comparaciones entra por el then
if [ $nombreusu == "carlos" ] || [ $nombreusu == "sergio" ] ; then
	echo "eres el profesor"
else
	echo "eres un alumno"
	
fi

echo " "

#AND -> && se tiene que cumplir las dos comparaciones para que entre en el then
if [ $1 == "luffy" ] && [ $2 == "sombrero" ]; then

	echo "Goma Goma nooooommm"

else

	echo "Eres un falso lufi"
fi

clear

#IF PARA COMPARAR NUMEROS
# No se usa el == sino las sentencias: 
# -eq (igual) -lt (menor) -gt (mayor) -le (meno o igual) -ge (mayo o igual)
# exit hace que el codigo salga del script. 0 para indicar que ha salido haciendo las cosas bien, 1 para indicar que ha salido con errores

if [ $# -eq 2 ]; then
	echo "numero de parametros correctos"
	
	exit 0
else
	echo "tienes que meter 2 parametros, ni mas ni menos."
	
	exit 1
fi

clear

read -p "Mete tu nota: " notalum

if [ $notalum -lt 5 ]; then
	echo "has suspendido"
else
	echo "has arpobado"
fi



#IF PARA COMPROBAR DIRECTORIOS Y FICHEROS
clear
read -p "pon un directorio valido: " directorio
read -p "pon un fichero valido: " fichero

if [ -d $directorio ]; then

	echo "existe el dictorio"
	
	if [ -f $fichero ]; then

		echo "existe el fichero"
	else
		echo "no existe el fichero"
	fi 


else
	echo "directorio no valido"
fi


#VARIABLE DE ENTORNO. Algunas útiles
#$UID id del usuario logeado
#$HOME home del usuario logeado
#$USER nombre del usuario logeado
if [ $UID -ne 0 ] ; then
	echo "Necesitas permisos de root para ejecutar este script!"
	exit 1
fi





##6 CONCATENAR VARIABLES
clear
midirectorio="/home/profesor"
mifichero="entradascript.txt"

mirutafich=$midirectorio"/"$mifichero
echo  "el contenido de la variable mirutafich: " $mirutafich

if [ -f $mirutafich ]; then
	ls -l $mirutafich
fi

#7 Ejececutar operaciones aritmeticas
clear
read -p "dame el primer sumando: " sum1
read -p "dame el segundo sumando: " sum2
resultado=$(($sum1+$sum2))
echo "el resultado de $sum1 + $sum2 es: " $resultado





#8Bucles
#8.1 WHILE. Se ejecuta mientras la condicion sea verdadera
# Dentro del bucle tiene que haber un momento que cambie la condicion a falsa

clear
contador=0
auxuno=1
auxcinco=5

#Muestra tantos "hola" por pantalla como número le indique en la variable auxcinco
while [ $contador -lt $auxcinco ]; do

	echo "hola"
	auxcont=$contador
	contador=$(( $auxcont + $auxuno))
	echo $contador

done


#Ejemplo para crear un menu
salir="no"
while [ $salir == "no" ]; do
clear
	echo ++++++++++++++++++++++Menu Operaciones ++++++++++++++++
	read -p "mete un numero: " numusu
	read -p "mete otro numero: " numusu2
	echo " "
	echo "1. Sumar"
	echo "2. Multiplicar: "
	
	read -p "elige una de las dos opciones: " opcion

	if [ $opcion -gt 2 ]; then
		echo "recuerda opcion 1 o 2"
	
	else 

		if [ $opcion -eq 1 ]; then
		
			suma=$(($numusu+$numusu2))
			echo "has elegido sumar los numeros y el resultado es: " $suma
		fi  


		if [ $opcion -eq 2 ]; then

			multi=$(($numusu*numusu2))
			echo "has elegido multiplicar los numeros y el resulrado es: " $multi
		fi

	fi

	read -p "Quieres salir del menu?? (si|no): " salir 
	
done


#8.2 FOR el bucle se ejecuta de principio a fin
# no puedo salir cuando yo quiera
# este for me lee palabra por palabra,no linea por linea

clear
echo "mostrando for"
contador=0
for linea in $(ls -l); do
	echo "numero linea " $contador
	echo $linea
	contador=$(($contador+1))
done

echo "segundo for leyendo fichero"

for linea in $(cat entrada.txt); do

	echo $linea
done


#8.3 bucle para leer comando o fichero linea por linea
clear
echo "leyendo fichero o comando linea por linea"
while read linea; do

	echo $linea

done < entrada.txt

echo ""
ls -l > lsfich.txt

while read linea; do

	echo $linea
done < lsfich.txt
