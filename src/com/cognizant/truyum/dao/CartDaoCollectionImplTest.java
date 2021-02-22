package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import java.util.*;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();

	}

	public static void testAddCartItem() {
		CartDao cart = new CartDaoCollectionImpl();
		cart.addCartItem(1, 2);
		try {
			ArrayList<MenuItem> cartList = (ArrayList<MenuItem>) cart.getAllCartItems(1);
			System.out.println("Items added to cart successfuly");
			System.out.println(String.format("%s  %s  %s  %s  %s  %s", "Name", "Price", "Active", "Date Of Launch",
					"Category", "Free Delivery"));

			for (MenuItem item : cartList) {

				System.out.println(String.format("%s  %s  %s  %s  %s  %s", item.getName(), item.getPrice(),
						item.isActive(), item.getDateOfLaunch(), item.getCategory(), item.isFreeDelivery()));

			}

		} catch (CartEmptyException e) {
			e.printStackTrace();
		}

	}

	public static void testGetAllCartItems() {
		CartDao cart = new CartDaoCollectionImpl();
		try {
			ArrayList<MenuItem> cartItems = (ArrayList<MenuItem>) cart.getAllCartItems((long) 1);
			System.out.println(String.format("%s  %s  %s  %s  %s  %s", "Name", "Price", "Active", "Date Of Launch",
					"Category", "Free Delivery"));
			for (MenuItem item : cartItems) {
				System.out.println(String.format("%s  %s  %s  %s  %s  %s", item.getName(), item.getPrice(),
						item.isActive(), item.getDateOfLaunch(), item.getCategory(), item.isFreeDelivery()));
			}
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}

	}

	public static void testRemoveCartItem() {
		CartDao cart = new CartDaoCollectionImpl();
		cart.removeCartItem((long) 1, (long) 2);
		try {
			ArrayList<MenuItem> cartLefts = (ArrayList<MenuItem>) cart.getAllCartItems((long) 1);
			if (cartLefts.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			} else {
				for (MenuItem item : cartLefts) {
					System.out.println(String.format("%s  %s  %s  %s  %s  %s", item.getName(), item.getPrice(),
							item.isActive(), item.getDateOfLaunch(), item.getCategory(), item.isFreeDelivery()));
				}
			}
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

}