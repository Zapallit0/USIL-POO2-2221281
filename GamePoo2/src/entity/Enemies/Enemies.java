package entity.Enemies;

import entity.Entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;



public class Enemies extends Entity {
    String stateNPC;
    public String name;
    public Enemies(GamePanel gp) {
        super(gp);
    }

    public void getNPCImages(String State, String name,String Tipo) {
            if (State == "OneState") {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (State == "TwoStates") {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/firstState.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/firstState.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/firstState.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/firstState.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/secondState.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (State == "FourStates") {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/up1.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/up2.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/down1.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/down2.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/left1.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/left2.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/right1.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/"+Tipo+"/" + State + "/" + name + "/right2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
    }

    public void setAction () {
                    actionCounter++;
                    if (actionCounter == 180) {
                        Random random = new Random();
                        int i = random.nextInt(100) + 1;
                        if (i <= 25) {
                            direction = "up";
                        }
                        if (i > 25 && i <= 50) {
                            direction = "down";
                        }
                        if (i > 50 && i <= 75) {
                            direction = "left";
                        }
                        if (i > 75) {
                            direction = "right";
                        }
                        actionCounter = 0;
            }
        }

    }

