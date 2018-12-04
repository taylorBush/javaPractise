package com.youku.study.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author taylor
 * @date 2018/11/1
 */
public class Java8NashornTester {
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Runoob";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer)nashorn.eval("10 + 2");
        }
        catch (ScriptException e) {
            System.out.println("execute error" + e.getMessage());
        }

        System.out.println(result.toString());
    }
}
