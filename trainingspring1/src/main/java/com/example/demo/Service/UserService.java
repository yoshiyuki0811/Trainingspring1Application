package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	private final UserRepository userRepository;

	public List<User> searchAll() {
		;
		//ユーザーテーブルの内容を全検索
		return userRepository.findAll();

	}

	/**
	 * ユーザー情報の更新
	 * @param userRequest
	 */
	public void create(UserRequest userRequest) {

		Date now = new Date();
		User user = new User();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		userRepository.save(user);

	}

	public User findById(Long id) {
		return userRepository.findById(id).get();

	}

	public void update(UserUpdateRequest userUpdateRequest) {

		User user = findById(userUpdateRequest.getId());
		user.setAddress(userUpdateRequest.getAddress());
		user.setName(userUpdateRequest.getName());
		user.setPhone(userUpdateRequest.getPhone());
		user.setUpdateDate(new Date());
		userRepository.save(user);

	}

}
