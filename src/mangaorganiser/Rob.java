/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangaorganiser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 *
 * @author nathan
 */
public class Rob extends Robot{
    private static int BEGIN = 0x24;
    private static int DELAY = 1000;
    
    public Rob() throws AWTException{
        super();
    }

    public void keyType(int key) {
        super.keyPress(key);
        super.keyRelease(key);
    }
    
    public void keysType(int key1, int key2){
        super.keyPress(key1);
        super.keyPress(key2);
        super.keyRelease(key1);
        super.keyRelease(key2);
    }

    public void mouseClick(int button) {
        super.mousePress(button);
        super.mouseRelease(button);
    }

    
    public void launch(int chapB, int chapE, boolean rename){
        super.mouseMove(1200, 150);
        mouseClick(MouseEvent.BUTTON1_DOWN_MASK);
        super.delay(DELAY);
        action(chapB, rename);
        int nbChap = chapE-chapB;
        chapB++;
        for(int i = 1; i <= nbChap; i++){
            for(int j = 0; j < i; j++){
                keyType(KeyEvent.VK_RIGHT);
            }
            action(chapB, rename);
            chapB++;
        }
    }
    
    private void action(int chapB, boolean rename){
        keyType(KeyEvent.VK_ENTER);
        super.delay(DELAY);
        keysType(KeyEvent.VK_CONTROL, KeyEvent.VK_A); 
        if(rename)rename(chapB);
        keysType(KeyEvent.VK_CONTROL, KeyEvent.VK_X);
        keyType(KeyEvent.VK_BACK_SPACE);
        super.delay(DELAY);
        keysType(KeyEvent.VK_CONTROL, KeyEvent.VK_V);
        super.delay(DELAY);
        keyType(BEGIN);
    }
    
    
    
    public void rename(int chap){
        keyType(KeyEvent.VK_F2);
        separateNumber(chap);
        keyType(KeyEvent.VK_ENTER);
        super.delay(DELAY);
    }
    
    public void separateNumber(int number){
        LinkedList<Integer> stack = new LinkedList<>();
        while(number > 0){
            stack.push(number % 10);
            number /= 10;
        }
        while ((!stack.isEmpty())){
            numberToKeyevent(stack.pop());
        }                
    }
    public void numberToKeyevent(int n){
        switch(n){
            case 0: keyType(KeyEvent.VK_NUMPAD0);break;
            case 1: keyType(KeyEvent.VK_NUMPAD1);break;
            case 2: keyType(KeyEvent.VK_NUMPAD2);break;
            case 3: keyType(KeyEvent.VK_NUMPAD3);break;
            case 4: keyType(KeyEvent.VK_NUMPAD4);break;
            case 5: keyType(KeyEvent.VK_NUMPAD5);break;
            case 6: keyType(KeyEvent.VK_NUMPAD6);break;
            case 7: keyType(KeyEvent.VK_NUMPAD7);break;
            case 8: keyType(KeyEvent.VK_NUMPAD8);break;
            case 9: keyType(KeyEvent.VK_NUMPAD9);break;
            default : break;
        }
    }
    
    
}
