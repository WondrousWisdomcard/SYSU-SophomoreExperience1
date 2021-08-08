import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

file1 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_average.csv"
df = pd.read_csv(file1)

df = df.set_index('aspect')
df = df.T

l = list(df.columns)

#归一化
for i in l:
    df[i] = df[i]/df[i].sum()

#生成所有genre的图
df4 = df3.head(100)
x = range(0,5000,500)
ax = df4.plot(colormap = 'jet')
plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)
plt.show()

##############

#给定一个genre，生成单一的图
genre = 'Folk'

x = range(0,14,1)
ax = df.loc[genre].plot(colormap = 'jet')
plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)
plt.xticks(x,list(df.columns),fontsize=4)
plt.show()