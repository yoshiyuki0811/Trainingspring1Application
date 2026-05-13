package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	private final UserRepository userRepository;

	public List<User> searchAll() {

		//ユーザーテーブルの内容を全検索
		return userRepository.findAll();

	}

}
