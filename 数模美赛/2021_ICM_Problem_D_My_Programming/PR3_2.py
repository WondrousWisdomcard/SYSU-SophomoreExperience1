import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

file1 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/full_music_data.csv"
df = pd.read_csv(file1)
df = df[['artists_id', 'popularity','year']]

# 建立歌手与流派对应的字典 d
file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_artists_and_genre.csv"
dff = pd.read_csv(file2)
dff = dff.set_index('artist_id')
d = dff.to_dict()
d = d['main_genre']

# 流派数据 g
file3 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_data.csv"
dfff = pd.read_csv(file3)
ge = list(dfff['main_genre'])

dfn = pd.DataFrame(data = None,index = list(range(1924,2021)),columns = None)   


for g in ge:
    l = []
    for y in range(1924,2021):
        df2 = df.loc[df['year'] == y]
        df2 = df2.reset_index(drop = True)
        c = 0
        for i in range(len(df2)):
            a = eval(df2.loc[i].artists_id) # 列表
            for j in range(len(a)):
                if d.get(a[j]):
                    if d[a[j]] == g:
                        c = c + df2.loc[i]['popularity']
        l.append(c)
    s = pd.Series(data = l, index = list(range(1924,2021)))
    dfn.insert(0,g,s)

dfnt = dfn

file6 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/year_genre_pop.csv"
dfn.to_csv(file6, index = True)

# 归一化
for i in range(1924,2021):
    if dfn.loc[i].sum() != 0:
        dfn.loc[i] = dfn.loc[i]/dfn.loc[i].sum()


file7 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/year_genre_pop_standard.csv"
dfn.to_csv(file7, index = True)

# 作图
ax = dfn.plot(colormap = 'jet')
plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)
plt.xticks(fontsize=6)
plt.show()



for g in ge:
    l = []
    for y in range(1924,2021):
        df2 = df.loc[df['year'] == y]
        df2 = df2.reset_index(drop = True)
        c = 0
        for i in range(len(df2)):
            a = eval(df2.loc[i].artists_id) # 列表
            for j in range(len(a)):
                if d.get(a[j]):
                    if d[a[j]] == g:
                        c = c + df2.loc[i]['popularity'] + 1
        l.append(c)
    s = pd.Series(data = l, index = list(range(1924,2021)))
    dfn.insert(0,g,s)


from scipy import interpolate

fig,ax = plt.subplots()

colors = ["#1f77b4","#ff7f0e","#2ca02c","#f61600","#7834a9",
"#17becf","#684427","#fa5deb","#eabeae","#aabecf","#682227","#225d22","#2dbfcf","#d41ecf"]
c = 0
for i in ge:
    x = list(range(1924,2021))
    y = list(dfn[i])
    x_smooth = np.linspace(min(x),max(x),5000) 
    y_smooth = interpolate.CubicSpline(x, y)
    ax.plot(x_smooth, y_smooth,label=i,color = colors[c])
    c = c + 1

plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)

plt.show()

l2 = ['Jazz','R&B;']
j = 0
for i in l2:
    plt.subplot(211+j).set_title(i)
    x = list(range(1924,2021))
    y = list(dfn[i])
    z1 = np.polyfit(x, y, 20) # 用9次多项式拟合
    p1 = np.poly1d(z1)
    yvals=p1(x) # 也可以使用yvals=np.polyval(z1,x)
    plot2=plt.plot(x, yvals, 'r',label=i,color = colors[c])
    j = j + 1

plt.show()


import matplotlib.pyplot as plt
import numpy as np

x = list(range(1924,2021))
y = list(dfn['Folk'])
z1 = np.polyfit(x, y, 12) # 用9次多项式拟合
p1 = np.poly1d(z1)

yvals=p1(x) # 也可以使用yvals=np.polyval(z1,x)

plot2=plt.plot(x, yvals, 'r',label='polyfit values')

plt.xlabel('x axis')
plt.ylabel('y axis')
plt.legend(loc=4) # 指定legend的位置,读者可以自己help它的用法
plt.title('polyfitting')
plt.show()



from scipy import interpolate

fig,ax = plt.subplots()

colors = ["#1f77b4","#ff7f0e","#2ca02c","#f61600","#7834a9",
"#17becf","#684427","#fa5deb","#eabeae","#aabecf","#682227","#225d22","#2dbfcf","#d41ecf"]
c = 0
for i in ge:
    x = list(range(1924,2021))
    y = list(dfn[i])
    z1 = np.polyfit(x, y, 20) # 用9次多项式拟合
    p1 = np.poly1d(z1)
    yvals=p1(x) # 也可以使用yvals=np.polyval(z1,x)
    plot2=plt.plot(x, yvals, 'r',label=i,color = colors[c])
    c = c + 1

plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)

plt.show()


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

# 流派数据 g
file3 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_data.csv"
dfff = pd.read_csv(file3)
ge = list(dfff['main_genre'])

file7 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/year_genre_pop_standard.csv"
dfn = pd.read_csv(file7)
dfn.set_index('Unnamed: 0')




fig,ax = plt.subplots()

colors = ["#1f77b4","#ff7f0e","#2ca02c","#f61600","#7834a9",
"#17becf","#684427","#fa5deb","#eabeae","#aabecf","#682227","#225d22","#2dbfcf","#d41ecf"]
c = 0
l2 = ['Jazz','R&B;']
j = 0
for i in l2:
    plt.subplot(211+j).set_title(i)
    x = list(range(1924,2021))
    y = list(dfn[i])
    z1 = np.polyfit(x, y, 20) # 用9次多项式拟合
    p1 = np.poly1d(z1)
    yvals=p1(x) # 也可以使用yvals=np.polyval(z1,x)
    plot2=plt.plot(x, yvals, 'r',label=i,color = colors[c])
    j = j + 1

plt.show()