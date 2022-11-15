package org.reunionemu.jreunion.game;

public class ExchangeItem extends InventoryItem {

	public ExchangeItem(Item<?> item, int x, int y) {
		super(item, new ExchangePosition(x, y));
	}
	
}