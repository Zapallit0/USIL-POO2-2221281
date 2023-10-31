package entity.playerBuilder;

import java.awt.image.BufferedImage;

public class Character {
    String name;
    int speed;
    int life;
    String state;
    String nameImg;
    int damage;
    public Character(String name, int speed, int life, int damage,String nameImg,String state){
        this.name=name;
        this.speed=speed;
        this.life=life;
        this.state=state;
        this.nameImg=nameImg;
        this.damage=damage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
