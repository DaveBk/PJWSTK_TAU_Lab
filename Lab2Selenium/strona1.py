from selenium import webdriver
import time

driver = webdriver.Chrome(executable_path='C:\chromedriver.exe')

driver.get('https://www.denley.pl/')
time.sleep(1)
driver.switch_to.__class__('popupContainer')
temp = driver.find_element_by_id('akceptuj')
temp.click()

time.sleep(3)

driver.switch_to.__class__('sm-webpush animated slideInDown')
temp = driver.find_element_by_id('smwpRejectionButton')
temp.click()

temp = driver.find_element_by_id('catcomplete ui-autocomplete-input')
temp.click()
time.sleep(1)
temp = driver.find_element_by_id('menu_search_text')
temp.send_keys("yoga")
temp = driver.find_element_by_class_name('icon-search')
temp.click()
