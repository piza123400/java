
public class TV {
	private String manufacturer;
	private int year;
	private int size;
	public TV(String manuafacturer,int year,int size){
		this.manufacturer=manuafacturer;
		this.year=year;
		this.size=size;
	}
	public void show(){
		System.out.print(this.manufacturer+"���� ����");
		System.out.print(this.year+"����");
		System.out.print(this.size+"��ġ");
	}

	public static void main(String[] args) {
		TV myTV = new TV("LG",2017,32);
		myTV.show();
		// TODO Auto-generated method stub

	}

}
