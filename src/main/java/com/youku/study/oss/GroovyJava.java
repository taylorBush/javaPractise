package com.youku.study.oss;

import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.GroovyTestCase;
import groovy.util.GroovyTestSuite;
import junit.textui.TestRunner;
import java.util.regex.Matcher;

import javax.script.ScriptException;
import java.io.IOException;

/**
 * @author taylor
 * @date 2018/12/7
 */
public class GroovyJava {
    public static void main(String[] args) {
        scriptManager();
    }

    static void scriptManager()
    {
        try
        {
            //String[] roots = new String[] { "src/main/groovy/testScprts/" };
            String[] roots = new String[] { "https://duke-music-img.oss-cn-hangzhou.aliyuncs.com/test/" };

            GroovyScriptEngine gse = new GroovyScriptEngine(roots);
            GroovyObject gob = null;
            gob = (GroovyObject) gse.loadScriptByName("HelloWorld.groovy").newInstance();
            String result = (String) gob.invokeMethod("output", "hello");
            System.out.println(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (groovy.util.ScriptException e) {
            e.printStackTrace();
        }
    }
}
