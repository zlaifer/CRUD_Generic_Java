/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

/**
 *
 * @author HP 240 G6
 */
public class DateUtil {
    
    private static DateUtil instance;
    
    private DateUtil(){
        
    }
    
    public synchronized static DateUtil getInstance(){
        if(instance == null){
            instance = new DateUtil();
        }
        return instance;
    }
    
    public Date getCurrentDate(){
        long millis = System.currentTimeMillis();
        return new Date(millis);
    }
}
