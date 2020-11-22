import unittest
import time

from selenium.webdriver.common.by import By

from Morele.Test1 import driver, logger


class CheckProductTest(unittest.TestCase):

    def test_checkCart(self):
        logger.info('Sprawdzam czy w koszyku jest produkt')
        time.sleep(2)
        nazwaProduktu = driver.find_element(By.XPATH, '//*[@id="basket-main"]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]').text
        print(nazwaProduktu)
        assert nazwaProduktu == 'Obudowa SilentiumPC Signum SG7V TG (SPC249)'

        logger.info('Usuwam z koszyka produkt')
        driver.find_element(By.CLASS_NAME, 'item-remove').click()
        time.sleep(3)

        logger.info('Przechodze na strone glowna')
        przejdzDoGlownej = driver.find_element(By.LINK_TEXT, 'stronę główną').click()
        time.sleep(3)
        self.assertTrue(True)


if __name__ == "__main__":
    unittest.main()
