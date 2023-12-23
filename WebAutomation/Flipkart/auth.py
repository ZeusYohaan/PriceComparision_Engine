import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.edge.service import Service
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class Auth:
    def __init__(self):
        self.driver_path = r'C:\SeleniumDrivers\msedgedriver.exe'
        self.url = ("https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid"
                    "=M_bca543eb-a850-47c4-8249-2dad73f0344d_1_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker"
                    "=hp_rich_navigation_1_1.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1"
                    "=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L0_view-all"
                    "&cid=CBUR1Q46W5F1")
        self.veg_url = ("https://www.flipkart.com/grocery/~cs-czmflnl4er/pr?sid=73z&marketplace=GROCERY&collection-tab"
                        "-name=All+Fruits+and+Vegetables&fm=neo%2Fmerchandising&iid=M_b2910473-5a10-4d03-81b1"
                        "-293837c81802_2_G211C67CJ4GB_MC.EG1QZHPQIGJQ&otracker=clp_rich_navigation_2_2.navigationCard"
                        ".RICH_NAVIGATION_Fruits%2B%2526%2BVegetables~Fruits%2B%2526%2BVegetables~Fruits%2B%2526"
                        "%2BVegetables_grocery-supermart-store_EG1QZHPQIGJQ&otracker1=clp_rich_navigation_PINNED_neo"
                        "%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=EG1QZHPQIGJQ")
        options = webdriver.EdgeOptions()
        options.headless = True
        self.driver = webdriver.Edge(service=Service(executable_path=self.driver_path), options=options)

    def enter_website(self, pincode):
        self.driver.get(self.url)

        pincode_input = WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, '_166SQN'))
        )

        pincode_input.send_keys(pincode)
        pincode_input.submit()
        time.sleep(2)





