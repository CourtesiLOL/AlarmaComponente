/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relojconalarma;

import javax.swing.JFrame;

/**
 *
 * @author javier
 */
public class pruebas {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RelojConAlarma());
        frame.setVisible(true);
    }
}
