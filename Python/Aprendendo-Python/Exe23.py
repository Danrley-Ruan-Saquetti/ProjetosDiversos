if __name__ == "__main__":
    A = float(input("informe um valor A: "))
    B = float(input("informe um valor B: "))

    if A % B == 0:
        print(A, "é divisível por", B)
    else:
        print(A, "não é divisível por", B)