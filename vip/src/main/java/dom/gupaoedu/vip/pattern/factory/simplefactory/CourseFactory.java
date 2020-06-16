package dom.gupaoedu.vip.pattern.factory.simplefactory;


/**
 * Created by Tom.
 */
public class CourseFactory {

/** 工厂方式一 此工厂代码写法美观度太差，不是架构师的写法，强烈不推荐，标识符有可能不正确*/
//    public ICourse create(String name){
//        if("java".equals(name)){
//            return new JavaCourse();
//        }else if("python".equals(name)){
//            return new PythonCourse();
//        }else {
//            return null;
//        }
//    }


/** 工厂方式二 此工厂代码写法美观度一般，这里使用反射，所传类型有可能反射失败出异常，不推荐*/
//    public ICourse create(String className){
//        try {
//            if (!(null == className || "".equals(className))) {
//                return (ICourse) Class.forName(className).newInstance();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }


/** 工厂方式三 这样的话传过来的类不符合接口单一原则，所以限制传过来的符合接口单一原则，
 * 就是有标准，只能是某个接口下面子类的,这里用泛型去限制，工厂方式四*/
//    public ICourse create(Class clazz){
//        try {
//            if (null != clazz) {
//                return (ICourse)clazz.newInstance();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 工厂方式四   强烈推荐，符合架构师
     * @param clazz
     * @return
     */
    public ICourse create(Class<? extends ICourse> clazz){
        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
