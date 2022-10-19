import yaml
from pprint import pprint
import random
import matplotlib.pyplot as plt

vmonedas = ["cara", "cruz"]
NEXPERIMENTOS = 50000


def tirar_moneda():
    return random.choice(vmonedas)


def tirar_n_monedas(n):
    res_dict = {}
    for _ in range(n):
        v = tirar_moneda()
        res_dict[v] = res_dict.get(v, 0) + 1
    return res_dict


def tirar_dado():
    return random.randint(1, 6)


def tirar_n_dados(n):
    cho = 0
    for _ in range(n):
        cho += tirar_dado()
    return cho


if __name__ == "__main__":
    with open("resultado.yml") as dfile:
        dstr = dfile.read()
    d = yaml.safe_load(dstr)

    for _ in range(NEXPERIMENTOS):
        rmon = tirar_n_monedas(10)
        tdad = tirar_n_dados(3)
        d['resultado']['dados'][tdad] += 1
        d['resultado']['moneda']['cara'][rmon.get("cara", 0)] += 1
        d['resultado']['moneda']['cruz'][rmon.get("cruz", 0)] += 1
    pprint(d)

dcaras = d['resultado']['moneda']['cara']
pprint(dcaras)
dcx = sorted(dcaras.keys)
print(dcx)

dcy = []
for x in dcx:
    dcy.append(dcaras(x))

dcy = [dcaras[x] for x in dcx]
print(dcy)
pit.figure()
pit.plot(dcx, dcy)
pit.xlabel("Nº de ocurrencias")
pit.ylabel("Nº de veces")
pit.show
