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
        self.entry_url = 'https://blinkit.com/'

    def enter_website(self, pincode):
        self.driver.get(self.entry_url)

        pincode_element = self.driver.find_element(By.NAME, "select-locality")

        pincode_element.send_keys(pincode)

        WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable((By.NAME, "select-locality"))
        )
        pincode_element.send_keys(Keys.ENTER)
        time.sleep(5)
        self.driver.quit()


if __name__ == "__main__":
    auth_obj = Auth()
    auth_obj.enter_website(560064)
