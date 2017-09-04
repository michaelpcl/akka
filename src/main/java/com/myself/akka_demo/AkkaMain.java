package com.myself.akka_demo;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:39
 */
public class AkkaMain {

    public static void main(String[] args) throws Exception {

        final ActorSystem system = ActorSystem.create("hello-akka");

        // 创建一个Actor的实例，名称为greeter
        ActorRef greeter = system.actorOf(Props.create(ClientGreeterActor.class), "greeter");
        System.out.println(greeter.path());
        //greeter.tell(new String("A"),null);
        
        //final ActorSelection selection = system.actorSelection("akka://helloakka/user/greeter");
        //selection.tell(new WhoToGreet("akka"), ActorRef.noSender());


        // 新创建一个Actor的实例，名称为greetPrinter
        ActorRef greetPrinter = system.actorOf(Props.create(ServerGreetPrinterActor.class),"greetPrint");
        System.out.println(greetPrinter.path());
        //greetPrinter.tell(new String("akka"),null);


        // 先发第一个消息,消息类型为WhoToGreet
        greeter.tell(new String("A"),greetPrinter);
        greeter.tell(new String("B"),greetPrinter);
        greeter.tell(new String("D"),greetPrinter);




        //system.shutdown();
    }
}
