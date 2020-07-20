package softwareproject;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int price;
	private String condition;
	private String userID;
	private String userEmail;
	private int iSBN;
	public static int ISBN=1000;
	
	Book(){};


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public int getISBN() {
		return iSBN;
	}
	public void setISBN(int iSBN) {
		this.iSBN = iSBN;
	}
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void showBookInfo() {
		System.out.println("제목:"+getTitle()+" /ISBN:"+ getISBN()+ " /작가:" +getAuthor()+" /출판사:"+ getPublisher()+ " /출판년도: "+getYear()+" /가격: "+ getPrice()+ " /책상태:"+getCondition());
	}
	
}
