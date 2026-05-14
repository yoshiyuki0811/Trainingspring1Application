package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import lombok.RequiredArgsConstructor;

//ユーザー情報

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	/**
	 * ユーザー情報一覧画面を表示
	 * @pram model Model
	 * @return ユーザー情報一覧画面のHTML
	 */

	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}

	/**
	 * ユーザー新規登録画面表示
	 * @param model Model
	 * @param ユーザー情報一覧画面
	 */

	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		return "user./add";
	}

	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */

	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {

		User user = userService.findById(id);
		model.addAttribute("userData", user);

		return "user/view";
	}

}
