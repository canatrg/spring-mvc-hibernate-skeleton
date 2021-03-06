package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.map.LazyMap;

import com.dreamchain.skeleton.model.User;

public class UserGrid {
	
	@Valid
	private Map<Long, UserCommand> userMap;
	
	@SuppressWarnings("unchecked") // Apache Commons don't do generics
	public UserGrid() {
		Factory factory = new Factory() {
			public Object create() {
				return new UserCommand();
			}
		};
		userMap = LazyMap.decorate(new HashMap<Long, UserCommand>(), factory);
	}
	
	public UserGrid(List<User> users) {
		userMap = new LinkedHashMap<Long, UserCommand>();
		for (User user : users)
			userMap.put(user.getId(), new UserCommand(user));
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		for (UserCommand userCommand : userMap.values()) {
			users.add(userCommand.toUser());
		}
		return users;
	}

	
	/* Annoying Getters and Setters start here */
	
	public Map<Long, UserCommand> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<Long, UserCommand> users) {
		this.userMap = users;
	}
	
}
