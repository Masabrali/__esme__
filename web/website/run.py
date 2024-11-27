from init import app
import config
from db import db
import models
import views
import controllers
import urls


if __name__ == '__main__':
    try:
        with app.app_context():
            db.create_all()
            app.run(host="0.0.0.0", port=8097, debug=True)
    except Exception as e:
        print(e)
        app.run(host="0.0.0.0", port=8097, debug=True)