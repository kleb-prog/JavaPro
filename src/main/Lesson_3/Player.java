package Lesson_3;

public class Player {

    String nick;
    int level;
    int HP;
    float money;

    public Player(String nick, int level, int HP, float money) {
        this.nick = nick;
        this.level = level;
        this.HP = HP;
        this.money = money;
    }

    public void info(){
        System.out.println(nick + " " + level + " " + HP + " " + money);
    }

}
