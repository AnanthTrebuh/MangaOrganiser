/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangaorganiser.model;

import java.awt.AWTException;
import mangaorganiser.Rob;

/**
 *
 * @author Nathan Hubert
 */
public class Menu {
    private Rob robot;
    
    public Menu() throws AWTException{
        robot = new Rob();
    }
    
    public void quit(){
        System.out.println("Quit");
        System.exit( 0 );
    }
    
    public void launch(int chapB, int chapE, boolean rename){
        robot.launch(chapB, chapE, rename);
    }
}
