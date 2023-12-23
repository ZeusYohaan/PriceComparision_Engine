from selenium.common import StaleElementReferenceException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class GetDataFromId:
    def __init__(self, auth):
        self.auth = auth

    def get_data_from_id(self, v_id):
        parent_div = WebDriverWait(self.auth.driver, 20).until(
            EC.presence_of_element_located((By.CSS_SELECTOR, f'div[data-id="{v_id}"]'))
        )

        title_div = parent_div.find_element(By.CSS_SELECTOR, 'a div._1MbXnE')
        title = title_div.text

        price_div = parent_div.find_element(By.CSS_SELECTOR, 'div._30jeq3')
        price = price_div.text

        return title, price
