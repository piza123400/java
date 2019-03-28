import java.util.Scanner;

public class GRADE {
	private int math;
	private int science;
	private int english;

	public GRADE(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	public int average() {
		return (math+english+science)/3;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수학, 영어, 과학 순으로 3개의 점수 입력 >>");
		int math = scanner.nextInt();
		int english = scanner.nextInt();
		int science = scanner.nextInt();
		GRADE me = new GRADE(math,science,english);
		System.out.println("평균은 "+me.average());
		scanner.close();
		// TODO Auto-generated method stub

	}

}
