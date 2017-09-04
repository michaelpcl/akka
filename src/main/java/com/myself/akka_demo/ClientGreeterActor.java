package com.myself.akka_demo;

import akka.actor.UntypedActor;

/**
 * 打招呼的Actor
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:40
 */
public class ClientGreeterActor extends UntypedActor {

    String greeting = "";
    
    @Override
    public void onReceive(Object message) throws Exception {
        String tempStr = (String)message;
        if (tempStr.equals("A")){
            greeting = "hello-AAAAAAAAAAAAAA";
            System.out.println(greeting);
        }
        else if (message.equals("B")){
            greeting = "hello-BBBBBBBBBBBBBB";
            System.out.println(greeting);
        }
        else if (message.equals("success")){
            System.out.println("accept success");
        }
        else {
            // 发送招呼消息给发送消息给这个Actor的Actor
            getSender().tell(new String("hello-hello-hello"), getSelf());
        }
    }
}
