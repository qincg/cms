package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author : qcg
 * @datetime: 18-9-16 下午8:32
 * @description:
 **/
public class StrUtils {
    /**
     * 是否不为null
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /**
     *  map转换为json字符串，主要用于输出map
     * @param map
     * @return
     */
    public static String mapToString(Map map){
        String str = "";

        str = JSON.toJSONString(map);
        return str;
    }
}
