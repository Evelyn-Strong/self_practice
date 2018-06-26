package com.practice.demo.annoExample;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

/**
 * Created by evzhang on 2018/3/12.
 */

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component // New Designed Component as @Controller/@Service/@Repository
public @interface NewComponent  {

  String name();
  String value();
  String result() default(" Test Success ");

}
