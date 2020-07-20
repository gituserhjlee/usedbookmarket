package softwareproject;

import java.util.ArrayList;

public class SuperUser extends User{
	
	static ArrayList<GeneralUser> userlist= new ArrayList<GeneralUser>();
	
	
	SuperUser(){
		setId("admin");
		setPassword("nayana");
	}
	
	public void deleteBook(Book book) {
		System.out.println(book.getTitle()+"이 삭제되었습니다");
		BookManage.Allbooklist.remove(book);
		
		
	}
	
	public void searchUser() {
		int index=0;
		for(GeneralUser user:userlist) {
			System.out.print(index++ +"번째 사용자");
			user.showUserInfo();
		}

	}
	
	public void userActivation(GeneralUser user, String b) {
		if(b.equals("true"))
			user.setIsactivated(true);
		else if(b.equals("false"))
			user.setIsactivated(false);
		else
			System.out.println("올바른 값을 입력하세요");
	}
	
	public void userDelete(GeneralUser user) {
		if(user.isIsactivated()==false) {
			user.deleteAllMyBook();
			userlist.remove(user);	
			System.out.println(user.getId()+"님이 삭제되었습니다.");
		}
		else
			System.out.println("활성화된 사용자는 삭제할 수 없습니다.");
	}
}


