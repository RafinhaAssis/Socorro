
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{
    public OBJ_Door(){
        name="Door";
        
        
        //Carregar a imagem:
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/portal.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
