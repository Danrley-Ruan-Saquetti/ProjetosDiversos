def calcularR(a, b):
    return (a + b) ** 2

def calcularS(b, c):
    return (b + c) ** 2

def calcularD(a, b, c):
    return ((calcularR(a, b) + calcularS(b, c)) / 2)

if __name__ == "__main__":
    A = int(input("Informe um valor A: "))
    B = int(input("Informe um valor B: "))
    C = int(input("Informe um valor C: "))

    print("D = ", calcularD(A, B, C))