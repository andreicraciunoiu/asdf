package com.dbtechschool;

import static org.junit.Assert.*;
import org.junit.Test;
import com.dbtechschool.models.User;

public class UserModelTest {

	@Test
	public void testGetSetUser() {

		User TestUser = new User().setUsername("gica.punga").setFirstName("Gica").setLastName("Punga").setEmail("gica.punga@db.com").setPassword("qwe123").setType('a');
		
		assertEquals(TestUser.getUsername(), "gica.punga");
		assertEquals(TestUser.getFirstName(), "Gica");
		assertEquals(TestUser.getLastName(), "Punga");
		assertEquals(TestUser.getPassword(), "qwe123");
		assertEquals(TestUser.getEmail(), "gica.punga@db.com");
		assertEquals(TestUser.getType(), 'a');	
	}
}
