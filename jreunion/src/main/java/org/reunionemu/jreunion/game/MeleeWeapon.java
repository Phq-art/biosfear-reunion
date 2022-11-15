package org.reunionemu.jreunion.game;

import org.reunionemu.jreunion.game.items.equipment.Weapon;


public class MeleeWeapon extends Weapon {
	public MeleeWeapon(int id) {
		super(id);
	}

	@Override
	public void loadFromReference(int id) {
		super.loadFromReference(id);
	}

	@Override
	public boolean use(Player player) {
		return true;
	}
}