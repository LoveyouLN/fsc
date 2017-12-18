package com.org.fsc.ssh.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.fsc.ssh.food.service.FoodService;
import com.org.fsc.ssh.menu.service.MenuService;
import com.org.fsc.ssh.order.service.OrderService;
import com.org.fsc.ssh.teble.service.TableService;
import com.org.fsc.ssh.user.service.UserService;

public class CommonController {

	//用户
	@Autowired
	protected UserService userService;

	//菜单
	@Autowired
	protected MenuService menuService;

	//食物
	@Autowired
	protected FoodService foodService;

	//桌子
	@Autowired
	protected TableService tableService;

	//桌子
	@Autowired
	protected OrderService orderService;

}
