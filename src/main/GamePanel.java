package main;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

//Vai estender as funcionalidades do Panel para a classe principal.Aqui é onde daremos o estilo.
public class GamePanel extends JPanel implements Runnable{
    
    //Configuracoes de Tela:
    
    //(1) Tamanho que os elementos vão ter!
    final int originalTileSize=16;//16 px por 16px
    
    //(2) Redirecionamento, ou seja os templates serao feitos em 16px mais na tela ele sera aumentado.
    final int scale=3;
    //Tamanho real do bloco, sem ser o personagem:
    public final int tileSize= originalTileSize* scale;//48x48pixels
    
    //(3) Tamanho total da tela, e de quantos azuleijos serao feitos.Sera uma matriz de 16 por 12.
    public final int maxScreenCol=16;
    public int maxScreenRow=12;
    
    //(4) Tamanho total da tela:
    public final int screenWidth= tileSize*maxScreenCol;//768 pixels
    public final int screenHeight = tileSize * maxScreenRow;//576 pixels
    
    //Mundo completo/parametros
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth= tileSize*maxWorldCol;
    public final int worldHeight= tileSize*maxWorldRow;
    
    
    
    //FPS
    int FPS = 60;
    
    public TileManager tileM= new TileManager(this);
    
    //Instancia a classe para ver a tecla pressionada
    KeyHandler keyH= new KeyHandler();
    
    //Parte Especial: Tempo de jogo, fps e movimento de personagens.
    Thread gameThread;
    
    //Colisao
    public CollisionChecker cChecker = new CollisionChecker(this);
    
    //Instanciar o objeto
    public AssetSetter aSetter= new AssetSetter(this);
    
    public Player player= new Player(this, keyH);
    
    
    //Object:
    public SuperObject obj[]= new SuperObject[10];
    
    
    //(5) Construtor do painel
    
    public GamePanel(){
        //Como definimos o tamanho acima, aqui chamaremos para mostrar.
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        //cor de fundo.
        this.setBackground(Color.black);
        //para desenhar a tela de melhor renderizacao:
        this.setDoubleBuffered(true);
        //Reconhecimento de tecla.
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    //chamar os objetos:
    public void setupGame(){
        aSetter.setObject();
    }
    
    //metodo Iniciador do jogo
    public void startGameThread(){
        //instancia o contador!
        gameThread= new Thread(this);
        //para iniciar o game:
        gameThread.start();
    }
    
    
    public void run(){//<-Esse metodo funciona para fazer o loop do jogo
        double drawInterval = 1000000000/FPS;
        double delta=0;
        long lastTime = System.nanoTime();
        long currentTime;
        //temporizador
        long timer=0;
        int drawCount=0;
        
        while(gameThread != null){
            //Fazendo o FPS, utilizando o horario
            currentTime=System.nanoTime();
            delta +=(currentTime - lastTime)/drawInterval;
            timer+=(currentTime-lastTime);
            lastTime=currentTime;
            
            if(delta >=1){
            
            //Atualizacão do personagem
            update();
            //Desenhar o personagem atualizado
            repaint();
            delta--;
            drawCount++;
            
            }
            if(timer >=1000000000){
                drawCount=0;
                timer=0;
            }
           
        }
        
    }
    
    public void update(){//<-Metodo que atuaiza a posicao
        player.update();
        
    }
    
    
    //Esse é o metodo padrao do java pra desenhar no JPanel:
     public void paintComponent(Graphics g){//<-Metodo que desenha o personagem
        
        super.paintComponent(g);//<-Indica a classe pai do metodo
        Graphics2D g2 =(Graphics2D)g;
        
        tileM.draw(g2);
        
        //Desenhar o objeto
        for(int i=0; i<obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        
        player.draw(g2);
        //Apaga o retangulo para preservar a meoria
        g2.dispose();
     
    }
    
    
    
}
