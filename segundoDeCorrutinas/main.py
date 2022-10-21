import random
import asyncio

espera = random.randint(0, 5)


def tirar_dado():
    return random.randint(1, 6)


def tirar_n_dados(n):
    cho = 0
    for _ in range(n):
        cho += tirar_dado()
    return cho

async def main():
    print("hola")
    await asyncio.sleep(espera)
    print(tirar_n_dados(3))

if __name__ == "__main__":
    asyncio.run(main())

class Jugador():
    def huevodeorangutan():
        print("jaja huevos")
