import java.util.Scanner;

class Day {
	private String work;

	public void set(String work) {
		this.work = work;
	}

	public String get() {
		return work;
	}

	public void show() {
		if (work == null)
			System.out.println("없습니다");
		else
			System.out.println(work + "입니다");
	}
}

public class MonthSchedule {
	private int nDays;
	private Day[] days;
	private Scanner scanner;

	public MonthSchedule(int nDays) {
		this.nDays = nDays;
		this.days = new Day [nDays];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day();
		}
		scanner = new Scanner(System.in);
	}
	
	private void input(){
		System.out.println("날자(1~30)?");
		int day=scanner.nextInt();
		System.out.print("할일(빈칸없이 입력)?");
		String work = scanner.next();
		day--;
		if(day < 0 || day > nDays){
			System.out.println("날짜를 잘못 입력하셧습니다");
			
			return;
		}
		System.out.print((day+1)+"일의 할일은");
		days[day].set(work);
	}
	private void view(){
		System.out.println("날자(1~30)?");
		int day=scanner.nextInt();
		day--;
		if(day < 0 || day > nDays){
			System.out.println("날짜를 잘못 입력하셧습니다");
			
			return;
		}
		days[day].show();
	}
	private void finish(){
		scanner.close();
		System.out.println("프로그램을 종료합니다");
	}
	public void run(){
		System.out.print("이번달 스케쥴 관리 프로그램");
		
		while(true){
			System.out.print("할일(입력:1,보기:2,끝나기:3) >>");
			int menu = scanner.nextInt();
			switch(menu){
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); return;
			default:
				System.out.println("잘못 입력하셧습니다");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonthSchedule april = new MonthSchedule(30);
		april.run();

	}

}
