package com.ly.annotations;

//TODO:实现预热
public @interface WarmUp {
    int iterations() default 0;
}
