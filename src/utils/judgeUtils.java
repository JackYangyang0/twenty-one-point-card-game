package utils;

import java.util.HashMap;
import java.util.Map;

//构建工具类
public class judgeUtils {
    private static Map<String , Integer> map = new HashMap<>();

    //将各种牌存入map集合中，用于取值
    static{
        map.put("♥A" , 1);map.put("♣A" , 1);map.put("♦A" , 1);map.put("♠A" , 1);
        for (int i = 2; i <= 10; i++) {
            map.put("♥" + i + "", i);
        }
        for (int i = 2; i <= 10; i++) {
            map.put("♣" + i + "", i);
        }
        for (int i = 2; i <= 10; i++) {
            map.put("♦" + i + "", i);
        }
        for (int i = 2; i <= 10; i++) {
            map.put("♠" + i + "", i);
        }

        map.put("♥J" , 10);map.put("♣J" , 10);map.put("♦J" , 10);map.put("♠J" , 10);
        map.put("♥Q" , 10);map.put("♣Q" , 10);map.put("♦Q" , 10);map.put("♠Q" , 10);
        map.put("♥K" , 10);map.put("♣K" , 10);map.put("♦K" , 10);map.put("♠K" , 10);
        map.put("小王" , 10);
        map.put("大王" , 10);
    }

    public static Map<String , Integer> Get_Map(){
        return map;
    }
}
