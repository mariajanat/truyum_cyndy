package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testgetMenuItem();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}

	public static void testgetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(1);
		System.out.println(menuItem);

	}
	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(5, "Chocolate Brownie", 64.00f, true, DateUtil.convertToDate("02/11/2022"),
				"Dessert", true);
		long productId = menuItem.getId();
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
		menuItemDao.getMenuItem(productId);
	}

}