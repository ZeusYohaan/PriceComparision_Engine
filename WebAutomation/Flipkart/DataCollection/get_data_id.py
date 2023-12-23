from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class GetDataID:
    def __init__(self, auth):
        self.auth = auth

    def get_data_id(self, url):
        self.auth.driver.get(url)
        WebDriverWait(self.auth.driver, 10).until(
            lambda d: d.execute_script("return document.readyState") == "complete", self.auth.driver
        )

        WebDriverWait(self.auth.driver, 10).until(
            EC.presence_of_element_located((By.CSS_SELECTOR, '._1YokD2._3Mn1Gg.col-12-12'))
        )

        outermost_div = WebDriverWait(self.auth.driver, 10).until(
            EC.presence_of_element_located((By.CSS_SELECTOR, '._1YokD2._3Mn1Gg.col-12-12'))
        )

        nested_divs = outermost_div.find_elements(By.CSS_SELECTOR, '._1AtVbE.col-12-12')

        data_ids = []

        for div in nested_divs:
            for data_id in div.find_elements(By.CSS_SELECTOR, '[data-id]'):
                d_id = data_id.get_attribute('data-id')
                data_ids.append(d_id)

        return data_ids
