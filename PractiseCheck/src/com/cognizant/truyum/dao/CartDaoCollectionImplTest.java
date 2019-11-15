package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author prasanna
 */
public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub
		testAddCartItem();
		testGetAllCartItems();
		testremoveCartItem();
	}

	static void testAddCartItem() throws CartEmptyException {
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.addCartItem(1, 000004);
		cartDao.addCartItem(1, 000002);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		// System.out.println("Cart List after adding : " + menuItemList);
		System.out.println("Cart List after adding : ");
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());
		}
		System.out.println();

	}

	static void testGetAllCartItems() throws CartEmptyException {
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		// System.out.println("Cart List : " + menuItemList);
		System.out.println("Cart List : ");
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());
		}
		System.out.println();

	}

	static void testremoveCartItem() throws CartEmptyException {
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.removeCartItem(1, 00004);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		// System.out.println("Cart List : " + menuItemList);
		System.out.println("Cart List after removal of MenuItem with id=4:");
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem.toString());
		}
		System.out.println();
	}
}
