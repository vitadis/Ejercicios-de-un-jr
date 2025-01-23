#Función par: Determina si un numero es par
par = lambda n: n%2==0

#Función que crea una lista de pares en el rango determinado por el cliente
list_par = lambda r: [x for x in range(1,r+1) if x%2==0]

#Variación de la anterior función
list_parv = lambda r: [x for x in range(1,r+1) if par(x)==True]

#Filtrar números mayores a 10
lista = [12,35,20,9,5,8,5,3,9,9,10,18]

mayor10 = list(filter(lambda x:x>10,lista))

#Convertir grados Celsius a Fahrenheit
cel_fah = lambda c: c*9/5+32

#Contar una cadena dentro de lista
listacad = ["hola","Malo"]

con_cad = list(map(lambda x: len(x),listacad))

#Multiplicar los números de una lista por un número
num_list = lambda lista, num: list(map(lambda x: x*num ,lista))

#Sumar dos listas con el mismo número de elementos
sumlist = lambda l1, l2: list(map(lambda x: x[0]+x[1], zip(l1,l2)))

#Palindromo 
palindromo = lambda palabra: palabra == palabra[::-1]

#Funcion que determina si un objeto se encuentra en una lista
buscar = lambda lista ,objeto : True if objeto in lista else False
buscar2 = lambda lista, objeto: objeto in lista

