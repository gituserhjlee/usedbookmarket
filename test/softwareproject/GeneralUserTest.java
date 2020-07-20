package softwareproject;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class GeneralUserTest {

	@Test 
	void testRegisterBook(){
		GeneralUser user=new GeneralUser();
		user.registerBook("book1");
		user.registerBook("book2","author2");
		user.registerBook("book3","author3","publisher3");
		assertEquals(user.mybooklist.get(0).getTitle(),"book1");
		assertEquals(user.mybooklist.get(1).getAuthor(),"author2");
		assertEquals(user.mybooklist.get(2).getPublisher(),"publisher3");

		
	}
	
	@Test
	void testDeleteMyBook() {
		GeneralUser user=new GeneralUser();
		Book b1=new Book();b1.setTitle("book1");
		Book b2=new Book();b2.setTitle("Book2");b2.setAuthor("author2");
		user.mybooklist.add(b1);
		user.mybooklist.add(b2);
		assertEquals(user.mybooklist.size(),2);
		user.deleteMyBook(b1);
		assertEquals(user.mybooklist.size(),1);
	}

	@Test
	void testDeleteAllMyBook() {
		GeneralUser user=new GeneralUser();
		Book b1=new Book();b1.setTitle("book1");
		Book b2=new Book();b2.setTitle("Book2");b2.setAuthor("author2");
		user.mybooklist.add(b1);
		user.mybooklist.add(b2);
		assertEquals(user.mybooklist.size(),2);
		user.deleteAllMyBook();
		assertEquals(user.mybooklist.size(),0);

	}

	@Test
	void testReviseMyBook() {
		GeneralUser user=new GeneralUser();
		Book b1=new Book();b1.setTitle("book1");
		Book b2=new Book();b2.setTitle("Book2");b2.setAuthor("author2");
		user.mybooklist.add(b1);
		user.mybooklist.add(b2);
		user.reviseMyBook(b1, "1", "newbook1");
		user.reviseMyBook(b2, "3", "newauthor");
		assertEquals(user.mybooklist.get(0).getTitle(),"newbook1");
		assertEquals(user.mybooklist.get(1).getAuthor(),"newauthor");
	}

	@Test
	void testLogin() {
		GeneralUser user=new GeneralUser("id","password","name","123-456","22@naver.com");
		assertEquals(user.islogin,false);
		user.login("id", "password");
		assertEquals(user.islogin, true);
	}


	@Test
	void testBookSearch() {
		GeneralUser user=new GeneralUser("testuser1", "1245", "Å×½ºÆ®1", "010-1234-5678", "test1@cau.ac.kr");
		user.registerBook("book1", "aaa", "abc", 2020, 4500, "good");
		user.registerBook("book2", "bbb", "sdf", 2020, 4500, "good");
		assertEquals(user.bookSearch("1", "book1").get(0).getTitle(),"book1");
		assertEquals(user.bookSearch("2", "1001").get(0).getISBN(),1001);
		assertEquals(user.bookSearch("5", "2020").get(0).getYear(),2020);

	}

}
