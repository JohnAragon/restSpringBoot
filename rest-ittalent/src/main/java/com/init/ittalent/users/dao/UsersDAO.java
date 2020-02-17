package com.init.ittalent.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.ittalent.entitys.User;

public interface UsersDAO extends JpaRepository<User,Integer>{
	

}
