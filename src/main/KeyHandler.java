package main;

//Ele pegara os dados do teclado

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Recebe a tecla que foi pressionada
        int code = e.getKeyCode();
        //verifica se o código é igual
        if(code==KeyEvent.VK_W){
            upPressed=true;
        }
        if(code==KeyEvent.VK_S){
            downPressed=true;
        }
        if(code==KeyEvent.VK_A){
            leftPressed=true;
        }
        if(code==KeyEvent.VK_D){
            rightPressed=true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
      //Verifica se a tecla foi solta
        if(code==KeyEvent.VK_W){
            upPressed=false;
        }
        if(code==KeyEvent.VK_S){
            downPressed=false;
        }
        if(code==KeyEvent.VK_A){
            leftPressed=false;
        }
        if(code==KeyEvent.VK_D){
            rightPressed=false;
        }
    }
    
}
