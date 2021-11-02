# 백준 4796
import sys
input = sys.stdin.readline

i = 1
while 1:
    l, p, v = map(int, input().split())
    if l+p+v == 0:
        break
    answer = l*(v//p)+min(v % p, l)
    print("Case {}: {}".format(i, answer))
    i += 1
