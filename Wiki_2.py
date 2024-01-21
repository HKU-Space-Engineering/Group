# Author: Jian Chun Hin, Ben , 20207461
#This python program need to download a new module, which is wikipedia-api
# Download Method:
#1.open cmd
#write: pip3 install wikipedia-api

import wikipediaapi

Rearch = "Kate_Sheppard"#預設Kate_Sheppard 為目標

with open("Rearchfile.txt","r") as rr:
    Rearch = rr.readline()

#setting
wiki_wiki = wikipediaapi.Wikipedia("WikiSearcher (1704935142jian@gmail.com)",'en',extract_format = wikipediaapi.ExtractFormat.WIKI)
#start
p_wiki = wiki_wiki.page(Rearch)
if (p_wiki.exists()):
    dStr = p_wiki.text
else:
    dStr = "False"


with open("Data.txt","w+",encoding="utf-8") as download:
    #將data寫入Data.text
    download.write(dStr)
    
