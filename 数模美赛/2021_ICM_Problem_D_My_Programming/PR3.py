import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx


file1 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_average.csv"
df = pd.read_csv(file1)

df = df.set_index('aspect')
df = df.T

l = list(df.columns)

# standardize
for i in l:
    df[i] = df[i]/df[i].sum()


x = range(0,14,1)
ax = df.T.plot(colormap = 'jet')
plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)
plt.xticks(x,list(df.columns),fontsize=4)
plt.show()


file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/data_by_year.csv"
df2 = pd.read_csv(file2)

df2 = df2.set_index('year')

l = list(df2.columns)
# standardize
for i in l:
    df2[i] = df2[i]/df2[i].sum()

ax = df2.plot(colormap = 'jet')
plt.legend(bbox_to_anchor=(1.05, 0), loc=3, borderaxespad=0,fontsize=6)
plt.xticks(fontsize=6)
plt.show()

 
