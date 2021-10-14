import java.util.*;

public class 카드_정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			priorityQueue.add(sc.nextInt());
		}
		int result = 0;
		while (priorityQueue.size() != 1) {
			int a = priorityQueue.poll();
			int b = priorityQueue.poll();
			int sum = a + b;
			result += a + b;
			priorityQueue.add(sum);
		}

		System.out.print(result);

	}
}
