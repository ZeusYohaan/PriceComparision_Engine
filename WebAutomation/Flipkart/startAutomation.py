from Flipkart.DataCollection.get_complete_data import GetCompleteData
from Flipkart.DataUpload.uploadSQL import UploadSQLFlipkart

get_data_obj = GetCompleteData()
upload_sql_obj = UploadSQLFlipkart()

data_dict = get_data_obj.get_all_pages_data(560064, 3)
upload_sql_obj.updateSQlTable(data_dict)