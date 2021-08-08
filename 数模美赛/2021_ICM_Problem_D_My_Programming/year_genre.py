import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

file7 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/data_by_year.csv"
dfn = pd.read_csv(file7)

# 作图
dfn = dfn.set_index('year')
l = ['danceability','energy','valence','tempo','loudness','key','acousticness','instrumentalness','liveness','speechiness','duration_ms','popularity']
for i in range(6):
    plt.subplot(321 + i)
    dfnn = dfn[l[i+6]] 
    ax = dfnn.plot(colormap = 'jet')
    plt.legend(loc='best',edgecolor='blue')
    plt.xticks(fontsize=6)
    

plt.show()

###############

colors = ["#1f77b4","#ff7f0e","#2ca02c","#f61600","#7834a9",
"#17becf","#684427","#fa5deb","#eabeae","#aabecf","#682227","#225d22","#2dbfcf","#d41ecf"]

# 拟合
l2 = ['Jazz','R&B;'] #
j = 0
for i in l2:
    plt.subplot(211+j).set_title(i)
    x = list(range(1924,2021))
    y = list(dfn[i])
    z1 = np.polyfit(x, y, 20) # 用20次多项式拟合
    p1 = np.poly1d(z1)
    yvals=p1(x) # 也可以使用yvals=np.polyval(z1,x)
    plot2=plt.plot(x, yvals, 'r',label=i,color = colors[j])
    j = j + 1

plt.show()
