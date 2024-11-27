from init import app
from controllers import *


urls: list[list] = [
    ('/<lang_key>', 'index', index.index),
    ('/', 'default_index', index.default_index)
]


for url in urls:
    try: app.add_url_rule(*url, methods=url[3])
    except Exception as e: app.add_url_rule(*url)