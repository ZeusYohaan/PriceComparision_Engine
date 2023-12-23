import mysql.connector
from datetime import datetime


class UploadSQLFlipkart:
    def __init__(self):
        self.connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="2004",
            database="price_comparator"
        )
        self.cursor = self.connection.cursor()

    def getRowsByID(self, data_id):
        table_name = 'flipkart'
        query = f"SELECT * FROM {table_name} WHERE dataid = %s;"
        self.cursor.execute(query, (data_id,))
        data = self.cursor.fetchall()
        return data

    def appendRowSQL(self, data_id, type_, title, price, date):
        table_name = 'flipkart'
        query = f"INSERT INTO {table_name} (dataid, type, title, price, date) VALUES (%s, %s, %s, %s, %s);"
        values = (data_id, type_, title, price, date)
        self.cursor.execute(query, values)
        self.connection.commit()

    def updateSQlTable(self, data_dict):
        for page in data_dict.keys():
            data = data_dict[page]
            for data_id in data.keys():
                data_ls = data[data_id]
                date = datetime.now().date()
                title = data_ls[0]
                price = data_ls[1]
                rows_by_id = self.getRowsByID(data_id)
                if len(rows_by_id) == 0:
                    self.appendRowSQL(data_id, 'VEG', title, price, date)
                else:

                    append = True
                    for row in rows_by_id:
                        price_row = row[-2]
                        if price_row == price:
                            append = False

                    if append:
                        self.appendRowSQL(data_id, 'VEG', title, price, date)
        self.cursor.close()
        self.connection.close()
