package com.dreamchain.skeleton.dao.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.model.User;

@Transactional
public class UserDaoImplTest extends DaoTest {
	
	@Autowired UserDaoImpl userDaoImpl;
	
	@Test
	public void all_fields_are_persisted() {
		User user = new User();
		user.setFirstName("FirstName1");
		user.setLastName("LastName1");
		user.setEmail("simon@domain.com");
		user.setAddress("31 My Street\nTown, TN 38103");
		userDaoImpl.save(user);
		List<User> users = userDaoImpl.findAll();
		Assert.assertEquals("FirstName1", users.get(0).getFirstName());
		Assert.assertEquals("LastName1", users.get(0).getLastName());
		Assert.assertEquals("simon@domain.com", users.get(0).getEmail());
		Assert.assertEquals("31 My Street\nTown, TN 38103", users.get(0).getAddress());
		userDaoImpl.delete(user);
	}
	
}
