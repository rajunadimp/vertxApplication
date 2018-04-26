package com.projects.raju.vertxApp.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
//import io.vertx.core.eventbus.Message;

public class PingerVerticle extends AbstractVerticle {

	  @Override
	  public void start(Future<Void> fut) {
	    EventBus eb = vertx.eventBus();
	    eb.consumer("ping", message -> {
	            System.out.println("Pinger: " + message.body());
	            if(!isAMiss()) {
	            	eb.publish("pong", "hit");
	            } else{
	            	eb.publish("miss", "ping");
	            };   
	     });
	}
	  
	  public boolean isAMiss() {
		  float randomNumber = (float) Math.random() ;
		  float skill = (float) 0.7;
		  return randomNumber >= skill;
	  } 
	  
}