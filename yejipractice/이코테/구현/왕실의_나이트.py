inputs = input()
c = ord(inputs[0]) - ord('a') + 1
r = int(inputs[1])

cases = [[2, -1], [2, 1], [-2, 1], [-2, -1],
         [1, 2], [-1, 2], [1, -2], [-1, -2]]

count = 0
for case in cases:
    dc = c + case[0]
    dr = r + case[1]
    if dc > 0 and dr > 0 and dc <= 8 and dr <= 8:
        count += 1

print(count)
