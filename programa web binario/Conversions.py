from flask import Flask

app = Flask(__name__)

@app.route('/dec2bin/<d>')
def user(d):
    return binint((d))