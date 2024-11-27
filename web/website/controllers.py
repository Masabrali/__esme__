from flask import redirect
# from models import strings
from views import view
from config import default_language, auth_url


class index:
    def index(lang_key):
        return view('index.html', lang_key, auth_url=auth_url)

    def default_index():
        return redirect('/' + default_language)