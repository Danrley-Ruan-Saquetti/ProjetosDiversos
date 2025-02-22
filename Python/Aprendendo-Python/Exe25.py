AULAS_SEMESTRE = 80 # aulas
TAXA_LIMITE = 25 # porcento
FALTAS_MAXIMA = round((AULAS_SEMESTRE * TAXA_LIMITE) / 100) # máximo de faltas permitido
NUMERO_NOTAS = 3
MEDIA_APROVACAO = 7 # média mínima para ser aprovado

if __name__ == "__main__":
    print(FALTAS_MAXIMA)
    opcao = 1
    while opcao == 1:
        nome = str(input("informe o nome do aluno: "))
        notas = []

        i = 0
        while i < NUMERO_NOTAS:
            notas.append(float(input("Informe uma nota: ")))
            i += 1
        
        faltas = int(input("Informe o número de faltas do aluno: "))

        media = 0
        for nota in notas:
            media += nota
            
        media /= len(notas)

        if FALTAS_MAXIMA >= faltas:
            if media >= MEDIA_APROVACAO:
                print("Aprovado")
            else:
                print("Reprovado por Média")
        else:
            print("Reprovado por Falta")
        
        opcao = int(input("Deseja verificar a situação final de outro aluno? 1 - para Sim: "))