import java.util.Scanner;

class Add {
	public static int add(int i, int j) {

		return i + j;
	}
}

class Sub {
	public static int sub(int i, int j) {

		return i - j;
	}
}

class Mul {
	public static int mul(int i, int j) {
	
		return i * j;
	}
}

class Div {
	public static int div(int i, int j) {
		
		return i / j;
	}
}

public class math {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("두 수와 연산자를 적으시오 ");
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		
		char keycode = scanner.next().charAt(0);

		switch (keycode) {
		case '+':
			
			System.out.println(Add.add(i, j));

			break;

		case '-':
			System.out.println(Sub.sub(i, j));
			
			break;
			
		case '*':
			
			System.out.println(Mul.mul(i, j));
			
			break;
			
		case '/':
			
			System.out.println(Div.div(i, j));
			
			break;
			
		default:
			System.out.println("error");
			break;
		}
		scanner.close();
	}
}
