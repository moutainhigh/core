package dom.gupaoedu.vip.pattern.decorator.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Tom.
 */
public class JsonLoggerFactory {

    public static JsonLogger getLogger(Class clazz) {
        // 创建被修饰的原始对象
        Logger logger = LoggerFactory.getLogger(clazz);
        // 动态的给Logger对象增加JsonLogger功能
        return new JsonLogger(logger);
    }
}
