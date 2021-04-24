#!/usr/bin/python3
"""
Python script to:
    * Visualise AVL insertion and searching
    * Open Browser and open AVLtree.html
    * Get AVL tree data
    * Insert data 
"""

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import pathlib, os, time, sys

def main():
    if len(sys.argv[1]) != 0:
        cap = int(sys.argv[1]) + 1
    else:
        cap = 31
    with open("data/experiment/insert/AVL_insert_n_500.txt", "r") as f:
        data = []
        for line in f:
            if len(data) == cap:
                break
            try:
                int(line)
                pass
            except:
                data.append(line)

    fields = openBrowser()
    insert(fields, data[1:])
    search(fields, data[1:])

def openBrowser():
    browser = webdriver.Firefox()
    browser.maximize_window()
    path = os.path.abspath(os.getcwd())
    url = pathlib.Path(path).as_uri()
    browser.get(f"{url}/visualiser/AVLtree.html")
    fields = browser.find_elements_by_xpath("//table[contains(@id, 'AlgorithmSpecificControls')]/td/input")
    return fields


def insert(fields, data):
    insert = fields[0]
    for num, entry in enumerate(data):
        insert.send_keys(entry)
        insert.send_keys(Keys.ENTER)
        time.sleep(1)


def search(fields, data):
    search = fields[4]
    for num, entry in enumerate(data):
        search.send_keys(entry)
        search.send_keys(Keys.ENTER)
        time.sleep(1)

if __name__ == "__main__":
    main()