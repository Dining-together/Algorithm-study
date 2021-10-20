'''
단순구현 O(k)

n=len(food_times)
그리디 구현 O(nlogn)
'''
# 내 풀이 -> 효율성 초과 ㅠㅠ
def solution(food_times, k):
    answer = 0
    n=len(food_times)
    new_list=[]
    
    if sum(food_times) <=k:
        return -1
        
    # 1.음식 번호, 시간을 쌍으로 가지는 새로운 리스트 만들기
    for i in range(n):
        new_list.append([i+1,food_times[i]]);
    
    #2.그 리스트를 소요 시간을 기준으로 오름차순 정렬
    sorted_list=sorted(new_list,key=lambda x : x[1])
    
    manipulate_list=sorted_list[:]
    count=0
    #3.작은 수부터 하나씩 k가 남은 음식의 리스트의 길이보다 작을 때까지 순회.
    for i in range(len(sorted_list)):
        if(k-(sorted_list[i][1]-count)*n>=0):
            k-=(sorted_list[i][1]-count)*n
            count=sorted_list[i][1]
            n-=1
            del manipulate_list[0]
            
        else:
            break
    
    #4.k가 리스트의 길이보다 작아지면 리스트를 음식번호 순으로 정렬한 후 나머지로 구함!!
    k=k%n
    manipulate_list=sorted(manipulate_list,key=lambda x : x[0])

    answer=manipulate_list[k][0]
    return answer