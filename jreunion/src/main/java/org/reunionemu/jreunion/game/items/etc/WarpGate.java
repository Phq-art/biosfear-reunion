package org.reunionemu.jreunion.game.items.etc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.reunionemu.jreunion.game.Item;
import org.reunionemu.jreunion.game.LivingObject;
import org.reunionemu.jreunion.game.Player;
import org.reunionemu.jreunion.game.Usable;
import org.reunionemu.jreunion.game.items.equipment.ChakuranWeapon;
import org.reunionemu.jreunion.server.PacketFactory.Type;

public class WarpGate extends Etc implements Usable{
	public WarpGate(int id) {
		super(id);
		loadFromReference(id);
	}

	@Override
	public void loadFromReference(int id) {
		super.loadFromReference(id);
	}
	
	@Override
	public boolean use(Item<?> item, LivingObject user, int quickSlotPosition, int unknown) {
		if(user instanceof Player){
			Player player = (Player)user; 
			
			player.spawn();

			if (player.getClient().getVersion() >= 2000) {
				player.getClient().sendPacket(Type.UQ_ITEM, 1,
						quickSlotPosition, item.getEntityId());
			}
			
			return true;
		} else {
			LoggerFactory.getLogger(this.getClass()).warn(this.getName() + " not implemented for " + user.getName());
		}
		
		return false;
	}
}