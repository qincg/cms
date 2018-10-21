package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/*
*  解决request传参中文乱码问题
* */
public class ParamUtil {
    private static Logger logger = LogManager.getLogger();

    /**
     *  获取单个参数
     * @param request
     * @param paramName
     * @return
     */
    public static String getParam(HttpServletRequest request,String paramName){
        String value = "";

        value = new String(request.getParameter(paramName).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return value;
    }

    public static Map<String,String[]> getAllParams(HttpServletRequest request){
        Map<String,String[]> paramsMap = request.getParameterMap();
        for (Map.Entry<String,String[]> entry : paramsMap.entrySet()){
            String[] paramValues = entry.getValue();
            for (int i =0 ; i < paramValues.length;i++){
                paramValues[i] = new String(paramValues[i].getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            }
        }
        return paramsMap;
    }
}
