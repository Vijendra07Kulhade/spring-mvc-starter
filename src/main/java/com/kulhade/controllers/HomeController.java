package com.kulhade.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kulhade.entity.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 * Created by vkulhade on 6/8/2016.
 */
@Controller
public class HomeController {

    @Autowired
    @Qualifier("esClient")
    Client client;

    /*@PostConstruct
    void init(){
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", "myCluster")
                .put("client.transport.sniff", true).build();
        TransportClient client =    new TransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress("localhost",9300));
        this.client=client;
    }*/
    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }

    @RequestMapping("/user")
    public @ResponseBody IndexResponse get() throws JsonProcessingException{
        User user = new User("Vijendra","Kulhade",100L);
        IndexRequest indexRequest = new IndexRequest("users","user",user.getFirstName());
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        indexRequest.source(objectMapper.writeValueAsString(user));
        IndexResponse response = client.index(indexRequest).actionGet();
        return response;
    }
}
