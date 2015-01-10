package com.sishuok.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sishuok.entity.User;

@RestController
@RequestMapping({ "/system/users" })
public class UsersApi {
	public static List<User> users = new ArrayList<User>();

	@RequestMapping(method = RequestMethod.GET)
	public User index() {
		return new User();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void create(User user) {
		users.add(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void edit(User user) {
		for (User tmp : users) {
			if (tmp.getName().equals(user.getName())) {
				BeanUtils.copyProperties(user, tmp);
			}
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void destory(User user) {
		for (User tmp : users) {
			if (tmp.getName().equals(user.getName())) {
				user = tmp;
			}
		}
		users.remove(user);
	}

}
