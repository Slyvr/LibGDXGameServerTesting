package com.slyvronline.engine.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.slyvronline.engine.Game;
import com.slyvronline.engine.client.ClientController;
import com.slyvronline.engine.common.objects.ClientGameSession;
import com.slyvronline.engine.common.objects.Img;

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
		
		//Passes in the object ClientGameSession which contains any inputs a client has entered.
		//The server should process any client inputs here to determine how it affects the game.
		//Server then returns the whole game session object back with updates in place
		if (object instanceof ClientGameSession) {
			ClientGameSession client = (ClientGameSession)object;
			
			client.update();
		}
		
		if (object instanceof ClientController) {
			ClientController client = (ClientController)object;
			System.out.println(client.getName() + " SERVER RECEIVED FROM "+connection.getRemoteAddressTCP().getHostName());
		}
	}

}
