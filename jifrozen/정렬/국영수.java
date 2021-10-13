import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
	private String name;
	private int kr;
	private int eng;
	private int math;

	public Student(String name, int kr, int eng, int math) {
		this.name = name;
		this.kr = kr;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Student other) {
		if (this.kr == other.kr && this.eng == other.eng && this.math == other.math) {
			return this.name.compareTo(other.name);
		}
		if (this.kr == other.kr && this.eng == other.eng) {
			return Integer.compare(other.math, this.math);
		}
		if (this.kr == other.kr) {
			return Integer.compare(this.eng, other.eng);
		}
		return Integer.compare(other.kr, this.kr);
	}

}

public class 국영수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kr = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			students.add(new Student(name, kr, eng, math));
		}

		Collections.sort(students);

		for (int i = 0; i < n; i++) {
			System.out.println(students.get(i).getName());
		}
	}

}
