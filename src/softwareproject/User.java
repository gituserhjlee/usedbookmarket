package softwareproject;

import java.util.ArrayList;

public class User {
	 private String id;
	 private String password;
	 private boolean isactivated=true;
	 boolean islogin=false;
	 
	 
	public boolean login(String id, String password) {
		if(id.equals(this.id)&&password.equals(this.password)&&isactivated==true) {
			islogin=true;
			System.out.println("로그인 되었습니다"+id+"님");
			
		}
		
		return islogin;
	}
	public void showAllBook() {
		for(Book b:BookManage.Allbooklist) {
			b.showBookInfo();
		}
	}
	
	public ArrayList<Book> bookSearch(String category,String keyword) {
		switch(category) {
			case "1":
				int ismatched=0;
				int index=0;
				ArrayList<Book> searchedbook=new ArrayList<Book>();
				for(Book b:BookManage.Allbooklist) {
					if(b.getTitle().equals(keyword)) {
						ismatched++;
						System.out.print(index+"번째 ");
						index++;
						b.showBookInfo();				
						searchedbook.add(b);
						
				
					}
				
				}	
				if(ismatched==0)
					System.out.println("일치하는 책이 없습니다.");
				else
					return searchedbook;
				break;
				
			case "2":
				int ismatched1=0;
				int index1=0;

				ArrayList<Book> searchedbook1=new ArrayList<Book>();
				for(Book b:BookManage.Allbooklist) {
					if(b.getISBN()==(Integer.parseInt(keyword))) {
						ismatched1++;
						System.out.print(index1+"번째 ");
						index1++;
						b.showBookInfo();
						searchedbook1.add(b);
						
					}
				
				}
				if(ismatched1==0)
					System.out.println("일치하는 책이 없습니다.");
				else
					return searchedbook1;
				break;
				
			case "3":		
				int ismatched2=0;
				int index2=0;

				ArrayList<Book> searchedbook2=new ArrayList<Book>();
				for(Book b:BookManage.Allbooklist) {
					if(b.getAuthor().equals(keyword)) {
						ismatched2++;
						System.out.print(index2+"번째 ");
						index2++;
						b.showBookInfo();
						searchedbook2.add(b);	
						
					}
				
				}
				if(ismatched2==0)
					System.out.println("일치하는 책이 없습니다.");
				else
					return searchedbook2;
				break;
				
			case "4":	
				int ismatched3=0;
				int index3=0;

				ArrayList<Book> searchedbook3=new ArrayList<Book>();
				for(Book b:BookManage.Allbooklist) {
					if(b.getPublisher().equals(keyword)) {
						ismatched3++;
						System.out.print(index3+"번째 ");
						index3++;
						b.showBookInfo();
						searchedbook3.add(b);	
						
					}
					
				}
				if(ismatched3==0)
					System.out.println("일치하는 책이 없습니다.");
				else
					return searchedbook3;
				break;
				
			case "5":		
				int ismatched4=0;
				int index4=0;

				ArrayList<Book> searchedbook4=new ArrayList<Book>();
				for(Book b:BookManage.Allbooklist) {
					if(b.getYear()==(Integer.parseInt(keyword))) {
						ismatched4++;
						System.out.print(index4+"번째 ");
						index4++;
						b.showBookInfo();
						searchedbook4.add(b);	
						
					}
					
				}
				if(ismatched4==0)
					System.out.println("일치하는 책이 없습니다.");
				else
					return searchedbook4;
				break;
				
			case "6":	
				int ismatched5=0;
				int index5=0;

				ArrayList<Book> searchedbook5=new ArrayList<Book>();
				for(Book b:BookManage.Allbooklist) {
					if(b.getUserID().equals(keyword)) {
						ismatched5++;
						System.out.print(index5+"번째 ");
						index5++;
						b.showBookInfo();
						searchedbook5.add(b);	
					}
					
				}
				if(ismatched5==0)
					System.out.println("일치하는 책이 없습니다.");
				else
					return searchedbook5;
				break;
				
			default:
					System.out.println("일치하는 책이 없습니다.");
					return null;

			
		}
		return null;
		}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public boolean isIsactivated() {
		return isactivated;
	}

	public void setIsactivated(boolean isactivated) {
		this.isactivated = isactivated;
	}
   
}
