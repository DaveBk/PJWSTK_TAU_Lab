import time
from selenium.webdriver.support import expected_conditions as EC

from selenium import webdriver
import logging

from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

logger.info('Przechodzę na stronę Morele')
driver.get('https://www.morele.net/')
element = WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.CLASS_NAME, "user-is-logged-out ")))
logger.info('Wyszukuje obudowe')
temp = driver.find_element(By.NAME, 'search')
temp.click()
temp.send_keys("obudowa")
temp.send_keys(Keys.ENTER)

logger.info('Dodaje obudowe SilentiumPC Signum SG7V Evo do koszyka')
element = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.CLASS_NAME, "cat-product-content")))

product = driver.find_element_by_xpath("//div[a/@data-product-id='5941492']")
product.click()
element = WebDriverWait(driver, 10).until(
    EC.visibility_of_element_located((By.CLASS_NAME, "md-box in")))
temp = driver.find_element(By.CLASS_NAME, 'btn btn-red js_no-warrant-btn_desktop')
temp.click()
#driver.close()