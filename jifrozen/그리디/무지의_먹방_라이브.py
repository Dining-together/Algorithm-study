from operator import itemgetter


def solution(food_times, k):
    foods = []
    for i in range(len(food_times)):
        foods.append([food_times[i], i])

    foods.sort()
    pretime = 0
    n = len(food_times)
    for i in range(len(food_times)):
        time = foods[i][0] - pretime
        if time != 0:
            spend = time * n
            if spend <= k:
                k -= spend
                pretime = foods[i][0]
            else:
                k %= n
                sublist = sorted(foods[i:], key=itemgetter(1))
                return sublist[k][1]+1
        n -= 1
    return -1


print(solution([3,5,1,6,5,3], 20))