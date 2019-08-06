package com.slyvronline.engine.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.slyvronline.engine.server.ServerController;

public class ClientListener extends Listener {

	@Override
	public void received (Connection connection, Object object) {
		/*if (object instanceof SomeResponse) {
			SomeResponse response = (SomeResponse)object;
			System.out.println(response.text);
		}*/
		
		if (object instanceof ServerController) {
			ServerController server = (ServerController)object;
			
		}
		else {
			System.out.println("CLIENT: Something received.  Unknown: "+object.getClass());
		}
	}
}
