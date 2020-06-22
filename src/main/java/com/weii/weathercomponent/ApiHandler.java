/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weii.weathercomponent;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author Patryk
 */
public class ApiHandler {
    
    
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "ca9e8ed54495b520f0eaa6879bc58dfa";  
    private static final String GET_METHOD = "GET";
    
    private static String sendRequest(String url) throws MalformedURLException, IOException{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod(GET_METHOD);
        int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK){
            return "";
        }

        return IOUtils.toString(new InputStreamReader(con.getInputStream())); 
    }
    
    public static String getWeatherInfo(String city){
        String url = CommonUtils.getSTRING_BUILDER().append(URL)
                .append("?q=").append(city)
                .append("&appid=").append(API_KEY).toString();
        
        try {
            return sendRequest(url);
        } catch (IOException ex) {
            Logger.getLogger(ApiHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public static String getWeatherInfo(double lat, double lon){
        String url = CommonUtils.getSTRING_BUILDER().append(URL)
                .append("?lat=").append(lat)
                .append("&lon=").append(lon)
                .append("&appid=").append(API_KEY).toString();
        try {
            return sendRequest(url);
        } catch (IOException ex) {
            Logger.getLogger(ApiHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
