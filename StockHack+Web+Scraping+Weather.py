
# coding: utf-8

# In[11]:

#This web scraping program extracts weather information as strings(only work with weather.com)
from bs4 import BeautifulSoup
import requests
import ast  # abstract syntax tree to parse dictionary text

url = 'https://weather.com/weather/today/l/USCA0638:1:US'
soup = BeautifulSoup(requests.get(url).text, 'html.parser')

scripts = soup.find_all('script')
infos = []


#help(scripts)

for s in scripts:
    if 'var adaptorParams' in s.text:          # find the script of interest
        #d = s
        d = s.text.split(' = ')[1].strip(';')  # get the product information
        # parse information as dictionary text
        #s.getitem(Tag, "temperature")
        tempIndex = d.find("temperature")
        tempMaxIndex = d.find("temperatureMaxSince7am")
        
        
        #print d[tempIndex - 1: tempIndex + 18]
        #print d[tempMaxIndex - 1: tempMaxIndex + 28 ]
        print d[tempIndex - 1: tempIndex + 130]
        
        t = int(d[tempIndex + 13: tempIndex + 15])
        print t
        










