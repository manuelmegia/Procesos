import random
import pprint

palos = ["oros", "copas", "espadas", "bastos"]

valores = [x for x in range(1, 13) if x <= 7 or x >= 10]

cartas = [(p, v) for p in palos for v in valores]

NEXPERIMENTOS = 1_000_000
NTIRADAS = 3

def experimento_cartas():
    res_experimento = {}
    for _ in range(NEXPERIMENTOS):
        res_tir = tirada_cartas()
        res_experimento = suma_res_tirada(res_experimento, res_tir)
    return res_experimento


def tirada_cartas():
    tirada = random.sample(cartas, 2)
    res_tirada = 0
    for carta in tirada:
        res_tirada += carta[1]
    return res_tirada

def suma_res_experimento(res, exp):
    for k in exp.keys():
        antiguo = res.get(k, 0)
        res[k] = antiguo + exp[k]
    return res

def suma_res_tirada(res, tir):
    antiguo = res.get(tir)
    res[tir] = antiguo + 1
    return res

def main():
    resultado_prov = {}
    for _ in range(NEXPERIMENTOS):
        res_exp = experimento_cartas()
        resultado_prov = suma_res_experimento(resultado_prov, res_exp)
    print(resultado_prov)


if __name__ == "__main__":
    main()