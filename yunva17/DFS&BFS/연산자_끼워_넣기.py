
n = int(input())
a = list(map(int, input().split()))

# 덧셈, 뺄셈, 곱셈, 나눗셈 순
symbols = list(map(int, input().split()))

min_value = 1e9
max_value = -1e9

def dfs(c, res, plus, minus, m, d):
    global min_value
    global max_value

    if c == n:
        max_value = max(max_value, res)
        min_value = max(min_value, res)

    if plus:
        dfs(c+1, res+a[c], plus-1, minus, m, d)
    if minus:
        dfs(c+1, res-a[c], plus, minus-1, m, d)
    if m:
        dfs(c+1, res*a[c], plus, minus, m-1, d)
    if d:
        dfs(c+1, res//a[c], plus, minus, m, d-1)    

dfs(1, a[0], symbols[0], symbols[1], symbols[2], symbols[3])

print(max_value)
print(min_value)

