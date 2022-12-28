
package entity;
//Essa classe ira guardar as sprites de ppersonagens, npcs e cenarios.

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    
    //Para criar a animação:
    public int spriteCounter=0;
    public int spriteNum=1;
    
    //Deixar o retangulo solido
    public Rectangle solidArea;
    public boolean collisionOn=false;
}
