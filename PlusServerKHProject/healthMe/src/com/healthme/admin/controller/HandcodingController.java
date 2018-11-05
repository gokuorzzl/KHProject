package com.healthme.admin.controller;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.healthme.admin.model.service.GoogleCalendarService;
import com.healthme.admin.vo.CalendarDto;
 
@Controller
public class HandcodingController {
    
    private Logger logger = LoggerFactory.getLogger(HandcodingController.class);
    
    // 캘린더리스트
    @RequestMapping(value="/coding.do", method=RequestMethod.GET)
    public String coding(Model model) {
    	System.out.println("coding.do에접근완료완료");
        logger.info("calendarList");
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            CalendarList calendarList = service.calendarList().list().setPageToken(null).execute();
            List<CalendarListEntry> items = calendarList.getItems();
            model.addAttribute("items", items);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "coding";
    }
    
    // 캘린더 생성 처리
    @RequestMapping(value="/calendarAdd.do", method=RequestMethod.POST)
    public String calendarAdd(CalendarDto calDto) {
    	System.out.println("calendarAdd.do에 접근완료완료");
        logger.info("calendarAdd "+calDto.toString());
        
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();
            calendar.setSummary(calDto.getSummary());
            calendar.setTimeZone("America/Los_Angeles");
            service.calendars().insert(calendar).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/coding.do";
    }
    
    // 캘린더 삭제 처리
    @RequestMapping(value="/calendarRemove.do", method=RequestMethod.POST)
    public String calendarRemove(HttpServletRequest req) {
    	System.out.println("/calendarRemove.do에 접근완료완료");
        logger.info("calendarRemove");
        
        String[] chkVal = req.getParameterValues("chkVal");
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            for (String calendarId : chkVal) {
                service.calendars().delete(calendarId).execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/coding.do";
    }    
    
    // 캘린더 수정 처리
    @RequestMapping(value="/calendarModify.do", method=RequestMethod.POST)
    public String calendarModify(CalendarDto calDto) {
    	System.out.println("calendarModify.do에 접근완료완료");
        logger.info("calendarModify "+calDto.toString());
        
        try {
            Calendar service = GoogleCalendarService.getCalendarService();
            com.google.api.services.calendar.model.Calendar calendar = service.calendars().get(calDto.getCalendarId()).execute();
            calendar.setSummary(calDto.getSummary());
            service.calendars().update(calendar.getId(), calendar).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/coding.do";
    }    
    
    // 캘린더 이동처리
    @RequestMapping(value="/schdule.do", method=RequestMethod.GET)
    public String schdule(Model model, String calendarId, String title) {
    	System.out.println("schdule.do에 접근 완료완료");
        logger.info("schdule");
        model.addAttribute("calendarId", calendarId);
        model.addAttribute("title", title);
        return "schdule";
    }    
}
 


