package org.reunionemu.jreunion.game;

import org.reunionemu.jreunion.events.EventDispatcher;
import org.reunionemu.jreunion.events.session.SendPacketSessionEvent;
import org.reunionemu.jreunion.server.LocalMap;
import org.reunionemu.jreunion.server.PacketFactory;
import org.reunionemu.jreunion.server.PacketFactory.Type;
import org.reunionemu.jreunion.server.Sendable;
import org.reunionemu.jreunion.server.Session;
import org.reunionemu.jreunion.server.SessionList;


public abstract class WorldObject extends EventDispatcher implements Entity {
	
	private int id = -1;
	public int getEntityId() {
		return id;
	}
	
	private Interested interested = new Interested(this);

	public Interested getInterested() {
		return interested;
	}

	public void setEntityId(int id) {
		this.id = id;		
	}
	
	public void update(){
		LocalMap map = position.getLocalMap();
		
		synchronized(map){			
			map.notify();			
		}
	}
	
	private Position position = new Position();

	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public abstract void enter(Session session);
	
	public abstract void exit(Session session);
	
	public class Interested implements Sendable{

		private WorldObject entity;
		
		public WorldObject getEntity() {
			return entity;
		}
		public Interested(WorldObject entity){
			this.entity = entity;
			
		}
		public SessionList<Session> getSessions(){
			return entity.getPosition().getLocalMap().GetSessions(entity);
			
		}
		
		@Override
		public void sendPacket(Type packetType, Object... args) {
			String data = PacketFactory.createPacket(packetType, args);
			entity.fireEvent(SendPacketSessionEvent.class, null, data);
		}
	}
}