package com.springdemo.demo.controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.springdemo.demo.akka.ActorMine;
import com.springdemo.demo.akka.ActorUtils;
import com.springdemo.demo.akka.MathActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        actorMine.tell("This is actorTest ", ActorRef.noSender());
        Double y = 76.4;

        actorMine.tell(y, ActorRef.noSender());




        return ResponseEntity.ok("OK");
    }
}
