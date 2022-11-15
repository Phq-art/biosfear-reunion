package org.reunionemu.jreunion.model.quests.objectives;

import org.reunionemu.jreunion.model.quests.Objective;

public interface ObjectiveState {
	
	public Objective getObjective();
	
	public boolean isComplete();

}
