package org.reunionemu.jreunion.events.client;

import org.reunionemu.jreunion.server.Client;


public class ClientSendEvent extends ClientEvent {

	public ClientSendEvent(Client client) {
		super(client);
	}

}
