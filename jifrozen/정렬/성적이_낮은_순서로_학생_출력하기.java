import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student other) {
        if (this.score < other.score)
            return -1;
        return 1;
    }
}

public class 성적이_낮은_순서로_학생_출력하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> students = new ArrayList<Student>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.print(students.get(i).getName() + " ");
        }

    }

}
