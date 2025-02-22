def calcularGasolina(capacidade_tanque):
    return capacidade_tanque * 3.34

def calcularEtanol(capacidade_tanque):
    return capacidade_tanque * 7.79

if __name__ == "__main__":
    opcao = 1
    while opcao == 1:
        combustivel = str(input("Informe o tipo de combustível: "))

        if combustivel == "G" or combustivel == "E":
            capacidade_tanque = float(input("Informe a capacidade do tanque (em litros): "))

            if combustivel == "G":
                print("O preço para encher o tanque de gasolina é: R$", calcularGasolina(capacidade_tanque))
            elif combustivel == "E":
                print("O preço para encher o tanque de etanol é: R$", calcularEtanol(capacidade_tanque))
        else:
            print("Valor inválido")

        opcao = int(input("Deseja calcular outro preço? 1 - para Sim: "))