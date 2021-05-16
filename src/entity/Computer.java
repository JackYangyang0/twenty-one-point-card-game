package entity;

import utils.judgeUtils;

import java.util.Map;

public class Computer {
    private Card card;//得到牌库，可以获得抽牌权
    private String cFirstInitCard;//设置第一张初始牌
    private String cSecondInitCard;//设置第二张初始牌
    private Integer cPoints = 0;//设置总点数
    private Map map = judgeUtils.Get_Map();//得到牌库标准


    public String getcFirstInitCard() {
        return cFirstInitCard;
    }

    public String getcSecondInitCard() {
        return cSecondInitCard;
    }


    public Integer getcPoints() {
        return cPoints;
    }

    public Integer getcFirst(){
        return (Integer)map.get(cFirstInitCard);
    }

    public Integer getcSecond(){
        return (Integer)map.get(cSecondInitCard);
    }

    //创建对象时就初始化两张牌
    public Computer(Card card){
        this.card = card;
    }
    //初始化第一张和第二张牌
    public void Init_Card(){
        cFirstInitCard = card.GetCard(); //初始化
        cSecondInitCard = card.GetCard(); //初始化
        Integer first = (int)map.get(cFirstInitCard);//得到第一张牌的点数
        Integer second = (int)map.get(cSecondInitCard);//得到第二张牌的点数
        cPoints = first + second;//算出电脑点数大小
    }

    public String AddCard(){
        String s = card.GetCard();//得到卡牌
        int o = (int)map.get(s);//得到该卡牌的点数
        cPoints += o;//把点数加到总点数中
        return s;
    }

}
