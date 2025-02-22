if __name__ == "__main__":
    lados = []

    i = 0
    while i < 3:
        lados.append(float(input("Informe um valor: ")))
        i += 1

    lados_iguais = 0
    i = 0
    while i < len(lados) - 1:
        j = i + 1
        while j < len(lados):
            if lados[i] == lados[j]:
                lados_iguais += 1
            j += 1
        i += 1
    
    if lados_iguais == 0:
        print("O triângulo é do tipo equilátero")
    elif lados_iguais == 1:
        print("O triângulo é do tipo isósceles")
    elif lados_iguais == 3:
        print("O triângulo é do tipo escaleno")