package org.reunionemu.jreunion.events.client;

import org.reunionemu.jreunion.server.Client;


public class ClientDisconnectEvent extends ClientEvent {

	public ClientDisconnectEvent(Client client) {
		super(client);
	}

}
