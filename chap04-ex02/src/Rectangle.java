import java.util.Scanner;

public class Rectangle {
	int width;
	int height;

	public Rectangle () {
		
	}
	public int getArea() {
		return width * height;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle();
		Scanner scan = new Scanner(System.in);
		System.out.print("�̺�");
		
		rect.width = scan.nextInt();
		rect.height = scan.nextInt();
		
		System.out.print("�簢���� ����"+rect.getArea());
		
		scan.close();

	}

}
