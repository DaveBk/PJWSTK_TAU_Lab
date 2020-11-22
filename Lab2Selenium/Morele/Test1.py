import unittest
import time
import logging

from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait

driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)


class AddProductTest(unittest.TestCase):

    def test_searchByName(self):
        driver.get('https://www.morele.net/')
        logger.info('Przechodzę na stronę Morele')
        time.sleep(2)
        element = WebDriverWait(driver, 20).until(
            EC.presence_of_element_located((By.CLASS_NAME, "user-is-logged-out ")))
        logger.info('Wyszukuje obudowe')
        temp = driver.find_element(By.NAME, 'search')
        temp.click()
        temp.send_keys("obudowa")
        temp.send_keys(Keys.ENTER)
        time.sleep(1)

        logger.info('Dodaje obudowe SilentiumPC Signum SG7V Evo do koszyka')
        element = WebDriverWait(driver, 20).until(
            EC.presence_of_element_located(
                (By.XPATH, "//div[@data-product-name='Obudowa SilentiumPC Signum SG7V TG (SPC249)']")))
        product = driver.find_element_by_xpath(
            "//div[@data-product-name='Obudowa SilentiumPC Signum SG7V TG (SPC249)']")
        product = product.find_element(By.CLASS_NAME, 'cat-product-buttons')
        product.click()
        time.sleep(2)

        element = WebDriverWait(driver, 20).until(
            EC.presence_of_element_located((By.XPATH, '//button[text()="Przejdź do koszyka"]')))

        logger.info('Pomijam gwarancje i przechodze do koszyka')

        przejdzDokoszyka = driver.find_element(By.XPATH, '//button[text()="Przejdź do koszyka"]')
        przejdzDokoszyka.click()
        time.sleep(2)
        przejdzDokoszyka = driver.find_element(By.LINK_TEXT, 'Zobacz koszyk').click()
        self.assertTrue(True)


if __name__ == "__main__":
    unittest.main()
