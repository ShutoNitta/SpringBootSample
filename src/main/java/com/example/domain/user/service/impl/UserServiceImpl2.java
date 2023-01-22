package com.example.domain.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Salary;
import com.example.domain.user.service.UserService;
import com.example.repository.UserRepository;
import com.example.repository.UserRepository2;

@Service
@Primary
public class UserServiceImpl2 implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserRepository2 repository2;

	@Autowired
	private PasswordEncoder encoder;

	@Transactional
	@Override
	public void signup(MUser user) {
		boolean exists = repository.existsById(user.getUserId());

		if(exists) {
			throw new DataAccessException("ユーザーがすでに存在") {};
		}

		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");

		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));

		repository.save(user);
	}

	@Override
	public List<MUser> getUsers(MUser user){
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();

		return repository.findAll(Example.of(user,matcher));
	}

	@Override
	public MUser getUserOne(String userId) {
		Optional<MUser> option = repository.findById(userId);
		MUser user = option.orElse(null);
		return user;
	}

	@Transactional
	@Override
	public void updateUserOne(String userId, String password, String userName) {

		String encryptPassword = encoder.encode(password);

		repository.updateUser(userId, encryptPassword, userName);
	}

	@Transactional
	@Override
	public void deleteUserOne(String userId) {
		repository.deleteById(userId);
	}

	@Override
	public MUser getLoginUser(String userId) {
		return repository.findLoginUser(userId);
	}

	@Override
	public void insertSalaryOne(Salary salary) {
		repository2.save(salary);
	}
}

