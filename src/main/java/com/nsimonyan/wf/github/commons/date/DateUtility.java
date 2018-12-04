package com.nsimonyan.wf.github.commons.date;


import java.time.LocalDate;
import java.time.ZonedDateTime;

public class DateUtility {
    private DateUtility(){}
    
    public static LocalDate toDate(String date) {
    	ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);
        return zonedDateTime.toLocalDate();
    }	
}
