import logging
from util import logcfg
import asyncio

async def hola(nombre):
    logging.info(f"Hola{nombre}")

async def add_one(n):
    return n + 1

async def main():
    result1 = await add_one(1)
    logging.info(f"result1 = {result1}")

    result2 = await add_one(100)
    logging.info(f"result2 = {result2}")

if __name__ == "__main__":
    logcfg(__file__)
    asyncio.run(main())