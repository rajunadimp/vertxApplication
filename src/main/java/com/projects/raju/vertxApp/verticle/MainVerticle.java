package com.projects.raju.vertxApp.verticle;

import io.vertx.core.Vertx;

/**
 * Hello world!
 *
 */
public class MainVerticle 
{
    public static void main( String[] args ) throws InterruptedException{
    		final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new PingerVerticle());
        Thread.sleep(500);
        vertx.deployVerticle(new PongerVerticle());
        Thread.sleep(500);
        vertx.deployVerticle(new ReferreeVerticle());
        
    }
}
