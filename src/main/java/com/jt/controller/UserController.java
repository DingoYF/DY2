package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<User> list = userMapper.selectList(null);
		model.addAttribute("userList", list);
		return "userList";
	}
	@RequestMapping("/ajax")
	public String toAjax() {
		return "ajax";
	}
	@RequestMapping("/findAjax")
	@ResponseBody
	public JSONPObject testJsonpObject(String callback) {
		return new JSONPObject(callback, userMapper.selectList(null));
	}
	@RequestMapping("/findAjax1")
	@ResponseBody
	public List<User> findAjax() {
		return userMapper.selectList(null);
	}
	
	@RequestMapping("/doDelete")
	@ResponseBody
	public void  doDelete(Integer id) {
		userMapper.deleteById(id);
	}
}
