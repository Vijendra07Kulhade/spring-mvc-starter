package com.kulhade.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Created by vkulhade on 6/8/2016.
 */
public class CustomObjectMapper extends ObjectMapper{

    public CustomObjectMapper(SerializationFeature feature,boolean value) {
        this.configure(feature, value);
    }
}
