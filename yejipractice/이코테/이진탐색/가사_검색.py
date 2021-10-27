import sys
input = sys.stdin.readline

words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]


def solution(words, queries):
    answer = [0]*(len(queries))
    for i in range(len(queries)):
        for word in words:
            isSame = True
            if len(word) != len(queries[i]):
                isSame = False
                continue
            else:
                for j in range(len(queries[i])):
                    if queries[i][j] == "?":
                        continue
                    elif queries[i][j] != word[j]:
                        isSame = False
            if isSame:
                answer[i] += 1
    return answer


print(solution(words, queries))
