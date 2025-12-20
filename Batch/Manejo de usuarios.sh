#!/bin/bash
cd REPARACIONES
menu() {
clear
echo """MENU
1. Alta de clientes
2. Modificar clientes
3. Baja de clientes
4. Listado de clientes
5. Entrada de material en masa
6. Salida de material en masa
7. Listado de material
8. Bloqueo de carpeta clientes
9. Desbloqueo de carpeta clientes
10. Salir
"""
read -p "Elige una opción: " opcion
case $opcion in
1)altacli;;
2)modicli;;
3)bajalon;;
4)listcli;;
5)Materialobli;;
6)matsal;;
7)listma;;
8)bloq;;
9)bloqdes;;
10)sali;;
*)echo "Sabes escribir?"
sleep 1
menu
;;
esac
}
altacli() {
clear
echo "Alta de cliente"
read -p "DNI: " dnia
read -p "Nombre: " nomba
read -p "Apellidos: " aplla
read -p "Dirección: " dira
read -p "Localidad: " locaa
if ls ./CLIENTES/$dnia.txt; then
echo "El fichero ya existe :)"
else
clear
echo """DNI: $dnia
Nombre: $nomba
Apellidos: $aplla
Dirección: $dira
Localidad: $locaa
""">>./CLIENTES/$dnia.txt
echo "Se creo tu archivo correctamente :)"
fi
read -p "Deseas realizar otra operacion (s=1/n=2): " desea
if [ $desea -eq 1 ]; then
altacli
elif [ $desea -eq 2 ]; then
menu
fi
}
modicli() {
clear
echo "Modificar clientes"
read -p "Dime el DNI del cliente: " dnimod
echo "Introduce datos nuevos"
read -p "DNI: " dniamod
read -p "Nombre: " nombamod
read -p "Apellidos: " apllamod
read -p "Dirección: " diramod
read -p "Localidad: " locaamod
rm ./CLIENTES/$dnimod.txt
echo """DNI: $dniamod
Nombre: $nombamod
Apellidos: $apllamod
Dirección: $diramod
Localidad: $locaamod""">>./CLIENTES/$dniamod.txt
read -p "Deseas realizar otra operacion (s=1/n=2): " deseb
if [ $deseb -eq 1 ]; then
modicli
elif [ $deseb -eq 2 ]; then
menu
fi
}
bajalon() {
clear
echo "Baja de clientes"
read -p "Cual es el DNI del cliente: " clienba
if rm ./CLIENTES/$clienba.txt; then
echo "Archivo borrado"
else
echo "El Archivo no existe"
fi
read -p "Deseas realizar otra operacion (s=1/n=2): " desec
if [ $desec -eq 1 ]; then
bajalon
elif [ $desec -eq 2 ]; then
menu
fi
}
listcli() {
clear
echo "Listado del cliente"
read -p "DNI del cliente: " clienlis
cat ./CLIENTES/$clienlis.txt
read -p "Deseas ver otros datos del clientes? (s=1/n=2): " desed
if [ $desed -eq 1 ]; then
listcli
elif [ $desed -eq 2 ]; then
menu
fi
}
Materialobli() {
clear
echo "Entrada de material"
read -p "Introduce el primer codigo: " prim
read -p "Introduce el ultimo codigo: " ult
read -p "Que tipo de material es PANTALLAS,TECLADOS... (mayusculas): " tipq
for i in $(seq $prim $ult);
do
echo >./MATERIAL/$tipq/$i.txt
done
read -p "Deseas realizar otra operacion? (s=1/n=2): " desee
if [ $desee -eq 1 ]; then
Materialobli
elif [ $desee -eq 2 ]; then
menu
fi
}
matsal() {
clear
echo "Salida de material"
read -p "Introduce el primer codigo: " primsa
read -p "Introduce el ultimo codigo: " ultsa
read -p "Que tipo de material es PANTALLAS,TECLADOS... (mayusculas): " tipsa
for l in $(seq $primsa $ultsa);
do
rm ./MATERIAL/$tipsa/$l.txt
done
read -p "Hay mas salida de materiales s=1 n=2: " deser
if [ $deser -eq 1 ]; then        
matsal
elif [ $deser -eq 2 ]; then          
menu
fi
}
listma() {
clear
echo "listado del material"
read -p "Que material desea comprobar PANTALLAS,TECLADOS... (mayusculas): " complis
ls ./MATERIAL/$complis
read -p "Desea comprobar mas material s=1 n=2: " deset
if [ $deset -eq 1 ]; then        
listma
elif [ $deset -eq 2 ]; then          
menu
fi
}
bloq() {
echo "no lo hice"
sleep 1
menu
}
bloqdes() {
echo "tampoco lo hice"
sleep 1
menu
}
sali() {
echo "Hasta otra"
sleep 1
exit
}
menu


