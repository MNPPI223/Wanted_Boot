package com.wanted.exceptionhanler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionTestController {

    @GetMapping("nullpointer")
    public String nullPointer() {
       // 고의적으로 nullPointerException 발생시킴
        String str = null;
        System.out.println(str.toString());

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullHandler(Model model, NullPointerException e) {

        model.addAttribute("key", e.getMessage());
        return "error/nullPointer";
    }

    @GetMapping("userexception")
    public String userException() throws MemberNotFoundException {
        boolean check = true;
        if(check) {
            throw new MemberNotFoundException("원석님 어디갔어요.....");
        }
        return "/";
    }

        @ExceptionHandler(MemberNotFoundException.class)
        public String userException(Model model, MemberNotFoundException e){
            model.addAttribute("key", e);
            return "error/memberNotFound";
        }
}
