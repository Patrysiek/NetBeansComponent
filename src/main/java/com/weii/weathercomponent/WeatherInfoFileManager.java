/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weii.weathercomponent;

import com.weii.weathercomponent.weather.WeatherInfoModel;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Patryk
 */
public class WeatherInfoFileManager {
    private static final String PATH = "weathers";

    
    public static List<WeatherInfoModel> readListFromFile() throws URISyntaxException, IOException{
        StringBuilder sb = CommonUtils.getSTRING_BUILDER();
        tryCreateFile();
        Files.readAllLines(Paths.get(PATH)).forEach(x->{
        sb.append(x.trim());
        });
        if(sb.length()==0){
            return Collections.emptyList();
        }
        return CommonUtils.getMapper().readValue(sb.toString(), CommonUtils.getMapper().getTypeFactory().constructCollectionType(List.class, WeatherInfoModel.class));
    }
    
    public static void saveToFile(List<WeatherInfoModel> weatherList) throws URISyntaxException, IOException{
        String json = CommonUtils.getMapper().writeValueAsString(weatherList);

        tryCreateFile();
        Files.write(Paths.get(PATH), Arrays.asList(json),StandardOpenOption.CREATE);
    }

    private static void tryCreateFile() {
         try{
         if(!Files.exists(Paths.get(PATH))){
            Files.createFile(Paths.get(PATH));     
         }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
