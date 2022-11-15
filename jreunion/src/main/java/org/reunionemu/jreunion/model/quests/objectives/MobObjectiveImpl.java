package org.reunionemu.jreunion.model.quests.objectives;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.reunionemu.jreunion.game.quests.QuestState;
import org.reunionemu.jreunion.model.jpa.CounterObjectiveStateImpl;
import org.reunionemu.jreunion.model.quests.ObjectiveImpl;

@XmlType(name="mob")
public class MobObjectiveImpl extends ObjectiveImpl implements MobObjective {
	
	@XmlAttribute(required=false)
	protected Integer amount;
	
	@XmlAttribute(required=true)
	protected Integer type;

	@Override
	public Integer getAmount() {
		return amount!=null?amount:1;
	}
	
	@Override
	public Integer getType() {
		return type;
	}
	
	@Override
	public ObjectiveState createObjectiveState(QuestState state) {		
		return new CounterObjectiveStateImpl(state, this, getAmount());
	}

}
