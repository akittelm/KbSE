/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Alex
 */
@Logable
@Interceptor
public class LoggingInterceptor implements Serializable {
    
    @Inject
    LogService logger;
    
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        LogLevel logLevel;
        final Method method = context.getMethod();
        // check if annotation is on class or method
        if((method.getAnnotation(Logable.class))!= null) {
            logLevel = method.getAnnotation(Logable.class).value();
        }
        else              
            logLevel = method.getDeclaringClass().getAnnotation(Logable.class).value();

        // invoke LogService
        logger.log(context.getClass().getCanonicalName(),logLevel,
        method.toString());
        
        return context.proceed();
    }
    
}
