package org.reunionemu.jreunion.events.network;

import java.nio.channels.SocketChannel;


public class NetworkAcceptEvent extends NetworkEvent
{
	public NetworkAcceptEvent(SocketChannel socketChannel) {
		super(socketChannel);
	}

}
