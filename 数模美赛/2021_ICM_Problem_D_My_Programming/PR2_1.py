import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import networkx as nx

#生成歌手+流派数据表

file1 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/influence_data.csv"
df = pd.read_csv(file1)

df3 = df[['influencer_id', 'influencer_main_genre']]
df4 = df[['follower_id', 'follower_main_genre']]

df3 = df3.rename(columns={'influencer_id':'artist_id','influencer_main_genre':'main_genre'})
df4 = df4.rename(columns={'follower_id':'artist_id','follower_main_genre':'main_genre'})

df5 = pd.concat([df3, df4])
df5 = df5.drop_duplicates(subset=None, keep='first', inplace=False)
file2 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/store_artists_and_genre.csv"
#df5.to_csv(file2, index = False)

from scipy.spatial.distance import cdist
import numpy as numpy

file3 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/data_by_artist.csv"
df2 = pd.read_csv(file3)

def getMdis(genre): 
    df6 = df5.loc[df5['main_genre'] == genre]
    l = []
    for i in range(len(df6)):
        id = df6.iloc[i,0]
        ix = df2.loc[df2['artist_id'] == id]
        il = [ix['danceability'].values[0],ix['energy'].values[0],ix['valence'].values[0],ix['tempo'].values[0],ix['loudness'].values[0],ix['mode'].values[0],ix['key'].values[0],ix['acousticness'].values[0],ix['liveness'].values[0],ix['speechiness'].values[0]]
        l.append(il)
    x = np.array(l)
    xT = x.T
    D = np.cov(xT)
    invD = np.linalg.inv(D)
    tp = x[0] - x[1]
    res = np.sqrt(np.dot(np.dot(tp, invD), tp.T))
    return res


df7 = df5['main_genre'].drop_duplicates(keep='first', inplace=False)
df7 = df7.reset_index()
del df7['index']

df7 = df7.merge(df5.groupby(df5['main_genre']).count(), on='main_genre', how='left')
file4 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_data.csv"
#df7.to_csv(file4, index = False)

df6 = df5
c = 0
l = []
for i in range(len(df6)):
    id = df6.iloc[i,0]
    ix = df2.loc[df2['artist_id'] == id]
    if len(ix) == 1:
        c = c+1
        il = [ix['danceability'].values[0],ix['energy'].values[0],ix['valence'].values[0],ix['tempo'].values[0],ix['loudness'].values[0],ix['mode'].values[0],ix['key'].values[0],ix['acousticness'].values[0],ix['instrumentalness'].values[0],ix['liveness'].values[0],ix['speechiness'].values[0]]
        l.append(il)

x = np.array(l)
xT = x.T
D = np.cov(xT)
invD = np.linalg.inv(D)

tp = x[0] - x[1]
res = np.sqrt(np.dot(np.dot(tp, invD), tp.T))

# get average data

lc = list(df2.columns)
del lc[0]
del lc[0]
del lc[-1]
del lc[-1]
del lc[-1]
for i in range(len(lc)):
    df7[lc[i]] = None
df10 = df2.merge(df3) #流派和歌手信息
df10 = df10.drop_duplicates(keep='first', inplace=False)
df11 = df10.set_index('main_genre')

