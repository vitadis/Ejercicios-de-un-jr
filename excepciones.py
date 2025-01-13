def exc_intput(inputt):
    """
    Esta función requiere el texto del input para un int,
    produciendo una excepcion en caso de que el dato ingresado por el usuario
    sea otro tipo de dato.
    
    """
    while True:
        try:
            var = int(input(inputt))
            break
        except:
            print("Agrega un numero entero")
    return var

def whileS_N(funcion):
    "Agrega una funcion que quieras mantener en bucle,\n\n que te pregunte si quieres continuar"    
    def funcion_0(*args, **kwargs):
        salir = ""
        while salir.lower() != "s":
            funcion(*args, **kwargs)
            salir = input("Deseas salir s/n: ")
    return funcion_0
