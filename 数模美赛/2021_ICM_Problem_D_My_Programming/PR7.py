import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

file1 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/data_by_year.csv"
df = pd.read_csv(file1)
df = df.set_index('year')

l = list(df.columns)
y = list(df.index)
df2 = pd.DataFrame(None,index = list(range(1922,2020)),columns= l)

for i in l:
    for j in y:
        if j < 2020:
            df2.loc[j,i] = df[i][j+1] - df[i][j]

file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/sub_data_by_year.csv"
df2.to_csv(file2)

df3 = df2[df2.columns[:3]].copy()

for i in list(df3.columns):
    for j in list(df3.index):
            df3.loc[j,i] = abs(df3.loc[j,i])

df4 = df3.sort_values('danceability',ascending = False)
df5 = df3.sort_values('energy',ascending = False)
df6 = df3.sort_values('valence',ascending = False)

df3['total'] = (df3['danceability']+df3['energy']+df3['valence'])/3

bar_width = 0.3 #柱形图宽度
plt.figure() #实例化一个画布
plt.subplot(2,1,1) #在画布上实例化一个子图
plt.bar(x = list(df3.index),height = list(df3.total),width=bar_width,color='#FFB6C1') #实例化一个最简单的柱形图
plt.xlabel('year') #设置x轴名称

file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/sub_data_by_year.csv"
df3.to_csv(file2)

