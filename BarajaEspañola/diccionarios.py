import yaml
from pprint import pprint

if __name__ == "__main__":
    with open("resultado.yml") as dfile:
        dstr = dfile.read()
    d = yaml.safe_load(dstr)
    pprint(d)
    d['resultado']['dados'][7] = 354235
    pprint(d)
    print(f'Las claves de d son {d.keys()}')

    #if 3 in resultado['resultado']['moneda']['cara']:
    #    d['resultado']['dados']['cara'][3] = 1
    #    d['resultado']['dados']['cruz'][7] = 1
    
    #else:
    #    d['resultado']['dados']['cara'][3] +=1
    #    d['resultado']['dados']['cruz'][7] += 1
    d['resultado']['dados']['cara'][0] = d['resultado']['dados']['cara'].get(0, 0) + 1
    d['resultado']['dados']['cruz'][10] = d['resultado']['dados']['cruz'].get(10, 0) + 1
    pprint(d)