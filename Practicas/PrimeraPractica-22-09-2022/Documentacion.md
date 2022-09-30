# Identificación:

Alumno: Manuel Megia

Ciclo: Desarrollo de aplicaciones multiplataforma

Centro Educativo: CES Afuera

# Objeto

Documentar la práctica 1 de la UD01 del módulo PSP de comparación de requisitos multitarea

# Ámbito

Evaluación continua del módulo DAM2-PSP en el CES Afuera (curso 22-23)

# Siglas

Si se utilizan siglas en el texto

# Enunciado

Aquí hay que poner el enunciado

# Resolución

## Prerrequisitos

| Hardware | Software |
|-|-|
|Símilar al del pc de clase| Sistema operativo|
||Vagrant
||VirtualBox
||VSCodium

## Instalación de ficheros de la máquina virtual

Pasamos las carpetas desarrollo, utilidades y VagBoxes de la carpeta compartida \\\root-305 a nuestra carpeta de PSP:
![](/Imagenes/PasoCarpetas.PNG)

## Arranque de la máquina virtual

- En la consola de comandos entramos en el directorio “VagBoxes” y después en el directorio PSP-UD01:
```
cd desktop
cd VagBoxes
cd PSP-UD01
```

- Iniciamos la maquina virtual:
```
vagrant up
```

## Instalación de SW Python para pruebas

Clickamos en el archivo "python-3.10.7-amd64.exe" para iniciar la instalacion de python, elegimos en que carpeta queremos que se instale (preferiblemente en la carpeta Desarrollo\PSP\) y damos a siguiente hasta finalizar la instalación.

## Probar el programa util\logs-tools.py

Al iniciarlo de primeras da un error por lo que debemos instalar yaml desde la consola:
```
pip install pyyaml
```
Al iniciar el programa en el log aparece:
```
[2022-09-22 09:41:11,566] DEBUG    MainThread   - Configuraci�n de debug: {'version': 1, 'formatters': {'standard': {'comment_format': '[%(asctime)s] %(levelname)-8s %(name)-12s %(threadName)-12s - %(message)s', 'format': '[%(asctime)s] %(levelname)-8s %(threadName)-12s - %(message)s'}}, 'handlers': {'file': {'level': 'DEBUG', 'class': 'logging.FileHandler', 'formatter': 'standard', 'filename': 'c:\\Users\\AlumnoM\\Desktop\\Procesos\\Desarrollo\\util\\logs_tools.log'}, 'stream': {'level': 'INFO', 'class': 'logging.StreamHandler', 'formatter': 'standard'}}, 'loggers': {'': {'handlers': ['file', 'stream'], 'level': 'DEBUG'}}}

[2022-09-22 09:41:11,566] DEBUG    MainThread   - Mensaje de depuraci�n
[2022-09-22 09:41:11,566] ERROR    MainThread   - Mensaje de error
[2022-09-22 09:41:11,567] DEBUG    MainThread   - 123
```

## Probar el software compare_multitask_types.py
Al iniciarlo en el log aparece:
```
[2022-09-22 09:42:14,717] DEBUG    MainThread   - Configuraci�n de debug: {'version': 1, 'formatters': {'standard': {'comment_format': '[%(asctime)s] %(levelname)-8s %(name)-12s %(threadName)-12s - %(message)s', 'format': '[%(asctime)s] %(levelname)-8s %(threadName)-12s - %(message)s'}}, 'handlers': {'file': {'filename': 'c:\\Users\\AlumnoM\\Desktop\\Procesos\\Desarrollo\\PSP-UD01\\compare_multitask_types.log', 'level': 'DEBUG', 'class': 'logging.FileHandler', 'formatter': 'standard'}, 'stream': {'level': 'ERROR', 'class': 'logging.StreamHandler', 'formatter': 'standard'}}, 'loggers': {'': {'handlers': ['file', 'stream'], 'level': 'DEBUG'}}}

[2022-09-22 09:42:14,717] DEBUG    MainThread   - Programa iniciado

```
Por lo que podríamos decir con seguridad que el software "compare_multitask_types.py" es mas rapido que "util\logs-tools.py"