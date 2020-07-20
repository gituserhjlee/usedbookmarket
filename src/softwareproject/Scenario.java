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
		GeneralUser testUser1=new GeneralUser("testuser1", "1245", "�׽�Ʈ1", "010-1234-5678", "test1@cau.ac.kr"); 
		GeneralUser testUser2=new GeneralUser("testuser2", "3452", "�׽�Ʈ2", "010-3452-1111", "test2@cau.ac.kr"); 
		GeneralUser testUser3=new GeneralUser("testuser3", "687213", "�׽�Ʈ3", "010-9784-2222", "test3@cau.ac.kr"); 
		testUser1.registerBook("book", "aaa", "abc", 2020, 4500, "good");
		testUser2.registerBook("book", "bbb", "ABC", 2020, 5000, "bad");
		testUser3.registerBook("book3", "ccc", "qwe", 2019, 5000, "bad");
		initialPage();
		
	}
	
	
		@SuppressWarnings("resource")
		private static void superusermode() {
			System.out.println("���ϴ� �޴��� ���ڸ� �Է��ϼ��� 1.��ϵ� å �˻� / 2. ����� ����Ʈ /3.��� å ����/ 4.�ʱ�ȭ��");
			Scanner num=new Scanner(System.in);
			String menu=num.next();
			
			switch(menu) {
				case "1":
					System.out.println("�˻��Ϸ��� �׸��� ��ȣ�� �Է��ϼ��� 1.���� /2.ISBN��ȣ/3.����/4.���ǻ�/5.���ǳ⵵/6.�Ǹ���id");
					Scanner num1=new Scanner(System.in);
					String category=num1.next();
					System.out.println("�˻��Ϸ��� Ű���带 �Է��ϼ���");
					String keyword=num1.next();
					ArrayList<Book> searchedbook1=new ArrayList<Book>();
					searchedbook1=manager.bookSearch(category, keyword);
					if(searchedbook1==null) 
						superusermode();
							
					System.out.println("1.����ȭ�� / 2.å ����");
					String a=num1.next();
					if (a.equals("1"))
						superusermode();
					else if(a.equals("2")) {
						char check;
						ArrayList<Book> searchedbook=new ArrayList<Book>();
						searchedbook=manager.bookSearch(category, keyword);
						System.out.println("���ϴ� å ��ȣ�� �Է��ϼ���");
						String booknum=num1.next();		
						for(int i = 0; i<booknum.length(); i++){
							check = booknum.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
								superusermode();
							}
						}
						if(Integer.parseInt(booknum)<searchedbook.size()) {
						
							manager.deleteBook(searchedbook.get(Integer.parseInt(booknum)));
							
						}
						else
							System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
						superusermode();
					}
						
					else {
						System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
						superusermode();
					}
				case "2":
					Scanner num2=new Scanner(System.in);
					manager.searchUser();
					System.out.println("1.����� Ȱ��ȭ / 2. ����� ����");
					String b=num2.next();
					if(b.equals("1")) {
						char check;
						System.out.println("Ȱ��ȭ�� ������� ��ȣ�� �Է��ϼ���");
						String c=num2.next();
						System.out.println("Ȱ��ȭ�Ϸ��� true, ��Ȱ��ȭ�Ϸ��� false�� �Է��ϼ���");
						String d=num2.next();
						for(int i = 0; i<c.length(); i++){
							check = c.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
								superusermode();
							}
						}
						if(Integer.parseInt(c)<SuperUser.userlist.size()) {
							if(d.equals("true")||d.equals("false")) {
								manager.userActivation(SuperUser.userlist.get(Integer.parseInt(c)), d);
								superusermode();
							}
							else {
								System.out.println("�ùٸ� ���� �Է��ϼ���");
								superusermode();

							}
						}
						else {
							System.out.println("�ùٸ� ���� �Է��ϼ���");
							superusermode();
						}
					}
					else if(b.equals("2")) {
						char check;
						System.out.println("������ ������� ��ȣ�� �Է��ϼ���");
						String e=num2.next();
						for(int i = 0; i<e.length(); i++){
							check = e.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
								superusermode();
							}
						}
						if(Integer.parseInt(e)<SuperUser.userlist.size()) {
							manager.userDelete(SuperUser.userlist.get(Integer.parseInt(e)));
							superusermode();
						}
						else {
							System.out.println("�ùٸ� ���� �Է��ϼ���");
							superusermode();
						}
						
						
					}
					else {
						System.out.println("�ùٸ� ���� �Է��ϼ���");
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
					System.out.println("�ùٸ� ���� �Է��ϼ���");
					isgeneraluser=2;
					manager.islogin=false;
					initialPage();
			}
			
		
	}
		@SuppressWarnings("resource")
		private static void generalusermode(GeneralUser user) {
			System.out.println("���ϴ� �޴��� ���ڸ� �Է��ϼ��� 1.��ϵ� å �˻� / 2. å ��� / 3. �ڽ��� å ����Ʈ/4.��� å ����/5.�ʱ�ȭ��");
			Scanner num=new Scanner(System.in);	
			String menu=num.next();
			
			switch(menu) {
				case "1": 
					System.out.println("�˻��Ϸ��� �׸��� ��ȣ�� �Է��ϼ��� 1.���� /2.ISBN��ȣ/3.����/4.���ǻ�/5.���ǳ⵵/6.�Ǹ���id");
					Scanner num1=new Scanner(System.in);
					String category=num1.next();
					System.out.println("�˻��Ϸ��� Ű���带 �Է��ϼ���");
					String keyword=num1.next();
					user.bookSearch(category, keyword);
					System.out.println("1.���� ȭ�� / 2. å ����");
					String choice=num1.next();
					if(choice.equals("1"))
						generalusermode(user);
					else if(choice.equals("2")) {
						char check;
						ArrayList<Book> searchedbook=new ArrayList<Book>();
						searchedbook=user.bookSearch(category, keyword);
						if(searchedbook==null)
							generalusermode(user);
						System.out.println("�����ϰ���� å�� ��ȣ�� �Է��ϼ���");					
						Scanner a=new Scanner(System.in);
						String booknum=a.next();
						
						for(int i = 0; i<booknum.length(); i++){
							check = booknum.charAt(i);
							if( check < 48 || check > 58)
							{
								System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
								generalusermode(user);
							}
						}
						if(Integer.parseInt(booknum)<searchedbook.size()) {
							user.buyBook(user, searchedbook.get(Integer.parseInt(booknum)));
						}
						else {
							System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
						}
					
						generalusermode(user);
					}
						
					else {
						System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
						generalusermode(user);
					}
				case "2":
					String title; String author; String publisher; int year = 0; int price; String condition;
					Scanner a=new Scanner(System.in);
					
					System.out.println("����: ");title=a.next(); System.out.println("���̻� ������ �Է��ϰ� ���� ������ stop, ����ؼ� �Է��Ϸ��� �ƹ����ڳ� �Է��ϼ���");String stop=a.next();if(stop.equals("stop")) {user.registerBook(title);generalusermode(user);}
					System.out.println("����: ");author=a.next(); System.out.println("���̻� ������ �Է��ϰ� ���� ������ stop, ����ؼ� �Է��Ϸ��� �ƹ����ڳ� �Է��ϼ���");String stop1=a.next();if(stop1.equals("stop")) {user.registerBook(title,author);generalusermode(user);}
					System.out.println("���ǻ�:");publisher=a.next(); System.out.println("���̻� ������ �Է��ϰ� ���� ������ stop, ����ؼ� �Է��Ϸ��� �ƹ����ڳ� �Է��ϼ���");String stop2=a.next();if(stop2.equals("stop")) {user.registerBook(title,author,publisher);generalusermode(user);}
					System.out.println("���ǳ⵵:");
					try{
						year=a.nextInt();
					} 
					catch(InputMismatchException e) {
						year=0;
					}		
					Scanner a1=new Scanner(System.in);
					System.out.println("���̻� ������ �Է��ϰ� ���� ������ stop, ����ؼ� �Է��Ϸ��� �ƹ����ڳ� �Է��ϼ���");
					String stop3=a1.next(); 

					if(stop3.equals("stop")) {user.registerBook(title,author,publisher,year);generalusermode(user);}
					
					
					System.out.println("����:");
					try {
						price=a1.nextInt();
					}
					catch(InputMismatchException e) {
						price=0;
					}
					Scanner a2=new Scanner(System.in);
					System.out.println("���̻� ������ �Է��ϰ� ���� ������ stop, ����ؼ� �Է��Ϸ��� �ƹ����ڳ� �Է��ϼ���");String stop4=a2.next();if(stop4.equals("stop")) {user.registerBook(title,author,publisher,year,price);generalusermode(user);}
					System.out.println("����:");condition=a2.next(); 
					user.registerBook(title, author, publisher, year, price, condition);			
					generalusermode(user);
				
				case "3":
					char check;
					user.searchMyBook();
					Scanner b=new Scanner(System.in);
					System.out.println("���ϴ� å�� ��ȣ�� �Է��ϼ���");
					String index=b.next();
					for(int i = 0; i<index.length(); i++){
						check = index.charAt(i);
						if( check < 48 || check > 58)
						{
							System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
							generalusermode(user);
						}
					}
					if(Integer.parseInt(index)<user.mybooklist.size()) {
						System.out.println("1.����/2.����");
						String number=b.next();
						if(number.equals("1")) {
							System.out.println("��ġ���� �κ��� ��ȣ �Է� 1.title/2.ISBN/3.author/4.publisher/5.year/6.price/7.condition");
							String section=b.next();
							System.out.println("��ġ���� ������ �Է��ϼ���");
							String content=b.next();
							user.reviseMyBook(user.mybooklist.get(Integer.parseInt(index)), section, content);
							generalusermode(user);
						}
						else if(number.equals("2")) {

							user.deleteMyBook(user.mybooklist.get(Integer.parseInt(index)));
							generalusermode(user);
						}
						else {
							System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
							generalusermode(user);
						}
					}
					else {
						System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
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
					System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
					isgeneraluser=2;
					user.islogin=false;
					initialPage();
			}
	}
		@SuppressWarnings("resource")
		public static void initialPage() {
			String mode;
			String id, password, name, phoneNum, email;	
			
			System.out.println("���ϴ� ����� ��ȣ�� �������� 1.�Ϲݻ���� , 2.������  ");
			Scanner input=new Scanner(System.in);
			mode=input.next();
			
			if (mode.equals("1")) {		
					Scanner info=new Scanner(System.in);
					System.out.println("1.��� / 2.�α���");
					String input1=info.next();
					switch(input1) {
					case "1":
						System.out.println("����� ���� id, password, �̸�, ��ȭ��ȣ, �̸����� ������� �Է�");
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
						System.out.println("����� �Ϸ�Ǿ����ϴ�");
						initialPage();
					case "2":
						System.out.println("���̵� �Է�:");
						System.out.println("��й�ȣ �Է�:");
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
						System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
						initialPage();
						
					}
					
					
					
				
			}
			else if(mode.equals("2")) {
				System.out.println("���̵� �Է��ϼ���");
				System.out.println("��й�ȣ �Է��ϼ���");
				Scanner input1=new Scanner(System.in);
				String id1=input1.next();
				String password1=input1.next();
				manager.login(id1, password1);
				isgeneraluser=0;
			
			}
			else {
				System.out.println("�ùٸ� ���ڸ� �Է��ϼ���");
				manager.islogin=false;
				initialPage();
			}
			
			
			if(isgeneraluser==1) {
				for(GeneralUser user:SuperUser.userlist) {
					
					if(user.islogin==true)
						generalusermode(user);
						
				}
				System.out.println("�α��� ����");
				initialPage();
			}
				
			else if(isgeneraluser==0) {
				if(manager.islogin==true)
					superusermode();
				else {
					System.out.println("�α����� ���� �ϼ���");					
					initialPage();
				}
			}
			else {
				System.out.println("�α��� ���� ");
				initialPage();
			}
				
				
		}
		
		
		

	

}
