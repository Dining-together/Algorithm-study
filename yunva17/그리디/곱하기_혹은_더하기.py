s = input()

result = int(s[0])

for i in range(len(s)-1):
    next = int(s[i+1])

    if((result+next)>(result*next)):
        result += next
    else:
        result *= next

print(result)