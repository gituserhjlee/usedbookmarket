package softwareproject;

import java.util.ArrayList;
import java.util.Iterator;

public class GeneralUser extends User {
	
	private String name;
	private String phoneNum;
	private String email;
	private int index=0;
	ArrayList<Book> mybooklist;
	
	
	GeneralUser(){
		mybooklist=new ArrayList<Book>();
		SuperUser.userlist.add(this);
	};
	
	GeneralUser(String id, String password, String name, String phoneNum, String email){
		setId(id);
		setPassword(password);
		this.name=name;
		this.phoneNum=phoneNum;
		this.email=email;
		mybooklist=new ArrayList<Book>();
		SuperUser.userlist.add(this);

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void registerBook(String title, String author, String publisher, int year, int price, String condition) {
		Book book= new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setYear(year);
		book.setPrice(price);
		book.setCondition(condition);
		book.setUserID(getId());
		book.setUserEmail(email);
		Book.ISBN++;
		book.setISBN(Book.ISBN);
		mybooklist.add(book);
		BookManage.Allbooklist.add(book);
		
	}
	
	public void registerBook(String title, String author, String publisher, int year, int price) {
		Book book= new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setYear(year);
		book.setPrice(price);
		book.setUserID(getId());
		book.setUserEmail(email);
		Book.ISBN++;
		book.setISBN(Book.ISBN);
		mybooklist.add(book);
		BookManage.Allbooklist.add(book);
		System.out.println("책이 등록되었습니다.");
	}
	public void registerBook(String title, String author, String publisher, int year) {
		Book book= new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setYear(year);
		book.setUserID(getId());
		book.setUserEmail(email);
		Book.ISBN++;
		book.setISBN(Book.ISBN);
		mybooklist.add(book);
		BookManage.Allbooklist.add(book);
		System.out.println("책이 등록되었습니다.");
	}
	public void registerBook(String title, String author, String publisher) {
		Book book= new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setUserID(getId());
		book.setUserEmail(email);
		Book.ISBN++;
		book.setISBN(Book.ISBN);
		mybooklist.add(book);
		BookManage.Allbooklist.add(book);
		System.out.println("책이 등록되었습니다.");
	}
	public void registerBook(String title, String author) {
		Book book= new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setUserID(getId());
		book.setUserEmail(email);
		Book.ISBN++;
		book.setISBN(Book.ISBN);
		mybooklist.add(book);
		BookManage.Allbooklist.add(book);
		System.out.println("책이 등록되었습니다.");
	}
	public void registerBook(String title) {
		Book book= new Book();
		book.setTitle(title);
		book.setUserID(getId());
		book.setUserEmail(email);
		Book.ISBN++;
		book.setISBN(Book.ISBN);
		mybooklist.add(book);
		BookManage.Allbooklist.add(book);
		System.out.println("책이 등록되었습니다.");
	}
	
	public void showUserInfo() {
		System.out.println(getId()+"/"+getPassword()+"/"+getName()+"/"+getPhoneNum()+"/"+getEmail()+"/"+isIsactivated());
	}
	
	public void deleteMyBook(Book book) {
		
		mybooklist.remove(book);
		BookManage.Allbooklist.remove(book);
		System.out.println(book.getTitle()+"이 삭제되었습니다");
		book=null;
		
	}
	public void deleteAllMyBook() {
		
		for(Book b:mybooklist) {
			BookManage.Allbooklist.remove(b);
		}
		mybooklist.clear();
	}
	public void buyBook(GeneralUser guser, Book book) { 
		String purchaser=guser.email;
		String seller=book.getUserEmail();
		System.out.println("구매자"+purchaser+"소유자"+seller+"메일이 발송되었습니다");
			
	}
	
	public void searchMyBook() {
		index=0;
		for(Iterator<Book>iter=mybooklist.iterator();iter.hasNext();) {
			Book b=iter.next();
			if(BookManage.Allbooklist.contains(b)==false)
				iter.remove();
			
		}
		
		for(Book b:mybooklist) {
				System.out.print(index++ +"번째/");
				b.showBookInfo();
			
		}
	}
	
	public void reviseMyBook(Book book, String section, String content) {
		switch(section) {
		case "1":
				book.setTitle(content);
				break;
		case "2":
				book.setISBN(Integer.parseInt(content));
				break;
		case "3":
				book.setAuthor(content);
				break;
		case "4":
				book.setPublisher(content);
				break;
		case "5":
				book.setYear(Integer.parseInt(content));
				break;
		case "6":
				book.setPrice(Integer.parseInt(content));
				break;
		case "7":
				book.setCondition(content);
				break;
		default:
				System.out.println("올바른 숫자를 입력하세요");
		}
		
	}
}
