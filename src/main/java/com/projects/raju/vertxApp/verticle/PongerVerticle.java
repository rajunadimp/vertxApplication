package com.projects.raju.vertxApp.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
//import io.vertx.core.eventbus.Message;

public class PongerVerticle extends AbstractVerticle {

	  @Override
	  public void start(Future<Void> fut) {
	   EventBus eb = vertx.eventBus();
	   eb.consumer("pong", message -> {
	            System.out.println( "Ponger: " + message.body());
	            if(!isAMiss()) {
	            	eb.publish("ping", "hit");
	            } else{
	            	eb.publish("miss", "pong");
	            };   
	     });
	  }
	  
	  public boolean isAMiss() {
		  float randomNumber = (float) Math.random() ;
		  float skill = (float) 0.7;
		  return randomNumber >= skill;
	  } 
	 
	}