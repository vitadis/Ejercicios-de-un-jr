from typing import Callable
import random

def Calculadora_basic(*nums:int) -> int:
    """
    Puedes ingresar multiples argumentos separados de comas.
    
    Bucle:
        input:
            Le pedimos seleccionar la operación en caso de que no sea la correcta llamara a la función, repitiendo así el bucle.

        Según el input
            La resolución será de suma,resta,multiplicación y división.

        break:
            Si la operación se realizo correctamente el bucle se cierra.
    
    Observaciones:
        No se detecto ninguna manera que la funcion optenga error, amenos que el dígito ingresado no sea un int o float.
    """
    while True:
        var = input("Dime la operación (+,-,*,/): ")
        match var:
            case "+":
                print(sum(nums))
            case "-":
                resultado = nums[0]
                for x in nums[1:]:resultado -= x
                print(resultado)
            case "*":
                resultado = nums[0]
                for x in nums[1:]:resultado *= x
                print(resultado)
            case "/":
                resultado = nums[0]
                for x in nums[1:]:resultado /= x
                print(resultado)
            case _: 
                print("Ingresa la operación correctamente")
                Calculadora_basic(nums)
        break 

def palindromo(palabra:str):
    "Ingresa una palabra y determinara si es un palíndromo independientemente de la mayuscula o minuscula."
    palabra = palabra.lower()
    if palabra == palabra[::-1]:return True
    else: return False

def contar_palabra(texto:str,palabra:str):
    """
    Ingresa el Texto, posteriormente la palabra que quieres ver cuantas veces
    se repite, este te devolvera la palabra independientemente de que sea minuscula o mayuscula.
    Ejemplo:
        contar_palabra("Jajajaja como esta el marcelino","ja")
    """
    return texto.lower().count(palabra.lower())

def ordenar_lista(lista:list,parametro:str):
    """
    Agrega una lista de números posteriormente dinos el parametro del filtro que son los siguientes:
    Mayor, Menor
    Según el filtro que cojas se ordenará de una manera u otra.
    """
    if parametro == "Mayor": lista.sort(reverse=True);return lista
    elif parametro == "Menor": lista.sort();return lista
    else: return None

def multiplicacion(multiplicador:int,rango:int):
    """
    Esta función te devolvera una lista con el rango elegido, el indice de la lista será el número con 
    el que se multiplico ejemplo:
        multiplicacion(2,8) --> [0,2,4,6,8,10,12,14,16] 
        
        Por ende
            lista[3] = 6
    """
    lista = []
    for x in range(rango+1):lista.append(x*multiplicador)
    return lista

#Maximo y minimo de una lista sin usar las funciones ya creadas

def op_lista(lista:list,filtro:str):
    """
    Esta función requiere una lista y como 2do parámetro el tipo de filtrado
    que en este caso son:
        Min,Max --> Se piensa incorporar  funciones
    """
    inicio = lista[0]
    if filtro=="Min":
        for x in lista[1:]:
            if x<inicio: inicio=x
    elif filtro=="Max":
        for x in lista[1:]:
            if x>inicio: inicio=x
    else: return None
    return float(inicio)

a_bisiesto = lambda a: a%4==0 # type: Callable[[int], bool]

def generador_contraseña(longitud:int):
    """
    Agrega una longitud de laa contraseña, posteriormente se generara una 
    completamente al azar de los caracteres con los que contamos.
    
    """
    caracteres = str("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~")
    return "".join(random.choice(caracteres) for _ in range(longitud))
