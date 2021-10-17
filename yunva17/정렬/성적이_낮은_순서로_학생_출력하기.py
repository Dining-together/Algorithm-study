n = int(input())
array=[]

for i in range(n):
    student = input().split()
    array.append((student[0], int(student[1])))

array.sort(key=lambda student:student[1])

for i in array:
    print(i[0], end=' ')