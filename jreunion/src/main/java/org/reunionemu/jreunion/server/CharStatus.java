package org.reunionemu.jreunion.server;

@Deprecated
public class CharStatus {
	public int level;

	public int currHp;

	public int maxHp;

	public int currMana;

	public int maxMana;

	public int currElect;

	public int maxElect;

	public int currStm;

	public int maxStm;

	public int totalExp;

	public int lvlUpExp;

	public int lime; // Gold

	public int str;

	public int wis;

	public int dex;

	public int cons;

	public int lead;

	public int statusPoints;

	public int penaltyPoints;

	public CharStatus() {
		super();

	}

	public int getCharStatusStr() {
		return str;
	}

}