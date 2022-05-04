package com.slyvronline.engine.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.slyvronline.engine.Game;
import com.slyvronline.engine.common.objects.GameSession;
import com.slyvronline.engine.common.objects.RenderableProperty;
import com.slyvronline.engine.server.ServerController;

public class ClientListener extends Listener {

	@Override
	public void received (Connection connection, Object object) {
		/*if (object instanceof SomeResponse) {
			SomeResponse response = (SomeResponse)object;
			System.out.println(response.text);
		}*/
		
		if (object instanceof GameSession) {
			Game.getClient().setGame((GameSession) object);
		}
		
		//Created for testing
		if (object instanceof ServerController) {
			ServerController server = (ServerController)object;
			//System.out.println(server.getName() + " CLIENT RECEIVED FROM "+connection.getRemoteAddressTCP().getHostName());
		}
		else {
			//System.out.println("CLIENT: Something received.  Unknown: "+object.getClass());
		}
	}
}
