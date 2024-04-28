/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package relojconalarma;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author javier
 */
public class setAlarma extends javax.swing.JDialog {
    private RelojConAlarma padre;

    public setAlarma(java.awt.Frame parent, boolean modal, RelojConAlarma alarmaPadre) {
        super(parent, modal);
        this.padre = alarmaPadre;
        setLocationRelativeTo(null);
        initComponents();
        setEvents();

        LocalTime tiempo = LocalTime.now();
        
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) horaSelector.getEditor();
        editor.getTextField().setEditable(false);
        
        editor = (JSpinner.DefaultEditor) minutoSelector.getEditor();
        editor.getTextField().setEditable(false);
        
        editor = (JSpinner.DefaultEditor) segundoSelector.getEditor();
        editor.getTextField().setEditable(false);
        
        horaSelector.setValue(tiempo.getHour());
        minutoSelector.setValue(tiempo.getMinute());
        segundoSelector.setValue(tiempo.getSecond());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setAlaramaBtn = new javax.swing.JButton();
        horaSelector = new javax.swing.JSpinner();
        minutoSelector = new javax.swing.JSpinner();
        segundoSelector = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        setAlaramaBtn.setText("SetAlarma");
        setAlaramaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setAlaramaBtnMouseClicked(evt);
            }
        });

        horaSelector.setFocusable(false);

        minutoSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minutoSelector.setEditor(new javax.swing.JSpinner.NumberEditor(minutoSelector, ""));
        minutoSelector.setFocusable(false);

        segundoSelector.setFocusable(false);

        jLabel1.setText("Añadir Alarma");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hora");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Minuto");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Segundo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setAlaramaBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(horaSelector)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minutoSelector))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(segundoSelector))
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(segundoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(setAlaramaBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setAlaramaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setAlaramaBtnMouseClicked
        
        int hora = Integer.parseInt(horaSelector.getValue().toString());
        int minuto = Integer.parseInt(minutoSelector.getValue().toString());
        int segundo = Integer.parseInt(segundoSelector.getValue().toString());
        
        
        
        System.out.println(LocalTime.of(hora,minuto,segundo).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        
        padre.setTiempoAlarma(LocalTime.of(hora,minuto,segundo));
        this.dispose();
    }//GEN-LAST:event_setAlaramaBtnMouseClicked

    private void setEvents() {

        horaSelector.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                if (horaSelector.getValue().toString().equals("24")) {
                    horaSelector.setValue(0);

                }
            }
        });

        minutoSelector.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                if (minutoSelector.getValue().toString().equals("60")) {
                    minutoSelector.setValue(0);
                    horaSelector.setValue(
                            horaSelector.getNextValue()
                    );
                }
            }
        });

        segundoSelector.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                if (segundoSelector.getValue().toString().equals("60")) {
                    segundoSelector.setValue(0);
                    minutoSelector.setValue(
                            minutoSelector.getNextValue()
                    );
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner horaSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner minutoSelector;
    private javax.swing.JSpinner segundoSelector;
    private javax.swing.JButton setAlaramaBtn;
    // End of variables declaration//GEN-END:variables
}
