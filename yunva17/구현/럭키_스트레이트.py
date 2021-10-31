n = input()

left = n[:len(n)//2]
right = n[len(n)//2:]

def sum(s):
    r = 0
    for i in s:
        r += int(i)
    return r

if(sum(left) == sum(right)):
    print("LUCKY")
else:
    print("READY")



