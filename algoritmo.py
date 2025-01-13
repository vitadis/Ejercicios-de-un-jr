def fibonacci(num:int)->int:
    """
    Fórmula de la función:
        f(n) = {0 -> n==0; 1 -> n==1;f(n-1) + f(n-2) -> n>1}
    
    Notas:
        No suele ser la manera más óptima de replicar el algoritmo fibonacci, ya que llamamos varias veces a la misma función.
        Lo que para rangos más altos se sobrecargara el tiempo ejecución.
    """
    if num == 0 or num == 1: return num
    else:
        return fibonacci(num-1) + fibonacci(num-2)

#Función que depende de la existencia de fibonacci
def lista_fibo(rango:int):
    "Ingresa el rango del algoritmo fibonacci, posteriormente se te entregara una lista."
    
    lista = []
    for x in range(rango):
        lista.append(fibonacci(x))
    return lista


def new_fibonacci(num:int,tipo:str)-> (int | list | None):
    """
    Agrega el número fibonacci que deseas visualizar "recuerda que el número no tiene que ser negativo ni 0", posteriormente escribe 
    en que tipo de dato quieres que te devolvamos que son "int" o "list".
    "int" = Formato número
    "list" = Retorna la lista hasta el número ingresado
    
    Notas:
        Se uso la misma fórmula pero en vez de llamar a una función llamamos a una lista, lo cual hace que el mismo responda más rapido y por ende
        es mucho más eficiente y rapido en responder.
            f(n) = {0 -> n==0; 1 -> n==1;f(n-1) + f(n-2) -> n>1}
    """
    lista = [0,1]
    for x in range(2,num):
        lista.append(lista[x-1]+lista[x-2])       
    if num<=0: return None
    elif tipo == "int":
        return lista[num-1] 
    elif tipo == "list": return lista
    else: return None

#Esta función es necesaria para ejecutar el algoritmo de Euclides Extendido
def mcd(nums:tuple)->int:
    """
    Ejemplo de input = (10,2)
    """
    
    lista = [9,8,7,6,5,4,3,2,1]
    for x in lista:
        if nums[0]%x==0 and nums[1]%x==0:
            return x

#Incompleto
def EuExt(nums:tuple,inv:int):
    """
    Es necesario que el mcd de los numeros ingresados sea 1,
    de lo contrario la función no se desarrollará y retornara un None.
    
    inv = 1 (Para sacar la inv del 1er dígito)
    inv = 2 (Para el 2do dígito)
    
    Para esta función se uso la siguiente formula y esta se guardara en una lista:
    
    Hacer (g0,g1,u0,u1,v0,v1,i) = (b,a,1,0,0,1,1)
    
    Mientras g1 =! 0 hacer:
        hacer yi+1 = 
    
    """
    inv = inv-1
    a = nums[inv]
    b = nums[1] if inv==0 else nums[0]
    if mcd(nums)==1:
        var = ['i','y','g','u','v']
        lista = [{'i':0,'y':None,'g':b,'u':1,'v':0},{'i':0,'y':None,'g':b,'u':1,'v':0}]
    else: return None
