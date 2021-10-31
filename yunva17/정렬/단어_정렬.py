# 1181

n = int(input())
array = []

for _ in range(n):
    array.append(input())

array = list(set(array))
array.sort(key = lambda x: (len(x), x))

for i in array:
    print(i)