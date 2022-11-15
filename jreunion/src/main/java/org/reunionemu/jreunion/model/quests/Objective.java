package org.reunionemu.jreunion.model.quests;

import org.reunionemu.jreunion.game.quests.QuestState;
import org.reunionemu.jreunion.model.quests.objectives.ObjectiveState;

public interface Objective {
	public ObjectiveState createObjectiveState(QuestState state);
}
