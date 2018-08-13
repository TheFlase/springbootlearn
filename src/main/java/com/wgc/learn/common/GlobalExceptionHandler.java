package com.wgc.learn.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一处理
 * Created by Administrator on 8/13/2018.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR_VIEW = "/error/error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = AppException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,Exception e){
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Some data..");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }
}
