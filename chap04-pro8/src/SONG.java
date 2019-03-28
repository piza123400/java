
public class SONG {
	private String title;
	private String artist;
	private int year;
	private String country;

	public void Song() {
	}

	public SONG(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
		// TODO Auto-generated constructor stub
	}

	public void show() {
		System.out.print(year + "년");
		System.out.print(country + "국적의");
		System.out.print(artist + "가 부른");
		System.out.print(title);
	}

	public static void main(String[] args) {
		SONG myFavorite = new SONG("Dancing Queen", "ABBA", 1978, "스웨덴");
		myFavorite.show();
		// TODO Auto-generated method stub

	}

}
