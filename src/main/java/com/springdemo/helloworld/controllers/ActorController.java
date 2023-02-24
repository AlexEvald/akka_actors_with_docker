package com.springdemo.helloworld.controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.event.Logging;
import com.springdemo.helloworld.akka.ActorMine;
import com.springdemo.helloworld.akka.ActorUtils;
import com.springdemo.helloworld.akka.MathActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/actor")
public class ActorController {


    @Autowired
    private ActorUtils actorUtils;

    @GetMapping("/")
    public ResponseEntity<String> actorTester(){


       // actorUtils.createActor();
        ActorSystem akkaSystem = ActorSystem.create("system");

        ActorRef mathActor = akkaSystem.actorOf(MathActor.props(),"mathActor");
        mathActor.tell(123, ActorRef.noSender());
        Double x = 23.4;
        mathActor.tell(x, ActorRef.noSender());

        ActorRef actorMine = akkaSystem.actorOf(ActorMine.props(),"moneActor");
        actorMine.tell("POutsa mou ", ActorRef.noSender());
        Double y = 76.4;

        actorMine.tell(y, ActorRef.noSender());

        System.out.println("POMPAAAA ENA ENA ");



        return ResponseEntity.ok("OK");
    }
}
