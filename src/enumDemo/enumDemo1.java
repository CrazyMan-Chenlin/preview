package enumDemo;

public class enumDemo1 {
    public static void main(String[] args) {
       printScore(Score.A);
        }
    private static void printScore(Score score){  //打印方法
        System.out.println(score.getResult());
        //获取枚举类的每个一个值
        Score[] values = Score.values();
        for (Score value:values){
            System.out.println(value);
        }
    }
}
/*class Score{ //成绩类
    private Score(){   //私有化构造方法，让用户不得自行构建
    }
    public static final Score A = new Score();
    public static final Score B = new Score();
    public static final Score C = new Score();
    public static final Score D = new Score();
    public static final Score E = new Score();
}*/
enum Score{    //枚举类就如同上述的Score类
    A("100-90"),
    B("89-80"),
    C("79-70"),
    D("69-60"),
    E("59-0");
    public String getResult() {
        return result; }
    private String result;
    Score(String result){
        this.result=result;
    }
}