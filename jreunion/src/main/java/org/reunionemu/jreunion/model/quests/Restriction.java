package org.reunionemu.jreunion.model.quests;

import org.reunionemu.jreunion.game.Player;

public interface Restriction {

	boolean isAllowed(Player player);

}
