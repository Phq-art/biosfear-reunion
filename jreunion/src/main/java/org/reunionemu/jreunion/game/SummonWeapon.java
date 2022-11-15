package org.reunionemu.jreunion.game;

import org.reunionemu.jreunion.game.items.equipment.Weapon;


public abstract class SummonWeapon extends Weapon {
	public SummonWeapon(int type) {
		super(type);
	}

	@Override
	public void loadFromReference(int type) {
		super.loadFromReference(type);
	}
}