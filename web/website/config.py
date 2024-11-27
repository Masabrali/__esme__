from init import app

app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///project.db"
app.config['SECRET_KEY'] = app.secret_key

static_url = 'static'
language_table = 'language'
default_language = 'sw'

auth_url = "http://localhost:1234"