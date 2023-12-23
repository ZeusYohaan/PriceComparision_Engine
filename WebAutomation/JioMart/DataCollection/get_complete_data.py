import time
from JioMart.auth import Auth
from selenium.common import StaleElementReferenceException, NoSuchElementException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class GetCompleteData:
    def __init__(self):
        self.Auth = Auth()
        self.driver = self.Auth.driver

    def get_complete_data(self, pincode, iterations=3):
        self.Auth.enter_website(pincode)
        data_id_dict = {}
        for i in range(1, iterations + 1):
            data_id_dict[i] = {}
        for i in range(iterations):

            product_list_finder = WebDriverWait(self.driver, 20).until(
                EC.presence_of_element_located(
                    (By.CSS_SELECTOR, 'div.ais-InfiniteHits > ol.ais-InfiniteHits-list.jm-row.jm-mb-massive'))
            )

            # Then, find the individual list items within the ol element
            product_list = product_list_finder.find_elements(By.TAG_NAME, 'li')

            for product in product_list:
                a_tag = product.find_element(By.TAG_NAME, 'a')
                unique_id = a_tag.get_attribute('id')
                parent_price_div = a_tag.find_element(By.CSS_SELECTOR, 'div.plp-card-details-wrapper')

                product_title_div = parent_price_div.find_element(By.CSS_SELECTOR, 'div.plp-card-details-name.line'
                                                                                   '-clamp.jm-body-xs.jm-fc-primary'
                                                                                   '-grey-80')

                product_title = product_title_div.text

                second_parent_price_div = parent_price_div.find_element(By.CSS_SELECTOR, 'div.plp-card-details-price')
                price_span = second_parent_price_div.find_element(By.CSS_SELECTOR, 'span.jm-heading-xxs.jm-mb-xxs')
                price = price_span.text

                data_id_dict[i + 1][unique_id] = []
                data_id_dict[i + 1][unique_id].append((product_title, price))

            self.driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")

            time.sleep(2)
        self.driver.quit()
        print(data_id_dict)
        return data_id_dict


if __name__ == "__main__":
    get_data_obj = GetCompleteData()
    get_data_obj.get_complete_data(560064)
