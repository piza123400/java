
public class ThreadMainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priorty = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		System.out.println("���� ������ �̸� =" + name);
		System.out.println("���� ������ ID =" + id);
		System.out.println("���� ������ �켱���� �� =" + priorty);
		System.out.println("���� ������ ���� =" + s);
		
		
		
		
		
		new ThreadMainEx();
	}

}
