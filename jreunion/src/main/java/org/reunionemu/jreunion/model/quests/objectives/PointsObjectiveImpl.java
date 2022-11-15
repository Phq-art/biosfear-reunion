package org.reunionemu.jreunion.model.quests.objectives;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.reunionemu.jreunion.game.quests.QuestState;
import org.reunionemu.jreunion.model.jpa.CounterObjectiveStateImpl;
import org.reunionemu.jreunion.model.quests.ObjectiveImpl;

@XmlType(name="points")
public class PointsObjectiveImpl extends ObjectiveImpl implements PointsObjective {
	
	@XmlValue
	protected Integer points;

	@Override
	public Integer getPoints() {
		return points;
	}
	
	@Override
	public ObjectiveState createObjectiveState(QuestState state) {
		
		return new CounterObjectiveStateImpl(state, this, getPoints());
	}

}
