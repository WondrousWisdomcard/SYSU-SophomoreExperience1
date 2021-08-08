import numpy as np

#1.1 矩阵乘法-列表推导式
M1 = np.random.rand(2,3)
M2 = np.random.rand(3,4)
R = np.array([[sum([M1[i][k] * M2[k][j] for k in range(M1.shape[1])]) for j in range(M2.shape[1])] for i in range(M1.shape[0])])
((M1@M2 - R) < 1e-15).all()

#1.2 矩阵更新
A = np.arange(1,10).reshape(3,-1)
B = A * (1/A).sum(1).reshape(-1,1) #sum(1):行相加
B

#1.3 卡方统计量
np.random.seed(0)
A = np.random.randint(10, 20, (8, 5))
B = A.sum(0)*A.sum(1).reshape(-1,1)/A.sum()
R = ((A-B)**2/B).sum()

#1.5 找最大递增数
F = lambda x : np.diff(np.nonzero(np.r_[1,np.diff(x)!=1,1])).max()

import numpy as np
import pandas as pd

#文件读写
pd.read_table('data/my_table.txt', usecols=['col1', 'col2']) #只选中某些列

df_csv = pd.read_csv('data/my_csv.csv', parse_dates=['col5']) #转换日期

pd.read_table('data/my_table_special_sep.txt',sep=' \|\|\|\| ', engine='python') #指定分隔符，seq为正则参数

df_csv.to_csv('data/my_csv_saved.csv', index=False) #数据写入，不保留索引

#DataFrame
s = pd.Series(data = [100, 'a', {'dic1':5}],index = pd.Index(['id1', 20, 'third'], name='my_idx'),dtype = 'object',name = 'my_name')

data = [[1, 'a', 1.2], [2, 'b', 2.2], [3, 'c', 3.2]]
df = pd.DataFrame(data = data,index = ['row_%d'%i for i in range(3)],columns=['col_0', 'col_1', 'col_2'])

df = pd.DataFrame(data = {'col_0': [1,2,3], 'col_1':list('abc'),'col_2': [1.2, 2.2, 3.2]},index = ['row_%d'%i for i in range(3)])
df['col_0']
df[['col_0', 'col_1']]
df.T

#超实用函数
df = pd.read_csv('data/learn_pandas.csv')
df.columns

df.head(2)
df.tail(2)

#info, describe分别返回表的信息概况和表中数值列对应的主要统计量：
df.info()
df.describe()

df_demo = df[['Height', 'Weight']]
df_demo.mean()
df_demo.max()
df_demo.quantile(0.75) #分位数
df_demo.count() #非缺失值个数
df_demo.idxmax() #最大值对应的索引
df['School'].unique() #得到唯一值列表
df['School'].nunique() #得到唯一值个数
df['School'].value_counts() #得到唯一值和其对应出现的频数：
df.drop_duplicates(['Gender', 'Transfer'])#要观察多个列组合的唯一值

df['Gender'].replace({'Female':0, 'Male':1}).head()

df_demo = df[['Grade', 'Name', 'Height','Weight']].set_index(['Grade','Name'])
df_demo.sort_values('Height',ascending=True)#升序

df[['HP','IP']].sum(1) == df['Total']

df['Type'].apply(lambda x: str.upper(x)).head()

#loc索引器
df.loc['Qiang Sun'] #直接取出相应的行或列，如果该元素在索引中重复则结果为 DataFrame，否则为 Series
df_demo.loc['Qiang Sun', 'School'] 
df_demo.loc['Gaojuan You':'Gaoqiang Qian', 'School':'Gender'] #切片
df_demo.loc[df_demo.Weight>70].head()
df_demo.loc[df_demo.Grade.isin(['Freshman', 'Senior'])].head()

def condition(x):
    condition_1_1 = x.School == 'Fudan University'
    condition_1_2 = x.Grade == 'Senior'
    condition_1_3 = x.Weight > 70
    condition_1 = condition_1_1 & condition_1_2 & condition_1_3
    condition_2_1 = x.School == 'Peking University'
    condition_2_2 = x.Grade == 'Senior'
    condition_2_3 = x.Weight > 80
    condition_2 = condition_2_1 & (~condition_2_2) & condition_2_3
    result = condition_1 | condition_2
    return result

df_demo.loc[condition]

df_demo.loc[lambda x:'Quan Zhao', lambda x:'Gender']

df_demo.iloc[1, 1] #取第二行第二列
df_demo.iloc[[0, 1], [0, 1]] # 前两行前两列
df_demo.iloc[1: 4, 2:4] # 切片不包含结束端点
df_demo.iloc[lambda x: slice(1, 4)] # 传入切片为返回值的函数

