package testScprts

/**
 * @author taylor
 * @date 2019/1/12
 */
class HelloOss {
    static void main(String[] args) {
        try
        {
            //String[] roots = new String[] { "src/main/groovy/testScprts/" };
            //String[] roots = new String[] { "https://duke-music-img.oss-cn-hangzhou.aliyuncs.com/test/" };
            String[] roots = new String[] { "https://dianliu.alicdn.com/test/" };

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
