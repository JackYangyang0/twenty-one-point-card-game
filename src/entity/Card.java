package entity;

import java.util.*;

//创建卡牌实体类，用来重置卡牌（洗牌）
public class Card {
    private final List<String> cardStore = new LinkedList<>();//设置牌库
    //调用函数时，直接初始化牌库
    public Card(){
        Init();
    }
    private void Init(){
        //将54张牌依次存入牌库
        cardStore.add("♥A");cardStore.add("♣A");cardStore.add("♦A");cardStore.add("♠A");
        for (int i = 2; i <= 10; i++) {
            cardStore.add("♥" + i + "");
        }
        for (int i = 2; i <= 10; i++) {
            cardStore.add("♣" + i + "");
        }
        for (int i = 2; i <= 10; i++) {
            cardStore.add("♦" + i + "");
        }
        for (int i = 2; i <= 10; i++) {
            cardStore.add("♠" + i + "");
        }
        cardStore.add("♥J");cardStore.add("♣J");cardStore.add("♦J");cardStore.add("♠J");
        cardStore.add("♥Q");cardStore.add("♣Q");cardStore.add("♦Q");cardStore.add("♠Q");
        cardStore.add("♥K");cardStore.add("♣K");cardStore.add("♦K");cardStore.add("♠K");
        cardStore.add("小王");
        cardStore.add("大王");

    }
    //发牌操作
    public String GetCard(){
        int randomCard = (int)(Math.random() * cardStore.size());//获得随机牌
        return (String)cardStore.remove(randomCard);//将得到的牌发出
    }
}
