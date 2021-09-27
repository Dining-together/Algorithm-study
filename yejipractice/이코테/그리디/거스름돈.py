import sys
input = sys.stdin.readline

coins = [500, 100, 50, 10]

N = int(input())

count = 0
for coin in coins:
    if N < 10:
        break
    count += N // coin
    N %= coin

print(count)
