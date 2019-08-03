package com.example.springBoot28Min.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springBoot28Min.users.Users;

@Component
public class UserDao {

	private	static ArrayList<Users> user = new ArrayList<Users>();

	public void addUsers(Users userDetails) {
		user.add(userDetails);
	}

	public List<Users> getUsers() {
		
		return user;
	}

	public Users getUserById(int id) {
		Iterator<Users> itr = user.iterator();
		
		while(itr.hasNext()) {
			Users user = new Users();
			user = itr.next();
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public void deleteById(int id) {
		Iterator<Users> itr = user.iterator();
		while(itr.hasNext()) {
			Users user = itr.next();
			if(user.getId()==id) {
				itr.remove();
			}
		}
		
	}


}
