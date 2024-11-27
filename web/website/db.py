from flask_sqlalchemy import SQLAlchemy
# from sqlalchemy import Integer, Column
# from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column
from init import app
import config


db = SQLAlchemy(app)


class base_model:

    # id: Mapped[Integer] = mapped_column(Integer, primary_key=True)
    # id: Integer = Column(Integer, primary_key=True)

    def  __init__(self, **kwargs):
        for key, value in kwargs.items(): self.__dict__[key] = value

    def keys(self):
        return self.__dict__.keys()

    def add(self):
        db.session.add(self)
        db.session.commit()
