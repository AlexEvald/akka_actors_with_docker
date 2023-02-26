package com.springdemo.demo.akka;


import akka.actor.*;

import org.springframework.stereotype.Component;


@Component
public class ActorUtils {

    public void createActor(){
        ActorSystem system = ActorSystem.create("test-system");
//        ActorSystem system1 = context().system();
        ActorRef readingActorRef
                = system.actorOf(Props.create(MyActor.class), "my-actor");

        ActorRef readingActor = system.actorOf(
                ReadingActor.props("Test 123 "), "readingActor");
        readingActor.tell(ReadingActor.ReadLines.class,ActorRef.noSender());

    }

}
