# Author: Jian Chun Hin, Ben , 20207461
#This python program need to download a new module, which is wikipedia-api
# Download Method:
#1.open cmd
#write: pip3 install wikipedia-api


#Program setting
import wikipediaapi
stoplist = [] 
Readtime = 0 #閲讀次數

# Read a stoplist
# what is stoplist?
# Ans: it is a list for program to remove some English words in a sentence, which benefits the program to create a question automatically.
with open("stoplist.txt","r",encoding="utf-8") as Readstoplist:
    while(True):
        stoplist.append(Readstoplist.readline())
        if((stoplist[Readtime] == None)or(len(stoplist[Readtime]))==0):
            break
        Readtime +=1

Rearch = "Kate_Sheppard"#預設Kate_Sheppard 為目標

with open("Rearchfile.txt","r") as rr:
    Rearch = rr.readline()

#Wiki setting
wiki_wiki = wikipediaapi.Wikipedia("WikiSearcher (1704935142jian@gmail.com)",'en',extract_format = wikipediaapi.ExtractFormat.WIKI)
#start

Rearch = Rearch.split(" ")
Rearch = "_".join(Rearch)

print(Rearch)
if(Rearch =="Kate_Sheppard"):
    print("true")
else:
    print("false")

p_wiki = wiki_wiki.page(Rearch)
if (p_wiki.exists()):
    dStr = p_wiki.text
else:
    dStr = "False"
    print("It is false")
    with open("QuestionFile.txt",'w+',encoding="utf-8") as error:
        error.write(dStr)
        quit()


#Cleaning 以下所有内容為 問題庫生成算法 

dStr = dStr.split(". ")#dStr 為原文，在經過處理後，已經以"."切割成一句句的句子  DataType:從String 變成 list
Contain = [] #容器 用來臨時裝詞語
Original = [] #容器 裝原本的句子
IsUseless = False  #判斷詞語是否有關
Usefull = []#待選字  有意義的字  放在這裏
QuestionDict = dict() #python Data structure: dict 用於裝載Question  以下為結構
# 已經放棄該結構{Qnumber:"Isuseless,Original[Qnumber],Question[Qnumber],Answer[Qnumber],Usefull,Useless"}
#新結構為 “Original[Qnumber]+"\n"+'A' 'B' 'C' ”
num = 0#Question number

for i in range(len(dStr)):
    Original.append(dStr[i] +".")
    IsUseless = False
    Usefull =[]
    Useless = []
    #開始清洗
    #dStr中的句子,split(" ")
    #將以上詞語放入Contain
    Contain = dStr[i].split(" ")
    for n in Contain:
        #打開Contain
        #打開stoplist
        for m in stoplist:
            #核對是否為IsUseless 字
            if (n == m):
                # 如果contain 中的words 是無關字
                IsUseless = True
        if(IsUseless):#如果是無關字
            pass
        else:#words 有用
            Usefull.append(n)
    print(len(Usefull))
    if(len(Usefull) != 0):#代表該句子有用
        #創建dict 中的key and value
        #key is num
        num = num + 1
        words = ";"
        #編寫Dict
        QuestionDict[num] = str(Original[i]) + words.join(Usefull)

    
#將QuestionDict 變成json結構

with open("QuestionFile.txt",'w+',encoding="utf-8") as Qwrite:
    for m in range(1,len(QuestionDict)):
        Qwrite.write(QuestionDict[m]+"#")


#原文裝在Data.txt
with open("Data.txt","w+",encoding="utf-8") as download:
    #將data寫入Data.text
    for i in Original:
        download.write(i + "\n")
    