# get mahalanobis distance
def get2ans(genre_a,genre_b):   
    df12 = df11.loc[genre_a]
    if type(df12) == pd.Series:
        df12 = pd.DataFrame(df12)
        df12 = df12.T
    df13 = df12.mean()
    l1 = []
    for i in range(1,len(df13)-3):
        l1.append(df13[i])
    df14 = df11.loc[genre_b]
    if type(df14) == pd.Series:
        df14 = pd.DataFrame(df14)
        df14 = df14.T
    df15 = df14.mean()
    l2 = []
    for i in range(1,len(df15)-3):
        l2.append(df15[i])
    a_ = np.array(l1) # genre_a 
    b_ = np.array(l2) # genre_b
    #D[11*11]矩阵已经存好了
    a_res = 0
    b_res = 0
    c = 0
    for i in range(len(df6)):
        id = df6.iloc[i,0]
        if (df6.iloc[i,1] == genre_a):
            ix = df2.loc[df2['artist_id'] == id]
            if(len(ix) != 0):
                c = c + 1
                il = [ix['danceability'].values[0],ix['energy'].values[0],ix['valence'].values[0],ix['tempo'].values[0],ix['loudness'].values[0],ix['mode'].values[0],ix['key'].values[0],ix['acousticness'].values[0],ix['instrumentalness'].values[0],ix['liveness'].values[0],ix['speechiness'].values[0]]
                tp_a = il - a_
                a_res = a_res + (np.dot(np.dot(tp_a, invD), tp_a.T))
                tp_b = il - b_
                b_res = b_res + (np.dot(np.dot(tp_b, invD), tp_b.T))
    a_res = a_res / c
    b_res = b_res / c
    return b_res


#day3 thermodynamic diagram

lgen = list(df7['main_genre'])
df99 = pd.DataFrame(data = None,index = lgen,columns = lgen)   
for i in lgen:
    for j in lgen:
        df99[i][j] = get2ans(i,j)

file99 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/genre_similarity.csv"
#df99.to_csv(file99, index = True)

import numpy as np
import matplotlib
import matplotlib.pyplot as plt

vegetables  = lgen
farmers = lgen

harvest = df99.values
harvest = harvest / harvest.max(axis=0)
harvest = harvest * 100

fig, ax = plt.subplots()
im = ax.imshow(harvest.astype(float))

# We want to show all ticks...
ax.set_xticks(np.arange(len(farmers)))
ax.set_yticks(np.arange(len(vegetables)))
# ... and label them with the respective list entries
ax.set_xticklabels(farmers)
ax.set_yticklabels(vegetables)

# Rotate the tick labels and set their alignment.
plt.setp(ax.get_xticklabels(), rotation=45, ha="right",
         rotation_mode="anchor",size = 8)

# Loop over data dimensions and create text annotations.
for i in range(len(vegetables)):
    for j in range(len(farmers)):
        text = ax.text(j, i, int(harvest[i, j]),
                       ha="center", va="center", color="w", size = 4)

ax.set_title("要什么标题呢")
fig.tight_layout()
plt.show()

########################################3

#PR4

file88 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/influence_data.csv"
df88 = pd.read_csv(file88)
df88 = df88.set_index('follower_id')


#共有631组影响者与被影响者一一对应的
df66 = pd.DataFrame(data = None,index = None,columns = list(df88.columns))
  
for i in range(3670557):
    if(i in df88.index):
        t = df88.loc[i]
        if type(t) == pd.Series:
            t = pd.DataFrame(t)
            t = t.T
            df66 = pd.concat([df66, t])

df66 = df66.reset_index()
df66 = df66.rename(columns={'index':'follower_id'})


# compute 10*10 matrix D1
c = 0
l = []
for i in range(len(df6)):
    id = df6.iloc[i,0]
    ix = df2.loc[df2['artist_id'] == id]
    if len(ix) == 1:
        c = c+1
        il = [ix['danceability'].values[0],ix['energy'].values[0],ix['valence'].values[0],ix['tempo'].values[0],ix['mode'].values[0],ix['key'].values[0],ix['acousticness'].values[0],ix['instrumentalness'].values[0],ix['liveness'].values[0],ix['speechiness'].values[0]]
        l.append(il)

x = np.array(l)
xT = x.T
D1 = np.cov(xT)
invD1 = np.linalg.inv(D1)


###########################


cc = 0
df33 = pd.DataFrame(data = None,index = None,columns = ['follower','influencer','danceability','energy','valence','tempo','mode','key','acousticness','instrumentalness','liveness','speechiness','mdis'])
df88 = df88.reset_index()

