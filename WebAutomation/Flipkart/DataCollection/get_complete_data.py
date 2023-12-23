from Flipkart.auth import Auth
from Flipkart.DataCollection.get_data_id import GetDataID
from Flipkart.DataCollection.get_object_data import GetDataFromId


class GetCompleteData:

    def __init__(self):
        self.auth = Auth()
        self.driver = self.auth.driver
        self.veg_url = ("https://www.flipkart.com/grocery/~cs-czmflnl4er/pr?sid=73z&marketplace=GROCERY&collection-tab"
                        "-name=All+Fruits+and+Vegetables&fm=neo%2Fmerchandising&iid=M_b2910473-5a10-4d03-81b1"
                        "-293837c81802_2_G211C67CJ4GB_MC.EG1QZHPQIGJQ&otracker=clp_rich_navigation_2_2.navigationCard"
                        ".RICH_NAVIGATION_Fruits%2B%2526%2BVegetables~Fruits%2B%2526%2BVegetables~Fruits%2B%2526"
                        "%2BVegetables_grocery-supermart-store_EG1QZHPQIGJQ&otracker1=clp_rich_navigation_PINNED_neo"
                        "%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=EG1QZHPQIGJQ&page={num}")
        self.get_data_id = GetDataID(self.auth)
        self.get_object_data = GetDataFromId(self.auth)

    def get_all_pages_data(self, pincode, num):
        self.auth.enter_website(pincode)
        page_id_dict = {"1": {}, "2": {}, "3": {}}
        for i in range(1, num + 1):
            url = self.veg_url.format(num=i)
            str_pg = f"{i}"
            data_id_ls = self.get_data_id.get_data_id(url)
            pg_data = {}
            for j in data_id_ls:
                pg_data[j] = self.get_object_data.get_data_from_id(j)
            page_id_dict[str_pg] = pg_data

        print(page_id_dict)
        self.driver.quit()
        return page_id_dict


if __name__ == "__main__":
    get_complete_data_obj = GetCompleteData()
    get_complete_data_obj.get_all_pages_data(560064, 3)
