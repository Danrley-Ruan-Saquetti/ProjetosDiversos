from hashlib import sha256
import time

def aplicar_sha256(texto):
    return sha256(texto.encode("ascii")).hexdigest()

def minerar(num_bloco, transacoes, hash_anterior, qtd_zeros):
    nonce = 0

    while True:
        texto = str(num_bloco) + transacoes + hash_anterior, + str(nonce)
        meu_hash = aplicar_sha256(texto)

        if meu_hash.startswith("0" * qtd_zeros):
            return nonce, meu_hash

        nonce += 1

if __name__ == "__main__":
    num_bloco = 15
    transacoes = """
    Lira->Alon-10
    Alon->Joao->5
    Joao->Amanda->11"""
    qtd_zeros = 4
    hash_anterior = "abc"

    resultado = minerar(num_bloco, transacoes, hash_anterior, qtd_zeros)