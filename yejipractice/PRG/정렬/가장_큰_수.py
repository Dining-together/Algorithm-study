numbers = [3, 30, 34, 5, 9]


def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    return str(int("".join(numbers)))


print(solution(numbers))

# num의 인수값이 1000 이하이므로 3자리수로 맞춘 뒤 비교
# [0, 0, 0]일 경우 000이 아닌 0 반환하도록
