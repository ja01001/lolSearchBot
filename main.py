#-*- coding:utf-8 -*-
import os, json, re
import discord, asyncio
import requests

from bs4 import BeautifulSoup
from urllib.request import Request, urlopen
from collections import OrderedDict
from urllib import parse



app = discord.Client()

json_data = open(os.getcwd()+"/data.json",encoding='utf-8').read()
jsons = json.loads(json_data)

TOKEN  = jsons["DISCORD_API_TOKEN"]
RIOT_API_TOKEN = jsons["RIOT_API_TOKEN"]
SEARCH_URL = jsons["SEARCH_URL"]

mstatus = 0
botid = ""
@app.event
async def on_ready():
    global botid
    print('Logged in as')
    print(app.user.name)
    print(app.user.id)
    game = discord.Game("Bot running... | $help")
    botid = await app.application_info()
    await app.change_presence(status=discord.Status.online, activity=game)

@app.event
async def on_message(message):

    global mstatus, botid
    if message.author.bot and message.author.id == botid.id:
        if mstatus == 1:
            await message.add_reaction("\u2b55") # O
            await message.add_reaction("\u274c") # X
            mstatus = mstatus - 1
        else:
            return None

    if message.content == "$help":
        desc_text = "$help - 봇 도움말 불러오기 \n\
                    $contribute - 넣고 싶은 내용 있으면 연락주세요 \n\
                    $game - 현재 게임 정보를 알려 드립니다. \n\
                    *다른기능은 추후 추가예정.*"
        await message.channel.send(embed=embed)
    
    if message.content == "$setting":
        tokenJson = OrderedDict()
        tokenJson["token"] = RIOT_API_TOKEN
        req = requests.post(SEARCH_URL+"/setting", data=json.dumps(tokenJson, ensure_ascii=False))
        print(req.text)
        
        # print ("전송")
    

    if message.content == "$contribute":
        embed2 = discord.Embed(title="To contribute", description="기능 추가는 언제든지 환영입니다~ 제번호는 선후배에게 물어보세요~" , color=0x6FA8DC)

        await message.channel.send(embed=embed2)

    if message.content == "$game":
        embed6 = discord.Embed(title="lol 상대 티어 정보 ", description="'아이디를 입력해주세요'", color=0x82CC62)

        await message.channel.send(embed=embed6)
        
        def check(m):
            return m.author == message.author and m.channel == message.channel

        try:    
            m = await app.wait_for('message',timeout=25.0, check=check)
        except asyncio.TimeoutError:
            await message.channel.send("시간초과!")
        else:
            async with message.channel.typing():
                req = requests.get(SEARCH_URL"/game/"+m.content)
                tt = req.text
                
                tmp = eval(tt)
                
                # 없는 아이디 생각 - TODO 
                msg = ""
                if(not bool(tmp)):
                    msg = discord.Embed(title=m.content+"의 게임 정보", description="해당 아이디는 게임중이 아닙니다.", color=0x82CC62)
                    
                else : 
                    tmp_msg =""
                    
                    for i in range(10): 
                        user = tmp[str(i)]
                        userRank = user["Rank"]
                        tmp_msg += user["name"]
                        
                        if(userRank["type"] == "RANKED_SOLO_5x5") :
                            tmp_msg += "  \t  | SOLO : "
                        else :
                            tmp_msg += "    | TEAM_RANK : "
                        tmp_msg += userRank["tier"] + " "
                        tmp_msg +=userRank["rank"] 
                        tmp_msg +=" " + str(userRank["score"])
                        tmp_msg += " 승 : " + str(userRank["win"])
                        tmp_msg += " 승률 : " + str(round(userRank["rate"],1))+ "%\n"
                        if(i == 4):
                            tmp_msg += "\n"
                       
                    msg = discord.Embed(title=m.content+"의 게임 정보", description=tmp_msg+"\n", color=0x82CC62)
                await message.channel.send(embed=msg)

app.run(TOKEN)