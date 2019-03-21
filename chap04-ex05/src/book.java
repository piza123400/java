
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
		this(title, "작가미상");
	}
	
	public book(String title, String auther) {
		this.title = title;
		this.auther = auther;
		
	}

	public static void main(String[] args) {
		book littlePrince = new book("어린이","유정재");
		book lovestory = new book("간영훈전");
		book emptyBook = new book();
		
		littlePrince.show();
		lovestory.show();
		emptyBook.show();
		// TODO Auto-generated method stub

	}

}
