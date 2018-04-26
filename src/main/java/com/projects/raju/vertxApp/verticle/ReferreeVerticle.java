package com.projects.raju.vertxApp.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;

public class ReferreeVerticle extends AbstractVerticle {
	
	private int pingScore;
	private int pongScore;

	  @Override
	  public void start(Future<Void> fut) {
		
	   EventBus eb = vertx.eventBus();
	   	System.out.println("Referree starts the game!!");
	    eb.publish("ping", "hit");
	    
	    	eb.consumer("miss",  message -> {
            System.out.println( " Miss by -> " + message.body().toString());
            if(message.body().toString().equals("ping")) pongScore++;
            else if(message.body().toString().equals("pong")) pingScore++;
            
            System.out.println("   Ping:Pong :: " + pingScore + ":"+ pongScore);
	            
		    if(pingScore >= 10) System.out.println("Ping wins!!");
		    else if(pongScore >= 10) System.out.println("Pong wins!!");
		    	else {
			    	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			    eb.publish("ping", "hit"); 
		    }
	  });
	}
}