package com.mindfulqatar.jobportal.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OrderStatusEnum {
	CREATED("Created"),

	FAILED("Failed"),

	PAID("Paid");

	private String value;

	private OrderStatusEnum(String val) {
		this.value = val;
	}

	public String getValue() {
		return value;
	}

	public static List<String> getList() {
		List<String> orderStatusEnumList = new ArrayList<String>();
		for (OrderStatusEnum item : OrderStatusEnum.values()) {
			orderStatusEnumList.add(item.name());
		}
		return orderStatusEnumList;
	}

	public static List<String> getValues() {
		List<String> orderStatusEnumList = new ArrayList<String>();
		for (OrderStatusEnum item : OrderStatusEnum.values()) {
			orderStatusEnumList.add(item.getValue());
		}
		return orderStatusEnumList;
	}

	public static Map<String, String> getMap() {
		Map<String, String> hashMap = new HashMap<String, String>();
		for (OrderStatusEnum item : OrderStatusEnum.values()) {
			hashMap.put(item.getValue(), item.name());
		}
		return hashMap;
	}

	public static OrderStatusEnum getByValue(String value) {
		OrderStatusEnum result = OrderStatusEnum.CREATED;
		for (OrderStatusEnum item : OrderStatusEnum.values()) {
			if (item.getValue().equals(value)) {
				result = item;
				break;
			}
		}
		return result;
	}

}
