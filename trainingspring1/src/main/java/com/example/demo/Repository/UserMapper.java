package com.example.demo.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.User;
import com.example.demo.dto.UserSearchRequest;

/**
 * ユーザー情報 Maper
 */

@Mapper
public interface UserMapper {
	/**
	 * ユーザー情報検索
	 * @param user 検索用リクエストデータ
	 * @return ユーザー情報
	 */

	User search(UserSearchRequest user);
}
