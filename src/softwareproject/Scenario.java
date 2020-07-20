package softwareproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scenario {

	private static int isgeneraluser=2;
	static SuperUser manager=new SuperUser();
	static GeneralUser user;
	@SuppressWarnings("unused")
	public static void main(String[] args) {	
		GeneralUser testUser1=new GeneralUser("testuser1", "1245", "테스트1", "010-1234-5678", "test1@cau.ac.kr"); 
		GeneralUser testUser2=new GeneralUser("testuser2", "3452", "테스트2", "010-3452-1111", "test2@cau.ac.kr"); 
		GeneralUser testUser3=new GeneralUser("testuser3", "687213", "테스트3", "010-9784-2222", "test3@cau.ac.kr"); 
		testUser1.registerBook("book", "aaa", "abc", 2020, 4500, "good");
		testUser2.registerBook("book", "bbb", "ABC", 2020, 5000, "bad");
		testUser3.registerBook("book3", "ccc", "qwe", 2019, 5000, "bad");
		initialPage();
		
	}
	
	
		@SuppressWarnings("resource")
		private static void superusermode() {
			System.out.println("원하는 메뉴의 숫자를 입력하세요 1.등록된 책 검색 / 2. 사용자 리스트 /3.모든 책 보기/ 4.초기화면");
			Scanner num=new Scanner(System.in);
			String menu=num.next();
			
			switch(menu) {
				case "1":
					System.out.println("검색하려는 항목의 번호를 입력하세요 1.제목 /2.ISBN번호/3.저자/4.출판사/5.출판년도/6.판매자id");
					Scanner num1=new Scanner(System.in);
					String category=num1.next();
					System.out.println("검색하려는 키워드를 입력하세요");
					String keyword=num1.next();
					ArrayList<Book> searchedbook1=new ArrayList<Book>();
					searchedbook1=manager.bookSearch(category, keyword);
					if(searchedbook1==null) 
						superusermode();
							
					System.out.println("1.이전화면 / 2.책 삭제");
					String a=num1.next();
					if (a.equals("1"))
						superusermode();
					else if(a.equals("2")) {
						char check;
						ArrayList<Book> searchedbook=new ArrayList<Book>();
						searchedbook=manager.bookSearch(category, keyword);
						System.out.println("원하는 책 번호를 입력하세요");
						String booknum=num1.next();		
						for(int i = 0; i<booknum.length(); i++){
							check = booknum.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("올바른 숫자를 입력하세요");
								superusermode();
							}
						}
						if(Integer.parseInt(booknum)<searchedbook.size()) {
						
							manager.deleteBook(searchedbook.get(Integer.parseInt(booknum)));
							
						}
						else
							System.out.println("올바른 숫자를 입력하세요");
						superusermode();
					}
						
					else {
						System.out.println("올바른 번호를 입력하세요");
						superusermode();
					}
				case "2":
					Scanner num2=new Scanner(System.in);
					manager.searchUser();
					System.out.println("1.사용자 활성화 / 2. 사용자 삭제");
					String b=num2.next();
					if(b.equals("1")) {
						char check;
						System.out.println("활성화할 사용자의 번호를 입력하세요");
						String c=num2.next();
						System.out.println("활성화하려면 true, 비활성화하려면 false를 입력하세요");
						String d=num2.next();
						for(int i = 0; i<c.length(); i++){
							check = c.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("올바른 숫자를 입력하세요");
								superusermode();
							}
						}
						if(Integer.parseInt(c)<SuperUser.userlist.size()) {
							if(d.equals("true")||d.equals("false")) {
								manager.userActivation(SuperUser.userlist.get(Integer.parseInt(c)), d);
								superusermode();
							}
							else {
								System.out.println("올바른 값을 입력하세요");
								superusermode();

							}
						}
						else {
							System.out.println("올바른 값을 입력하세요");
							superusermode();
						}
					}
					else if(b.equals("2")) {
						char check;
						System.out.println("삭제할 사용자의 번호를 입력하세요");
						String e=num2.next();
						for(int i = 0; i<e.length(); i++){
							check = e.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("올바른 숫자를 입력하세요");
								superusermode();
							}
						}
						if(Integer.parseInt(e)<SuperUser.userlist.size()) {
							manager.userDelete(SuperUser.userlist.get(Integer.parseInt(e)));
							superusermode();
						}
						else {
							System.out.println("올바른 값을 입력하세요");
							superusermode();
						}
						
						
					}
					else {
						System.out.println("올바른 값을 입력하세요");
						superusermode();
						
					}
					
				case "3":
					manager.showAllBook();
					isgeneraluser=2;
					manager.islogin=false;
					initialPage();
				case "4":
					isgeneraluser=2;
					manager.islogin=false;
					initialPage();
				default:
					System.out.println("올바른 값을 입력하세요");
					isgeneraluser=2;
					manager.islogin=false;
					initialPage();
			}
			
		
	}
		@SuppressWarnings("resource")
		private static void generalusermode(GeneralUser user) {
			System.out.println("원하는 메뉴의 숫자를 입력하세요 1.등록된 책 검색 / 2. 책 등록 / 3. 자신의 책 리스트/4.모든 책 보기/5.초기화면");
			Scanner num=new Scanner(System.in);	
			String menu=num.next();
			
			switch(menu) {
				case "1": 
					System.out.println("검색하려는 항목의 번호를 입력하세요 1.제목 /2.ISBN번호/3.저자/4.출판사/5.출판년도/6.판매자id");
					Scanner num1=new Scanner(System.in);
					String category=num1.next();
					System.out.println("검색하려는 키워드를 입력하세요");
					String keyword=num1.next();
					user.bookSearch(category, keyword);
					System.out.println("1.이전 화면 / 2. 책 구입");
					String choice=num1.next();
					if(choice.equals("1"))
						generalusermode(user);
					else if(choice.equals("2")) {
						char check;
						ArrayList<Book> searchedbook=new ArrayList<Book>();
						searchedbook=user.bookSearch(category, keyword);
						if(searchedbook==null)
							generalusermode(user);
						System.out.println("구입하고싶은 책의 번호를 입력하세요");					
						Scanner a=new Scanner(System.in);
						String booknum=a.next();
						
						for(int i = 0; i<booknum.length(); i++){
							check = booknum.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("올바른 숫자를 입력하세요");
								generalusermode(user);
							}
						}
						if(Integer.parseInt(booknum)<searchedbook.size()) {
							user.buyBook(user, searchedbook.get(Integer.parseInt(booknum)));
						}
						else {
							System.out.println("올바른 번호를 입력하세요");
						}
					
						generalusermode(user);
					}
						
					else {
						System.out.println("올바른 번호를 입력하세요");
						generalusermode(user);
					}
				case "2":
					String title; String author; String publisher; int year = 0; int price; String condition;
					Scanner a=new Scanner(System.in);
					
					System.out.println("제목: ");title=a.next(); System.out.println("더이상 정보를 입력하고 싶지 않으면 stop, 계속해서 입력하려면 아무문자나 입력하세요");String stop=a.next();if(stop.equals("stop")) {user.registerBook(title);generalusermode(user);}
					System.out.println("저자: ");author=a.next(); System.out.println("더이상 정보를 입력하고 싶지 않으면 stop, 계속해서 입력하려면 아무문자나 입력하세요");String stop1=a.next();if(stop1.equals("stop")) {user.registerBook(title,author);generalusermode(user);}
					System.out.println("출판사:");publisher=a.next(); System.out.println("더이상 정보를 입력하고 싶지 않으면 stop, 계속해서 입력하려면 아무문자나 입력하세요");String stop2=a.next();if(stop2.equals("stop")) {user.registerBook(title,author,publisher);generalusermode(user);}
					System.out.println("출판년도:");
					try{
						year=a.nextInt();
					} 
					catch(InputMismatchException e) {
						year=0;
					}		
					Scanner a1=new Scanner(System.in);
					System.out.println("더이상 정보를 입력하고 싶지 않으면 stop, 계속해서 입력하려면 아무문자나 입력하세요");
					String stop3=a1.next(); 

					if(stop3.equals("stop")) {user.registerBook(title,author,publisher,year);generalusermode(user);}
					
					
					System.out.println("가격:");
					try {
						price=a1.nextInt();
					}
					catch(InputMismatchException e) {
						price=0;
					}
					Scanner a2=new Scanner(System.in);
					System.out.println("더이상 정보를 입력하고 싶지 않으면 stop, 계속해서 입력하려면 아무문자나 입력하세요");String stop4=a2.next();if(stop4.equals("stop")) {user.registerBook(title,author,publisher,year,price);generalusermode(user);}
					System.out.println("상태:");condition=a2.next(); 
					user.registerBook(title, author, publisher, year, price, condition);			
					generalusermode(user);
				
				case "3":
					char check;
					user.searchMyBook();
					Scanner b=new Scanner(System.in);
					System.out.println("원하는 책의 번호를 입력하세요");
					String index=b.next();
					for(int i = 0; i<index.length(); i++){
						check = index.charAt(i);
						if( check < 48 || check > 58)
						{
							System.out.println("올바른 숫자를 입력하세요");
							generalusermode(user);
						}
					}
					if(Integer.parseInt(index)<user.mybooklist.size()) {
						System.out.println("1.수정/2.삭제");
						String number=b.next();
						if(number.equals("1")) {
							System.out.println("고치려는 부분의 번호 입력 1.title/2.ISBN/3.author/4.publisher/5.year/6.price/7.condition");
							String section=b.next();
							System.out.println("고치려는 내용을 입력하세요");
							String content=b.next();
							user.reviseMyBook(user.mybooklist.get(Integer.parseInt(index)), section, content);
							generalusermode(user);
						}
						else if(number.equals("2")) {

							user.deleteMyBook(user.mybooklist.get(Integer.parseInt(index)));
							generalusermode(user);
						}
						else {
							System.out.println("올바른 숫자를 입력하세요");
							generalusermode(user);
						}
					}
					else {
						System.out.println("올바른 번호를 입력하세요");
						generalusermode(user);
					}
						
					
					
				case "4":
					user.showAllBook();
					isgeneraluser=2;
					user.islogin=false;
					initialPage();
				case "5":
					isgeneraluser=2;
					user.islogin=false;
					initialPage();
				default:
					System.out.println("올바른 숫자를 입력하세요");
					isgeneraluser=2;
					user.islogin=false;
					initialPage();
			}
	}
		@SuppressWarnings("resource")
		public static void initialPage() {
			String mode;
			String id, password, name, phoneNum, email;	
			
			System.out.println("원하는 모드의 번호를 누르세요 1.일반사용자 , 2.관리자  ");
			Scanner input=new Scanner(System.in);
			mode=input.next();
			
			if (mode.equals("1")) {		
					Scanner info=new Scanner(System.in);
					System.out.println("1.등록 / 2.로그인");
					String input1=info.next();
					switch(input1) {
					case "1":
						System.out.println("등록을 위해 id, password, 이름, 전화번호, 이메일을 순서대로 입력");
						id=info.next();
						password=info.next();
						name=info.next();
						phoneNum=info.next();
						email=info.next();
						user=new GeneralUser();
						user.setId(id);
						user.setPassword(password);
						user.setName(name);
						user.setPhoneNum(phoneNum);
						user.setEmail(email);
						System.out.println("등록이 완료되었습니다");
						initialPage();
					case "2":
						System.out.println("아이디 입력:");
						System.out.println("비밀번호 입력:");
						String inputid=info.next();
						String inputpassword=info.next();
						boolean islogin;
						for(GeneralUser user : SuperUser.userlist) {
							
							islogin=user.login(inputid, inputpassword);
							if(islogin==true) {
								
								isgeneraluser=1;
								break;
							}
						}

						break;
						
					default:
						System.out.println("올바른 숫자를 입력하세요");
						initialPage();
						
					}
					
					
					
				
			}
			else if(mode.equals("2")) {
				System.out.println("아이디 입력하세요");
				System.out.println("비밀번호 입력하세요");
				Scanner input1=new Scanner(System.in);
				String id1=input1.next();
				String password1=input1.next();
				manager.login(id1, password1);
				isgeneraluser=0;
			
			}
			else {
				System.out.println("올바른 숫자를 입력하세요");
				manager.islogin=false;
				initialPage();
			}
			
			
			if(isgeneraluser==1) {
				for(GeneralUser user:SuperUser.userlist) {
					
					if(user.islogin==true)
						generalusermode(user);
						
				}
				System.out.println("로그인 실패");
				initialPage();
			}
				
			else if(isgeneraluser==0) {
				if(manager.islogin==true)
					superusermode();
				else {
					System.out.println("로그인을 먼저 하세요");					
					initialPage();
				}
			}
			else {
				System.out.println("로그인 실패 ");
				initialPage();
			}
				
				
		}
		
		
		

	

}
