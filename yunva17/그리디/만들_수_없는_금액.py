n = int(input())
coins = list(map(int, input().split()))

result = 1

coins.sort()

for coin in coins:
    if coin > result:
        break
    result += coin

print(result)
    
