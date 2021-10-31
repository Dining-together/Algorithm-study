
coins = [500, 100, 50, 10]

change = int(input())

count = 0

for coin in coins:
    count += change // coin
    change %= coin

print(count)