for i in df66.index:
    l = [] # b set
    xgenre = df66['follower_main_genre'][i] #xi genre
    xyear = df66['follower_active_start'][i] #xi start year
    xid = df66['follower_id'][i]
    yid = df66['influencer_id'][i]
    ix = df2.loc[df2['artist_id'] == xid]
    ilx = []
    if len(ix) == 1:
        ilx = [ix['danceability'].values[0],ix['energy'].values[0],ix['valence'].values[0],ix['tempo'].values[0],ix['mode'].values[0],ix['key'].values[0],ix['acousticness'].values[0],ix['instrumentalness'].values[0],ix['liveness'].values[0],ix['speechiness'].values[0]]
    ix = df2.loc[df2['artist_id'] == yid]
    ily = []
    if len(ix) == 1:
        ily = [ix['danceability'].values[0],ix['energy'].values[0],ix['valence'].values[0],ix['tempo'].values[0],ix['mode'].values[0],ix['key'].values[0],ix['acousticness'].values[0],ix['instrumentalness'].values[0],ix['liveness'].values[0],ix['speechiness'].values[0]]
    if len(ilx) == 0 | len(ily) == 0:
        cc = cc+1
        continue
    tp = np.array(ilx) - np.array(ily)
    xymdis = np.dot(np.dot(tp, invD1), tp.T)
    df55 = df88.loc[(df88['influencer_id'] != xid) & (df88['influencer_id'] != yid) & (df88['influencer_active_start'] == xyear) & (df88['influencer_main_genre'] == xgenre)]
    if df55.empty == False:
        if type(df55) == pd.Series:
            c = df55['influencer_id']
            if c not in l:
                l.append(c)
        elif type(df55) == pd.DataFrame:
            df55 = df55.set_index('influencer_id')
            df55 = df55[~df55.index.duplicated(keep='first')]
            l2 = list(df55.index)
            for i in l2:
                if i not in l:
                    l.append(i) 
    df55 = df88.loc[(df88['follower_id'] != xid) & (df88['follower_id'] != yid) & (df88['follower_active_start'] == xyear) & (df88['follower_main_genre'] == xgenre)]
    if df55.empty == False:
        if type(df55) == pd.Series:
            c = df55['follower_id']
            if c not in l:
                l.append(c)
        elif type(df55) == pd.DataFrame:
            df55 = df55.set_index('follower_id')
            df55 = df55[~df55.index.duplicated(keep='first')]
            l2 = list(df55.index)
            for i in l2:
                if i not in l:
                    l.append(i)
    bsum = 0
    for e in l:
        dft = df2.loc[df2['artist_id'] == e]
        if dft.empty == True:
            continue
        ilb = [dft['danceability'].values[0],dft['energy'].values[0],dft['valence'].values[0],dft['tempo'].values[0],dft['mode'].values[0],dft['key'].values[0],dft['acousticness'].values[0],dft['instrumentalness'].values[0],dft['liveness'].values[0],dft['speechiness'].values[0]]
        tp = np.array(ilx) - np.array(ilb)
        bsum = bsum + np.dot(np.dot(tp, invD1), tp.T)
    if len(l) == 0:
        cc = cc+1
        continue
    bsum = bsum/len(l)
    if bsum > xymdis:
        df33 = df33.append([{
        'qty1':10.0,
        'follower':xid,
        'influencer':yid,
        'danceability':tp[0],
        'energy':tp[1],
        'valence':tp[2],
        'tempo':tp[3],
        'mode':tp[4],
        'key':tp[5],
        'acousticness':tp[6],
        'instrumentalness':tp[7],
        'liveness':tp[8],
        'speechiness':tp[9],
        'mdis':xymdis
        }])

df33 = df33.drop_duplicates(subset=None, keep='first', inplace=False)
file33 = "C:/Users/17727/Desktop/2021_ICM_Problem_D_Data/oto_mdis_4.csv"
df33.to_csv(file33,index = False)