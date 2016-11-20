package com.fatih.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatih.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static List<User> users;
	
	private static final AtomicLong counter=new AtomicLong();
	
	static{
		
		users=populateDummyUsers();
	}
	
	
	
	
	
	

	@Override
	public User findById(long id) {
		for (User user : users) {
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for (User user : users) {
			if(user.getName().equalsIgnoreCase(name));
			return user;
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
		
	}

	@Override
	public void updateUser(User user) {
		int index=users.indexOf(user);
		users.set(index, user);
		
	}

	@Override
	public void deleteUserById(long id) {
		for(Iterator<User> iterator=users.iterator();iterator.hasNext();){
			User user=iterator.next();
			if(user.getId()==id){
				iterator.remove();
			}
		}
		
	}

	@Override
	public List<User> findAllUser() {
		
		return users;
	}

	@Override
	public void deleteAllUser() {
		users.clear();
		
	}

	@Override
	public boolean isUserExist(User user) {
		if(findByName(user.getName())!=null){
		return true;
		
	}else{
		return false;
	}
		
		
		
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users=new ArrayList<User>();
		
		users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
        users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
        users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
        users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
        return users;
		
		
	}
	

}
