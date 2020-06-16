package dom.gupaoedu.vip.pattern.decorator.logger;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * 扩展功能的具体装饰器：抽象装饰器的具体实现类
 */
public class JsonLogger extends LoggerDecorator {
    public JsonLogger(Logger logger) {
        super(logger);
    }

    /**
     * 对原始功能进行扩展
     */
    @Override
    public void info(String s) {
        JSONObject result = newJsonObject();
        result.put("message",s);
        logger.info(result.toString());
    }

    @Override
    public void error(String s) {
        JSONObject result = newJsonObject();
        result.put("message",s);
        logger.info(result.toString());
    }

    public void error(Exception e){
        JSONObject result = newJsonObject();
        result.put("exception",e.getClass().getName());
        String trace = Arrays.toString(e.getStackTrace());
        result.put("starckTrace",trace);
        logger.info(result.toString());
    }

    private JSONObject newJsonObject(){
        return new JSONObject();
    }
}
