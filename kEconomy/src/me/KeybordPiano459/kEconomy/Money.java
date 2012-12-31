package me.KeybordPiano459.kEconomy;

import me.KeybordPiano459.kEssentials.config.PlayerConfig;

public class Money {
	private static boolean logging = kEconomy.logging;
	public static Double getMoney(String player) {
		return PlayerConfig.getPlayerConfig(player).getDouble("money");
	}
	
	public static void setMoney(String player, double amount) {
		PlayerConfig.getPlayerConfig(player).set("money", amount);
		if (logging) {
	}
	
	public static void addMoney(String player, double amount) {
		double was = PlayerConfig.getPlayerConfig(player).getDouble("money");
		double now = was + amount;
		PlayerConfig.getPlayerConfig(player).set("money", now);
	}
	
	public static void subtractMoney(String player, double amount) {
		if (hasMoney(player)) {
			double was = getMoney(player);
			double now = was - amount;
			PlayerConfig.getPlayerConfig(player).set("money", now);
		} else {
			setMoney(player, 0);
		}
	}
	
	public static boolean hasMoney(String player) {
		if (getMoney(player) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean hasAccount(String player) {
		if (PlayerConfig.getPlayerConfig(player) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void createAccount(String player) {
		if (!hasAccount(player)) {
			PlayerConfig.getPlayerConfig(player).set("money", kEconomy.startingBalance);
		}
	}
	
	public static void removeMoney(String player) {
		if (hasAccount(player)) {
			setMoney(player, 0);
		} else {
			System.out.println(player + " doesn't have an account!");
		}
	}
}