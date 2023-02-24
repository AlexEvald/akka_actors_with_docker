package com.springdemo.helloworld.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MathActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Integer.class, s -> log.info("Prwti fora me noumeraki : "+ s))
                .match(Double.class, this::internatMethod)
                .build();
    }

    public void internatMethod(Double number){
//        System.out.println("Mesa stin methodo magka me numeraki : "+ number );
        log.info("Mesa stin methodo magka me numeraki : "+ number);
    }

    public static Props props(){
        return Props.create(MathActor.class);
    }
}
