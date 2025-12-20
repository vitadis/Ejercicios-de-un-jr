@echo off
:: Script para manejo de usuarios
:: Este script solicita los datos de un usuario y guarda los datos en un archivo con el DNI como nombre del fichero.

:: Pedir los datos del usuario
set /p nombre=Introduce el nombre del usuario: 
set /p apellidos=Introduce los apellidos del usuario: 
set /p dni=Introduce el DNI del usuario: 
set /p direccion=Introduce la dirección del usuario: 
set /p telefono=Introduce el teléfono del usuario: 

:: Crear una carpeta para los usuarios si no existe
if not exist "usuarios" (
    mkdir usuarios
)

:: Crear el archivo con el nombre del DNI y extensión .txt
echo Nombre: %nombre% > usuarios\%dni%.txt
echo Apellidos: %apellidos% >> usuarios\%dni%.txt
echo DNI: %dni% >> usuarios\%dni%.txt
echo Dirección: %direccion% >> usuarios\%dni%.txt
echo Teléfono: %telefono% >> usuarios\%dni%.txt

echo Los datos del usuario han sido guardados en usuarios\%dni%.txt
pause
