import entity.Card;
import entity.Computer;
import entity.Player;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in); //键盘输入操作
    Card card = new Card();
    Player player = new Player(card);
    Computer computer = new Computer(card);
    public void StartGame(){
        while(true) {
            boolean judge = true;
            computer.Init_Card();
            player.Init_Card();
            System.out.println("21点游戏");
            System.out.println("*********************");
            System.out.println("A表示1点，2-10表示2-10点，J、Q、K表示10点");
            computerPrint();
            System.out.println("---------------------");
            playerPrint();
            System.out.println("---------------------");
            while (judge) {
                System.out.println("请输入指令：");
                System.out.println("输入K表示开牌；输入A表示加牌；输入R表示重置；输入Q表示退出");
                String str = input.next();
                char target = str.charAt(0);//将得到的字符串转换成字符型
                //判断玩家输入的指令，来运行操作
                switch (target) {
                    //开牌操作
                    case 'K':
                        System.out.println("*********************");
                        System.out.println("电脑的牌：");
                        System.out.println("第一张牌：" + computer.getcFirstInitCard());
                        System.out.println("第二张牌：" + computer.getcSecondInitCard());
                        System.out.println("电脑的最终点数：" + computer.getcPoints());
                        System.out.println("---------------------");
                        playerPrint();
                        //判断胜负，点数大的获胜
                        if (computer.getcPoints() < player.getpPoints()) {
                            player.addWins();
                            System.out.println("真厉害，您赢了，玩家获胜");
                        } else if (computer.getcPoints() == player.getpPoints()) {
                            player.addLoses();
                            System.out.println("平局");
                        } else {
                            System.out.println("真遗憾，您输了，电脑获胜");
                        }
                        judge = false;
                        break;
                    case 'A':
                        Integer computerTarget = (int) (Math.random()) % 2 + 1;//判断电脑加牌或者不加牌（1为不加牌，2为加牌）
                        //电脑不加牌，玩家加牌的情况
                        if (computerTarget == 1) {
                            playerResult();
                            System.out.println("---------------------");
                            //如果玩家点数超过21，则玩家输了，输出比赛结果
                            if (player.getpPoints() > 21) {
                                System.out.println("电脑的牌：");
                                System.out.println("第一张牌：" + computer.getcFirstInitCard());
                                System.out.println("第二张牌：" + computer.getcSecondInitCard());
                                System.out.println("电脑的最终点数：" + computer.getcPoints());
                                System.out.println("真遗憾，您输了，电脑获胜");
                                player.addLoses();
                            } else {
                                //否则继续
                                computerPrint();
                                System.out.println("---------------------");
                            }
                        } else { //电脑加牌的情况
                            //如果玩家点数超过21，则玩家输了，输出比赛结果
                            if (player.getpPoints() > 21 || computer.getcPoints() > 21) {

                                System.out.println("---------------------");

                                System.out.println("平局");
                                player.addDogfall();
                                break;
                            }
                            if(computer.getcPoints() > 21){
                                computerResult();
                                System.out.println("---------------------");
                                playerResult();
                                System.out.println("恭喜您，玩家获胜！");
                                player.addWins();
                            }else{
                                System.out.println("电脑加牌");
                                System.out.println("第一张牌：*");
                                System.out.println("第二张牌：" + computer.getcSecondInitCard());
                                System.out.println("第三张牌：" + computer.AddCard());
                                System.out.println("电脑可能的点数：" + computer.getcSecond() + 1 + "~" + computer.getcSecond() + 10);
                                System.out.println("---------------------");
                                playerResult();
                            }
                        }
                        break;
                    case 'R':
                        System.out.println("重新启动游戏.....");
                        new Game().StartGame();
                        return;
                    case 'Q':
                        System.out.println("游戏结束！玩家胜率为：" + player.winsRate() + "%");
                        return;
                    default:
                        System.out.println("输入的号码有误，请重新输入！");
                }

            }
        }

    }

    public void playerPrint(){
        System.out.println("玩家加牌");
        System.out.println("第一张牌：" + player.getpFirstInitCard());
        System.out.println("第二张牌：" + player.getpSecondInitCard());
        System.out.println("玩家总点数：" + player.getpPoints());
    }

    public void computerPrint(){
        System.out.println("电脑的牌：");
        System.out.println("第一张牌：*");
        System.out.println("第二张牌：" + computer.getcSecondInitCard());
        System.out.println("电脑可能的点数：" + (computer.getcSecond() + 1) + "~" + (computer.getcSecond() + 10));
    }

    public void computerResult(){
        System.out.println("电脑的牌：");
        System.out.println("第一张牌：" + computer.getcFirstInitCard());
        System.out.println("第二张牌：" + computer.getcSecondInitCard());
        System.out.println("第三张牌：" + computer.AddCard());
        System.out.println("电脑的最终点数：" + computer.getcPoints());
    }

    public void playerResult(){
        System.out.println("玩家加牌");
        System.out.println("第一张牌：" + player.getpFirstInitCard());
        System.out.println("第二张牌：" + player.getpSecondInitCard());
        System.out.println("第三张牌：" + player.AddCard());
        System.out.println("玩家总点数：" + player.getpPoints());
    }
}
