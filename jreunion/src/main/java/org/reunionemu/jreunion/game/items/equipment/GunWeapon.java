package org.reunionemu.jreunion.game.items.equipment;

import org.reunionemu.jcommon.ParsedItem;
import org.reunionemu.jreunion.game.Player;
import org.reunionemu.jreunion.game.RangedWeapon;
import org.reunionemu.jreunion.server.Reference;

public class GunWeapon extends RangedWeapon {

	public GunWeapon(int id) {
		super(id);
		loadFromReference(id);
	}

	@Override
	public void loadFromReference(int id) {
		super.loadFromReference(id);
		
		ParsedItem item = Reference.getInstance().getItemReference().getItemById(id);

		if (item == null) {
			// cant find Item in the reference continue to load defaults:	
			setEnergyUsed(0);
			
		} else {
		
			if (item.checkMembers(new String[] { "EeUsed" })) {
				// use member from file
				setEnergyUsed(Integer.parseInt(item.getMemberValue("EeUsed")));
			} else {
				// use default
				setEnergyUsed(0);
			}
		}
	}

	@Override
	public boolean use(Player player) {
		int electricityUsed = getElectricityUsed();
		if (electricityUsed > 0) {
			synchronized(player){
				if(player.getElectricity() < electricityUsed) {					
					return false;				
				}
				player.setElectricity(player.getElectricity() - electricityUsed);				
			}
		}
		return true;
	}
	
	private int energyUsed;
	
	public int getElectricityUsed() {
		return energyUsed;
	}
	
	public void setEnergyUsed(int energyUsed) {
		this.energyUsed = energyUsed;
	}
	
}