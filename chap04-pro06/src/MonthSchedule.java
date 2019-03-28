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
			System.out.println("�����ϴ�");
		else
			System.out.println(work + "�Դϴ�");
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
		System.out.println("����(1~30)?");
		int day=scanner.nextInt();
		System.out.print("����(��ĭ���� �Է�)?");
		String work = scanner.next();
		day--;
		if(day < 0 || day > nDays){
			System.out.println("��¥�� �߸� �Է��ϼ˽��ϴ�");
			
			return;
		}
		System.out.print((day+1)+"���� ������");
		days[day].set(work);
	}
	private void view(){
		System.out.println("����(1~30)?");
		int day=scanner.nextInt();
		day--;
		if(day < 0 || day > nDays){
			System.out.println("��¥�� �߸� �Է��ϼ˽��ϴ�");
			
			return;
		}
		days[day].show();
	}
	private void finish(){
		scanner.close();
		System.out.println("���α׷��� �����մϴ�");
	}
	public void run(){
		System.out.print("�̹��� ������ ���� ���α׷�");
		
		while(true){
			System.out.print("����(�Է�:1,����:2,������:3) >>");
			int menu = scanner.nextInt();
			switch(menu){
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); return;
			default:
				System.out.println("�߸� �Է��ϼ˽��ϴ�");
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