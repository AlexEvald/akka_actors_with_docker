package com.springdemo.helloworld.akka;


import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;
import akka.pattern.Patterns;
import akka.util.Timeout;

import org.springframework.stereotype.Component;

import static akka.actor.TypedActor.context;


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
