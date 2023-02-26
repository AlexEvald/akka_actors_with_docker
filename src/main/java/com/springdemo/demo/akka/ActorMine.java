package com.springdemo.demo.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;


public class ActorMine extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);


    @Override
    public Receive createReceive() {

        return receiveBuilder().match(String.class, s -> log.info("Lets go : "+ s))
                .match(Double.class, s -> log.info("First time with number : "+ s))
                .build();
    }

    public static Props props(){
        return Props.create(ActorMine.class);
    }

}
