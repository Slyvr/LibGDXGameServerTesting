package com.slyvronline.engine.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.slyvronline.engine.client.ClientController;

public class ServerListener extends Listener {
	
	@Override
	public void received (Connection connection, Object object) {
		/*if (object instanceof SomeRequest) {
			SomeRequest request = (SomeRequest)object;
			System.out.println(request.text);
			
			SomeResponse response = new SomeResponse();
			response.text = "Thanks";
			connection.sendTCP(response);
		}*/
		
		if (object instanceof ClientController) {
			ClientController client = (ClientController)object;
			System.out.println(client.getName() + " SERVER RECEIVED FROM "+connection.getRemoteAddressTCP().getHostName());
		}
	}

}
