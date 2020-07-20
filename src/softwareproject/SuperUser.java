package softwareproject;

import java.util.ArrayList;

public class SuperUser extends User{
	
	static ArrayList<GeneralUser> userlist= new ArrayList<GeneralUser>();
	
	
	SuperUser(){
		setId("admin");
		setPassword("nayana");
	}
	
	public void deleteBook(Book book) {
		System.out.println(book.getTitle()+"�� �����Ǿ����ϴ�");
		BookManage.Allbooklist.remove(book);
		
		
	}
	
	public void searchUser() {
		int index=0;
		for(GeneralUser user:userlist) {
			System.out.print(index++ +"��° �����");
			user.showUserInfo();
		}

	}
	
	public void userActivation(GeneralUser user, String b) {
		if(b.equals("true"))
			user.setIsactivated(true);
		else if(b.equals("false"))
			user.setIsactivated(false);
		else
			System.out.println("�ùٸ� ���� �Է��ϼ���");
	}
	
	public void userDelete(GeneralUser user) {
		if(user.isIsactivated()==false) {
			user.deleteAllMyBook();
			userlist.remove(user);	
			System.out.println(user.getId()+"���� �����Ǿ����ϴ�.");
		}
		else
			System.out.println("Ȱ��ȭ�� ����ڴ� ������ �� �����ϴ�.");
	}
}


