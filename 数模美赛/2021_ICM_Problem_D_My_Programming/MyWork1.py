import pandas as pd
import numpy as np
import matplotlib
import matplotlib.pyplot as plt
import numpy as np

infile = "C:/Users/17727/Desktop/t1.csv"
outfile = "C:/Users/17727/Desktop/t3.csv"

inframe = pd.read_csv(infile)
outframe = pd.read_csv(outfile)

outframe["state"] = inframe["state"]
outframe["total_beds_7_day_avg"] = inframe["total_beds_7_day_avg"]
outframe["all_adult_hospital_beds_7_day_avg"] = inframe["all_adult_hospital_beds_7_day_avg"]

inframe["total_beds_7_day_avg"] = inframe["total_beds_7_day_avg"].apply(lambda x : 0 if x < 0 else x)
inframe["all_adult_hospital_beds_7_day_avg"] = inframe["all_adult_hospital_beds_7_day_avg"].apply(lambda x : 0 if x < 0 else x)

sum1 = inframe.groupby(["state"])["total_beds_7_day_avg"].sum() 
# 根据state分组对total_beds_7_day_avg计算求和
max1 = inframe.groupby(["state"])["total_beds_7_day_avg"].max() 
# 根据state分组对total_beds_7_day_avg计算求和
sum2 = inframe.groupby(["state"])["all_adult_hospital_beds_7_day_avg"].sum() 
# 根据state分组对total_beds_7_day_avg计算求和
max2 = inframe.groupby(["state"])["all_adult_hospital_beds_7_day_avg"].max() 
# 根据state分组对total_beds_7_day_avg计算求和

sum1list = []
sum2list = []
max1list = []
max2list = []
size = 0




for i in sum1:
    sum1list.append(i)
    size = size + 1

for i in sum2:
    sum2list.append(i)

for i in max1:
    max1list.append(i)
    
for i in max2:
    max2list.append(i)

# Data for plotting
labels = np.arange(0, size, 1)
s1 = sum1list[:]
s2 = sum2list[:]
m1 = max1list[:]
m2 = max2list[:]

x = np.arange(len(labels))  # the label locations
width = 0.35  # the width of the bars

fig, ax = plt.subplots()
rects1 = ax.bar(x - width/2, s1, width, label='sum1')
rects2 = ax.bar(x + width/2, s2, width, label='sum2')

# Add some text for labels, title and custom x-axis tick labels, etc.
ax.set_ylabel('Num')
ax.set_title('Data of each state')
ax.set_xticks(x)
ax.set_xticklabels(labels)
ax.legend()

fig.tight_layout()

plt.show()


inframe["state"].describe()
inframe2 = inframe[inframe["state"] == "LA"]
inframe2.reset_index(drop=True, inplace=True)

