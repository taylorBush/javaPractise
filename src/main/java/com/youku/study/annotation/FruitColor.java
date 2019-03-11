package com.youku.study.annotation;

import java.lang.annotation.*;

/**
 * @author taylor
 * @date 2019/3/11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * color enum
     */
    public enum Color {BLUE, RED, GREEN};

    /**
     * color property
     */
    Color fruitColor() default Color.GREEN;
}