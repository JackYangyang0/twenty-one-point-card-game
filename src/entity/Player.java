package entity;
import utils.judgeUtils;

import java.util.Map;

public class Player {
    private Card card;//得到牌库，可以获得抽牌权
    private String pFirstInitCard;//设置第一张初始牌
    private String pSecondInitCard;//设置第二张初始牌
    private Integer pPoints = 0;//设置总点数
    private Integer winCounts = 0;//设置赢的次数
    private Integer loseCounts = 0;//设置输的次数
    private Integer dogfall = 0;//设置平局的次数
    private Map map = judgeUtils.Get_Map();//得到牌库标准

    public String getpFirstInitCard() {
        return pFirstInitCard;
    }

    public String getpSecondInitCard() {
        return pSecondInitCard;
    }

    public Integer getpPoints() {
        return pPoints;
    }


    //创建对象时就初始化两张牌
    public Player(Card card){
        this.card = card;
    }
    //初始化第一张和第二张牌
    public  void Init_Card(){
        pFirstInitCard = card.GetCard();
        pSecondInitCard = card.GetCard();
        Integer first = (int)map.get(pFirstInitCard);//得到第一张牌的点数
        Integer second = (int)map.get(pSecondInitCard);//得到第二张牌的点数
        pPoints = first + second;//算出玩家点数大小
    }

    public String AddCard(){
        String s = card.GetCard();//得到卡牌
        int o = (int)map.get(s);//得到该卡牌的点数
        pPoints += o;//把点数加到总点数中
        return s;
    }
    //计算平局数
    public void addDogfall(){dogfall++;}
    //计算赢的次数
    public void addWins(){
        winCounts++;
    }
    //计算输的次数
    public void addLoses(){
        loseCounts++;
    }
    //计算胜率
    public float winsRate(){
        return ((float)winCounts / (loseCounts+winCounts+dogfall)) * 100;
    }
}
