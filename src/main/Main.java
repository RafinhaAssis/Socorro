
package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[]args){
        //CRIA A JANELA
        JFrame window=new JFrame();
        
        //uSAMOS PARA FEXAR A JANELA CORRETAMENTE.
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Para a janela não possa ser redimensionalizada
        window.setResizable(false);
        //Nome do jogo:
        window.setTitle("Rafinha's Adventure");
        
        //Estamos chamand as definicoes da outra classe
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
        
        //Modo que a janela sera exibida, se não definirmos ela ira para o centro da tela.
        window.setLocationRelativeTo(null);
        //Para que possamos ver a janela:
        window.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
        
    }
}
