def calcular_peso_ideal_M(altura):
    return (72.7 * altura) - 58

def calcular_peso_ideal_F(altura):
    return (62.1 * altura) - 44.72

if __name__ == "__main__":
    sexo = input("Informe o seu sexo (f/m): ")

    if sexo == "f" or sexo == "m":
        altura = float(input("Informe a sua altura: "))

        if sexo =="f":
            print("Seu peso ideal é: ", calcular_peso_ideal_F(altura))
        elif sexo == "m":
            print("Seu peso ideal é: ", calcular_peso_ideal_M(altura))

    else:
        print("Valor inválido")