package org.reunionemu.jreunion.events.client;

import org.reunionemu.jreunion.server.Client;

public class ClientConnectEvent extends ClientEvent {

	public ClientConnectEvent(Client client) {
		super(client);
	}

}
