import time
from selenium.webdriver.edge.service import Service
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class Auth:
    def __init__(self):
        self.driver_path = r'C:\SeleniumDrivers\msedgedriver.exe'
        self.driver = webdriver.Edge(service=Service(executable_path=self.driver_path))
        self.entry_url = ('https://www.jiomart.com/c/groceries/fruits-vegetables/219'
                          '?prod_mart_groceries_products_popularity%5Bpage%5D=2')

    def enter_website(self, pincode):
        self.driver.get(self.entry_url)

        deliver_to_button = WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable((By.XPATH, "//button[contains(@class, 'jm-btn') and contains(@class, "
                                                  "'primary') and contains(@class, 'small')]"))
        )

        deliver_to_button.click()

        enter_pincode_button = WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable((By.ID, "btn_enter_pincode"))
        )

        enter_pincode_button.click()

        pincode_element = WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable((By.ID, "rel_pincode"))
        )

        pincode_element.send_keys(pincode)

        apply_button = WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable((By.ID, "btn_pincode_submit"))
        )
        apply_button.click()




