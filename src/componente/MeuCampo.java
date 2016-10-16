/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author joao
 */
public class MeuCampo extends JTextField implements FocusListener{
    
    private boolean obrigatorio;
    
    public MeuCampo(){
        addFocusListener(this);
        setText("");
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(obrigatorio && "".equals(getText())){
            setBackground(Color.red);
        }else{
            setBackground(Color.white);
        }
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }
    
}
