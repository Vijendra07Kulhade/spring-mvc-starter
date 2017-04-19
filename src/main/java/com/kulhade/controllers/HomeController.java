package com.kulhade.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kulhade.entity.Product;
import com.kulhade.entity.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


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
    @RequestMapping("/home")
    public ModelAndView helloWorld() {

        String message = "Spring MVC Playground...";
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

    @RequestMapping(value="form" , method= RequestMethod.GET)
    public ModelAndView getForm()
    {
        return new ModelAndView("formSubmit", "prdt", new Product());

    }

    @RequestMapping(value="uploadMultipart" , method= RequestMethod.GET)
    public String uploadMultipartForm()
    {
        return "uploadMultiPart";

    }

    @RequestMapping(value = "uploadMultipart", method=RequestMethod.POST)
    public String uploadMultipart(@RequestParam("name") String name,
                                  @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            System.out.println("Blank File along with description "+name);
        }else {
            System.out.println("Uploaded File along with description " + name);
        }
        return "uploadMultiPart";
    }

    @RequestMapping(value="/productlist/addproduct" , method= RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView addProdt(@ModelAttribute("prdt") Product p,BindingResult bindingResult)
    {

        //pd.addProduct(p);
        if(bindingResult.hasErrors()){
            System.out.println("Error Occurred "+bindingResult.getAllErrors());
            return new ModelAndView("formSubmit", "prdt", new Product());
        }
        System.out.println(" No Error "+ p);

        if(p.getImage().isEmpty()){
            System.out.println(" No File !!!!");
        }else{

            System.out.println("  File in Product!!!!"+p.getImage().getOriginalFilename());
        }

        return new ModelAndView("formSubmit", "prdt", p);
    }


}
