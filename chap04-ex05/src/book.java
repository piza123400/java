
public class book {
	String title;
	String auther;

	void show() {
		System.out.print(title + " " + auther);
	}

	public book(){
		this(" "," ");
		//System.out.print();
	}
	
	public book(String title) {
		this(title, "�۰��̻�");
	}
	
	public book(String title, String auther) {
		this.title = title;
		this.auther = auther;
		
	}

	public static void main(String[] args) {
		book littlePrince = new book("���","������");
		book lovestory = new book("��������");
		book emptyBook = new book();
		
		littlePrince.show();
		lovestory.show();
		emptyBook.show();
		// TODO Auto-generated method stub

	}

}
