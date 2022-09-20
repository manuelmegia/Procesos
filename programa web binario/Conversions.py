from flask import Flask

app = Flask(__name__)

@app.route('/dec2bin/<d>')
def user(d):
    return binint((d))

if __name__ == "__main__":
    logcfg(__file__)
    log.error("Mensaje de error")

REQUESTS = [f'http:/192.168.56.203:5000/dec2bin/{x}' for x in range(5_000)]