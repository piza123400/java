import java.util.PrimitiveIterator;
import java.util.Scanner;

import java.util.Scanner;
import org.omg.CORBA.PRIVATE_MEMBER;


	class Add{
		private int a, b;
		public void  setValue(int a, int b) {
			this.a = a;
			this.b = b; // +
			
		}
		public int calculate() {
			return a+b;
		}
	}
	class Sub{
		private int a, b;
		public void  setValue(int a, int b) {
			this.a = a;
			this.b = b; // -
			
		}
		public int calculate() {
			return a-b;
		}
	}
	class Mul{
		private int a, b;
		public void  setValue(int a, int b) {
			this.a = a;
			this.b = b; // *
			
		}
		public int calculate() {
			return a*b;
		}
	}
	class Div{
		private int a, b;
		public void  setValue(int a, int b) {
			this.a = a;
			this.b = b;  // 나누기
		}
		public int calculate() {
			int  res=0;
			try{
				res = a/b;
			}catch(ArithmeticException e){
				System.out.print("0으로 나눌수는 없습니다"); // 0이라는 수가 들어갈때의 버그
			}
			return res;
		}
	}

	public class CAL{
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("두 수의 연산자를 입력하시오"+" ");
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			char operator = scanner.next().charAt(0);
			switch (operator){
			case '+':
				Add add = new Add();
				add.setValue(a, b);
				System.out.println(add.calculate());
				break;
			case '-':
				Sub sub = new Sub();
				sub.setValue(a, b);
				System.out.println(sub.calculate());
				break;
			case '*':
				Mul mul = new Mul();
				mul.setValue(a, b);
				System.out.println(mul.calculate());
				break;
			case '/':
				Div div = new Div();
				div.setValue(a, b);
				System.out.println(div.calculate());
				break;
				default:
					System.out.println("잘못된 연산자 입니다");
			}
			scanner.close();


	}

}