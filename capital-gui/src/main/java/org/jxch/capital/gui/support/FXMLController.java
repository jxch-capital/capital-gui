package org.jxch.capital.gui.support;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface FXMLController {

    @AliasFor("fxmlPath")
    String value() default "";

    @AliasFor("value")
    String fxmlPath() default "";

}
