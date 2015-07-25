package dc.util.java.arrayoper;

/**
 * Created by HB .
 */
public class ArrayOper {
    //判断数组中是否包含某一个对象
    public static boolean isContain_Obj(Object[] objArray,Object obj){
        String objType = obj.getClass().getName();
        if(objType.equals("String")){					//如果传入的是String类型
            return isContain_String(objArray,(String)obj);
        }else{
            return false;
        }

    }

    //判断集合中是否包含某一个Class
    public static boolean isContain_Class(Class[] classArray,Class classType){
        boolean blnReturn = false;
        for (Class classObj : classArray) {
            if(classType ==classObj){
                blnReturn = true;
                break;
            }
        }
        return blnReturn;
    }

    //处理元素为String的情况
    public static boolean isContain_String(Object[] objArray,String str){
        boolean blnReturn = false;
        for (Object obj : objArray) {
            if(obj.equals(str)){
                blnReturn = true;
                break;
            }
        }
        return blnReturn;
    }
}
