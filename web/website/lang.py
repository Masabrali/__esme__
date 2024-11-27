from sqlalchemy import Column, Integer, String
from db import db, base_model
from config import language_table, default_language


lang: dict = {
    'en': {
        'welcome': 'Welcome',
        'goToApp': 'Go To App',
        'allRightsReserved': 'All Rignts Reserved',
    },
    'sw': {
        'welcome': 'Karibu',
        'goToApp': 'Nenda Kwenye Mfumo',
        'allRightsReserved': 'Haki zote zimehifadhiwa',
    }
}


class language(base_model, db.Model):

    __tablename__ = language_table

    id: Integer = Column(Integer, primary_key=True)
    language: String = Column(String(6), index=True) 
    key: String = Column(String, index=True)
    value: String = Column(String)

    def __init__(self, language):
        self.set_language(language)

    def set_language(self, language):
        self.language = language

    def get(self, key, lang = None):
        if not lang: lang = self.language
        try:
            return language.query.filter_by(language=lang, key=key).one().value
        except Exception as e:
            print(e)
            return language.query.filter_by(language=default_language, key=key).one().value

