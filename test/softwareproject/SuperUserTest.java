package softwareproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuperUserTest {

	@Test
	void testDeleteBook() {
		SuperUser manager=new SuperUser();
		Book b1=new Book();b1.setTitle("book1");
		Book b2=new Book();b2.setTitle("Book2");b2.setAuthor("author2");
		BookManage.Allbooklist.add(b1);
		BookManage.Allbooklist.add(b2);
		assertEquals(BookManage.Allbooklist.size(),2);
		manager.deleteBook(b1);
		assertEquals(BookManage.Allbooklist.size(),1);

	}


	@Test
	void testUserActivation() {
		GeneralUser user=new GeneralUser();
		SuperUser manager=new SuperUser();
		assertEquals(user.isIsactivated(),true);
		manager.userActivation(user, "false");
		assertEquals(user.isIsactivated(),false);
		manager.userActivation(user, "true");
		assertEquals(user.isIsactivated(),true);
		manager.userActivation(user, "qq");
		assertEquals(user.isIsactivated(),true);

	}

	@Test
	void testUserDelete() {
		GeneralUser user=new GeneralUser();
		SuperUser manager=new SuperUser();
		assertEquals(SuperUser.userlist.size(),1);
		manager.userActivation(user, "false");
		manager.userDelete(user);
		assertEquals(SuperUser.userlist.size(),0);

	}

	@Test
	void testLogin() {
		SuperUser manager=new SuperUser();
		assertEquals(manager.islogin,false);
		manager.login("admin1", "nayana1");
		assertEquals(manager.islogin, false);
		manager.login("admin", "nayana");
		assertEquals(manager.islogin, true);
	}


	@Test
	void testBookSearch() {
		SuperUser manager=new SuperUser();
		GeneralUser user=new GeneralUser("testuser1", "1245", "Å×½ºÆ®1", "010-1234-5678", "test1@cau.ac.kr");
		user.registerBook("book1", "aaa", "abc", 2020, 4500, "good");
		user.registerBook("book2", "bbb", "sdf", 2020, 4500, "good");	
		assertEquals(manager.bookSearch("1", "book1").get(0).getTitle(),"book1");
		assertEquals(manager.bookSearch("2", "1001").get(0).getISBN(),1001);	
		assertEquals(manager.bookSearch("3", "bbb").get(0).getAuthor(),"bbb");	



	
	}

}
