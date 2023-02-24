package com.springdemo.helloworld.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;


public class ActorMine extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);


    @Override
    public Receive createReceive() {

        return receiveBuilder().match(String.class, s -> log.info("PpAME MWRI TRELA!!!! : "+ s))
                .match(Double.class, s -> log.info("Prwti fora me noumeraki : "+ s))
                .build();
    }

    public static Props props(){
        return Props.create(ActorMine.class);
    }

}
