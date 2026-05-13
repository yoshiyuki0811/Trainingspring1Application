package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
