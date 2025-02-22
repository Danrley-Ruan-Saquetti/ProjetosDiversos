if __name__ == "__main__":
    numeros = []

    i = 0
    while i < 3: 
        numeros.append(int(input("Informe um valor: ")))
        i += 1

    maior_valor = numeros[0]
    for numero in numeros:
        if numero > maior_valor:
            maior_valor = numero

    print(maior_valor)