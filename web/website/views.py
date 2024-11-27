from flask import render_template
import datetime
from config import static_url
from lang import lang as _lang, language
from config import default_language


def view(template, lang_key: str=None, **kwargs):
    _language = language(lang_key)
    return render_template(template, lang=_language.get, lang_key=lang_key, static_url=static_url, copyrightYear=datetime.datetime.now().date().strftime("%Y"), **kwargs)
    # return render_template(template, lang=_lang[lang_key], lang_key=lang_key, static_url=static_url, copyrightYear=datetime.datetime.now().date().strftime("%Y"))