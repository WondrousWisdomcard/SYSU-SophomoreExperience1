import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

#read data
file = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/influence_data.csv"
df = pd.read_csv(file)

#generate digraph
G = nx.DiGraph()

for i in range(len(df)):
    G.add_edge(df.loc[i].follower_id,df.loc[i].influencer_id) #加边

m = nx.degree(G)
n = nx.clustering(G)

#store in csv.file
df1 = pd.DataFrame(dict(m),index = [0])
df1 = df1.T
df1 = df1.rename(columns = {0:'in_degree'})
alpha = 0.6
df1['influence0.6'] = alpha * df1['in_degree'] / df1['in_degree'].mean() + (1 - alpha) * df1['clustering'] / df1['clustering'].mean()
df1 = df1.sort_values('influence0.6',ascending = False)








df2 = pd.DataFrame(dict(n),index = [0])
df2 = df2.T
df2 = df2.rename(columns = {0:'clustering'})
df1 = df1.join(df2, how='left')

# sensitivity analysis
alpha = 0.5
df1['influence0.5'] = alpha * df1['in_degree'] / df1['in_degree'].mean() + (1 - alpha) * df1['clustering'] / df1['clustering'].mean()
alpha = 0.55
df1['influence0.55'] = alpha * df1['in_degree'] / df1['in_degree'].mean() + (1 - alpha) * df1['clustering'] / df1['clustering'].mean()
alpha = 0.6
df1['influence0.6'] = alpha * df1['in_degree'] / df1['in_degree'].mean() + (1 - alpha) * df1['clustering'] / df1['clustering'].mean()
alpha = 0.65
df1['influence0.65'] = alpha * df1['in_degree'] / df1['in_degree'].mean() + (1 - alpha) * df1['clustering'] / df1['clustering'].mean()
alpha = 0.7
df1['influence0.67'] = alpha * df1['in_degree'] / df1['in_degree'].mean() + (1 - alpha) * df1['clustering'] / df1['clustering'].mean()

# sort and store result
df1 = df1.sort_values('influence0.6',ascending = False)
file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_data3.csv"
df1.to_csv(file2, index = True)
df1 = df1.reset_index()





file5 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/data_by_artist.csv"
df5 = pd.read_csv(file5)
file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_artists_and_genre.csv"
df2 = pd.read_csv(file2)

df2 = df2.set_index('artist_id')
df5 = df5.set_index('artist_id')

df1 = pd.concat([df1, df2], axis=1, join='inner')
df1 = pd.concat([df1, df5], axis=1, join='inner')

l = ['danceability','energy','valence','tempo','mode','key','acousticness','instrumentalness','liveness','speechiness']

file9 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/artist_genre_influence.csv"
df.to_csv(file9)

####

for i in df1.index:
    df1.loc[i]['artist_name'] = df5.loc[i]['artist_name']

df5 = df5['artist_name'] # df5 id name
df1 # id influence

name = []
in_degree = []
rank = []
influence = []
df3 = df.set_index('influencer_id')
for i in range(10):
    t = df3.loc[df1['index'][i]]
    t = t.reset_index()
    name.append(t['influencer_name'][0])
    in_degree.append(df1['in_degree'][i])
    rank.append(df1['clustering'][i])
    influence.append(df1['influence'][i])

file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_data3.csv"
#df1.to_csv(file2, index = True)

x = np.array(name)
y = np.array(influence)
plt.bar(x, y, label = 'influence')
plt.title('Top Ten Musicans')
plt.xlabel('Musicans')
plt.ylabel('Music Influence')
plt.tick_params(labelsize=5)
plt.show()



file4 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_data.csv"
df7 = pd.read_csv(file4)

file5 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_artists_and_genre.csv"
df5 = pd.read_csv(file5)
df5.set_index('artist_id')

lgen = list(df7['main_genre'])
colors = ["#1f77b4","#ff7f0e","#2ca02c","#f61600","#7834a9",
"#17becf","#684427","#fa5deb","#eabeae","#aabecf",
"#682227","#225d22","#2dbfcf","#d41ecf",'#F0E68C',
'#CD853F',"#711ecf","#aa4427","#15dedb","#abe1ae",]

# read_data
file4 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_artists_and_genre.csv"
df4 = pd.read_csv(file4)
df4 = df4.set_index('artist_id')

#matplotlib
G = nx.DiGraph()
genre = 'Latin'
color_map = []
ex = []

for i in range(len(df)):
    f = df.loc[i].follower_id
    j = df.loc[i].influencer_id
    if((f in df5.index) & (j in df5.index)) == False:
        continue
    if((df4.loc[f]['main_genre'] == genre)): # & (df4.loc[j]['main_genre'] == genre)
        if f not in ex:
            m = lgen.index(df5.loc[f]['main_genre'])
            color_map.append(colors[m])
            ex.append(f)
        if j not in ex:
            m2 = lgen.index(df5.loc[j]['main_genre'])
            color_map.append(colors[m2])
            ex.append(j)
        G.add_edge(j,f) #加边

nodel = list(G.nodes())
node_size = [G.degree(i)**0.2*20 for i in nodel]
options = {
    'node_size': node_size,
    'edge_size': 1,
    'edge_color' : '#F5F5F5',
    'arrowsize': 1,
    'alpha' : 0.5
}

pos = nx.layout.spring_layout(G)
nx.draw(G, pos = pos,node_color = color_map,**options)
plt.show()
