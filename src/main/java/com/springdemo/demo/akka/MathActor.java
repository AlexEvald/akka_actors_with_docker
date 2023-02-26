package com.springdemo.demo.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MathActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Integer.class, s -> log.info("First time with number : "+ s))
                .match(Double.class, this::internatMethod)
                .build();
    }

    public void internatMethod(Double number){
        log.info("Mesa stin methodo magka me numeraki : "+ number);
    }

    public static Props props(){
        return Props.create(MathActor.class);
    }
}
