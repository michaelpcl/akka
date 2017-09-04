package com.myself.akka_demo;

import akka.actor.UntypedActor;

/**
 * 打印招呼
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:45
 */
public class ServerGreetPrinterActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("***********" + message.toString());
        getSender().tell(new String("success"), getSelf());
    }
}
