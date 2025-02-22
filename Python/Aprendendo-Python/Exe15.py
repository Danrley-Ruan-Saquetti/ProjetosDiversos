if __name__ == "__main__":
    numero = int(input("Informe um valor: "))

    if numero > 0:
        if numero % 2 == 0:
            print("O valor ", numero, " é positivo e par")
        else:
            print("O valor ", numero, " é positivo e ímpar")
    elif numero < 0:
        if numero % 2 == 0:
            print("O valor ", numero, " é negativo e par")
        else:
            print("O valor ", numero, " é negativo e ímpar")