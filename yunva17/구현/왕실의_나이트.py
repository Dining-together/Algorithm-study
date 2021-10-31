now = input()

column = int(ord(now[0])-96)
row = int(now[1])


types = [(-2,-1),(-2,1),(2,1),(2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]

result = 0
for type in types:
    c = column + type[0]
    r = row + type[1]

    if(c>=1 and c<=8 and r>=1 and r<=8):
        result +=1

print(result)


