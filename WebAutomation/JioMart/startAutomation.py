from JioMart.DataCollection.get_complete_data import GetCompleteData
from JioMart.DataUpload.uploadSQL import UploadSQLJioMart


get_data_obj = GetCompleteData()
upload_sql_obj = UploadSQLJioMart()

data_dict = get_data_obj.get_complete_data(560064, 3)
upload_sql_obj.updateSQlTable(data_dict)

