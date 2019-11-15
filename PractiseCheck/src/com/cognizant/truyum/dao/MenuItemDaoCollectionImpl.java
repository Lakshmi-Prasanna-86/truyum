package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import java.util.*;

/**
 * @author prasanna
 */

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			try {
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(000001, "sandwich", 99.00f, true,
						DateUtil.convertToDate("15/03/2017"), "Main Course",
						true));
				menuItemList.add(new MenuItem(000002, "Burger", 129.00f, true,
						DateUtil.convertToDate("23/12/2017"), "Main Course",
						false));
				menuItemList.add(new MenuItem(000003, "Pizza", 149.00f, true,
						DateUtil.convertToDate("21/08/2018"), "Main Course",
						false));
				menuItemList.add(new MenuItem(000004, "French Fries", 57.00f,
						false, DateUtil.convertToDate("02/07/2017"),
						"Starters", true));
				menuItemList.add(new MenuItem(000005, "Chocolate Brownie",
						32.00f, true, DateUtil.convertToDate("02/11/2022"),
						"Dessert", true));
			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub

		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Date today = new Date();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().getTime() <= today.getTime()
					&& menuItem.isActive()) {
				menuItemListCust.add(menuItem);
			}
		}
		return menuItemListCust;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for (MenuItem menuItemForModification : menuItemList) {
			if (menuItem.getId() == menuItemForModification.getId()) {
				menuItemForModification.setName(menuItem.getName());
				menuItemForModification.setCategory(menuItem.getCategory());
				menuItemForModification.setDateOfLaunch(menuItem
						.getDateOfLaunch());
				menuItemForModification.setFreeDelivery(menuItem
						.isFreeDelivery());
				menuItemForModification.setPrice(menuItem.getPrice());
				menuItemForModification.setActive(menuItem.isActive());

			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem menuItem : menuItemList) {
			if (menuItemId == menuItem.getId()) {
				return menuItem;
			}
		}
		return null;
	}

}
