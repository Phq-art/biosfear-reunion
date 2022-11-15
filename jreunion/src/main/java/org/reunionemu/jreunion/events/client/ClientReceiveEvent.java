package org.reunionemu.jreunion.events.client;

import org.reunionemu.jreunion.server.Client;


public class ClientReceiveEvent extends ClientEvent {

	public ClientReceiveEvent(Client client) {
		super(client);
	}

}
