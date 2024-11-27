from flask import Flask, current_app as app, render_template, redirect
import datetime
from lang import lang as _lang


app = Flask(__name__)

static_url = 'static'

def render(template, lang_key: str):
    return render_template(template, lang=_lang[lang_key], lang_key=lang_key, static_url=static_url, copyrightYear=datetime.datetime.now().date().strftime("%Y"))

@app.route('/<lang_key>')
def index(lang_key):
    return render('index.html', lang_key)

@app.route('/')
def default_index():
    return redirect('/sw')


if __name__ == '__main__':
    app.run(port=8097, debug=True)