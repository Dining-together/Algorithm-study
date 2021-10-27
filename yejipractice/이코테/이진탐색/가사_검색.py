from bisect import bisect_right, bisect_left


def count_by_range(array, left_value, right_value):
    right_idx = bisect_right(array, right_value)
    left_idx = bisect_left(array, left_value)
    return right_idx - left_idx


words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]

queries = ["fro??", "????o", "fr???", "fro???", "pro?"]

# 모든 단어들을 길이마다 나누어서 저장하기 위한 리스트
array = [[] for _ in range(10001)]
# 모든 단어들을 길이마다 나누어서 뒤집어 저장하기 위한 리스트
reversed_array = [[] for _ in range(10001)]


def solution(words, queries):
    answer = []
    for word in words:
        array[len(word)].append(word)
        reversed_array[len(word)].append(word[::-1])

    for i in range(10):
        array[i].sort()
        reversed_array[i].sort()

    for q in queries:
        if q[0] != "?":
            res = count_by_range(array[len(q)], q.replace(
                '?', 'a'), q.replace('?', 'z'))
        else:
            res = count_by_range(
                reversed_array[len(q)], q[::-1].replace('?', 'a'), q[::-1].replace('?', 'z'))
        answer.append(res)
    return answer


print(solution(words, queries))

# bisect 라이브러리 활용 연습하기 + ? -> a, z로 replace해서 사이 개수 구하는 로직 생각해내기
