package org.reunionemu.jreunion.game.items.equipment;

import org.reunionemu.jreunion.game.MeleeWeapon;


public class Sword extends MeleeWeapon {
	public Sword(int id) {
		super(id);
		loadFromReference(id);
	}

	@Override
	public void loadFromReference(int id) {
		super.loadFromReference(id);
	}
}