df.query('Weight > Weight.mean()').head()
low, high =70, 80
df.query('Weight.between(@low, @high)').head()

df_sample = pd.DataFrame({'id': list('abcde'),'value': [1, 2, 3, 4, 90]})
df_sample.sample(3, replace = True, weights = df_sample.value)

dpt = ['Dairy', 'Bakery']
df.loc[(df.age<=40)&df.department.isin(dpt)&(df.gender=='M')].head(3)

df.iloc[(df.EmployeeID%2==1).values,[0,2,-2]].head()

df.columns = [' '.join(i.split('\n')) for i in df.columns] #把列索引名中的 \n 替换为空格

#将 Review Date 和 Company Location 设为索引后，选出 Review Date 在 2012 年之后且 Company Location 不属于 France, Canada, Amsterdam, Belgium 的样本。
idx = pd.IndexSlice
exclude = ['France', 'Canada', 'Amsterdam', 'Belgium']
res = df.set_index(['Review Date', 'Company Location']).sort_index(level=0)
res.loc[idx[2012:,~res.index.get_level_values(1).isin(exclude)],:].head(3)

#df.groupby(分组依据)[数据来源].使用操作
df.groupby('Gender')['Longevity'].mean() #依据性别分组，统计全国人口寿命的平均值
df.groupby(['School', 'Gender'])['Height'].mean() #多个维度分组

condition = df.Weight > df.Weight.mean()
df.groupby(condition)['Height'].mean()

df[['School', 'Gender']].drop_duplicates()#通过 drop_duplicates 就能知道具体的组类别

gb = df.groupby(['School', 'Grade'])
gb.ngroups #分了多少组

#定 义 在 groupby 对 象 的 聚 合 函 数
#max/min/mean/median/count/all/any/idxmax/idxmin/mad/nunique/skew/quantile/sum/std/var/sem/size/prod
gb = df.groupby('Gender')[['Height', 'Weight']]
gb.max()

gb.agg(['sum', 'idxmax', 'skew'])# 同时使用多个函数
gb.agg({'Height':['mean','max'], 'Weight':'count'})
gb.agg(lambda x: x.mean()-x.min())
gb.agg([('range', lambda x: x.max()-x.min()), ('my_sum', 'sum')])
#如果想要对结果进行重命名，只需要将上述函数的位置改写成元组，元组的第一个元素为新的名字，第二个位置为原来的函数，包括聚合字符串和自定义函数，

# 跨列分组

def BMI(x):
    Height = x['Height']/100
    Weight = x['Weight']
    BMI_value = Weight/Height**2
    return BMI_value.mean()

gb.apply(BMI)

df1 = pd.DataFrame({'Name':['San Zhang','Si Li'],
    'Age':[20,30]})
df2 = pd.DataFrame({'Name':['Si Li','Wu Wang'],
    'Gender':['F','M']})
df1.merge(df2, on='Name', how='left')

df1 = pd.DataFrame({'Name':['San Zhang'],'Grade':[70]})
df2 = pd.DataFrame({'Name':['San Zhang'],'Grade':[80]})
df1.merge(df2, on='Name', how='left', suffixes=['_Chinese','_Math'])

date = pd.date_range('20200412', '20201116').to_series() 
date = date.dt.month.astype('string').str.zfill(2) +'-'+ date.dt.day.astype('string').str.zfill(2) +'-'+ '2020'
date = date.tolist()

L = []
for d in date:
    df = pd.read_csv('data/us_report/' + d + '.csv', index_col='Province_State')
    data = df.loc['New York', ['Confirmed','Deaths',
    'Recovered','Active']]
    L.append(data.to_frame().T)

res = pd.concat(L)
res.index = date

df = pd.read_csv('data/learn_pandas.csv',usecols = ['Grade', 'Name', 'Gender', 'Height','Weight', 'Transfer'])
df.isna().head()
df.isna().sum()/df.shape[0] # 查看缺失的比例
df[df.Height.isna()].head()

sub_set = df[['Height', 'Weight', 'Transfer']]
df[sub_set.isna().all(1)] # 全部缺失
#102 Junior Chengli Zhao Male NaN NaN NaN
df[sub_set.isna().any(1)].head() # 至少有一个缺失
df[sub_set.notna().all(1)].head() # 没有缺失

res = df.dropna(how = 'any', subset = ['Height', 'Weight']) # 删除身高体重至少有一个缺失的行
res = df.dropna(1, thresh=df.shape[0]-15) # 删除超过 15 个缺失值的列

df.year = pd.to_numeric(df.year.str[:-2]).astype('Int64')