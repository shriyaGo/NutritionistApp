package com.globallogic.adminservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {

	@InjectMocks
	private User user;
	
	private List<User> userList = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		user = new User(1, "Shriya", "Qwerty@123", new Date(1997 - 05 - 18), "Female", "India", "North", "Veg");
		userList.add(user);
	}

	@AfterEach
	public void tearDown() {
		user = null;
		userList = null;
	}

	@Test
	public void testToString() {
		String expected = "User(userId=1, userName=Shriya, password=Qwerty@123, dob=Thu Jan 01 05:30:01 IST 1970, gender=Female, country=India, region=North, foodType=Veg)";
		assertEquals(expected, user.toString());
	}

}
