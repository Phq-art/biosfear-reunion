package org.reunionemu.jreunion.game;


public class StashItem {

	private StashPosition stashPosition;

	private Item<?> item;

	public StashItem(StashPosition stashPosition, Item<?> item) {
		setStashPosition(stashPosition);
		setItem(item);
	}

	public Item<?> getItem() {
		return item;
	}

	public StashPosition getStashPosition() {
		return stashPosition;
	}

	public void setItem(Item<?> item) {
		this.item = item;
	}

	public void setStashPosition(StashPosition stashPosition) {
		this.stashPosition = stashPosition;
	}
}