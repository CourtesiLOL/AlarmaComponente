/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package relojconalarma;

/**
 *
 * @author javier
 */
public class alarmaMessage extends javax.swing.JDialog {

    /**
     * Creates new form alarmaMessage
     */
    public alarmaMessage(java.awt.Frame parent, boolean modal,String message) {
        super(parent, modal);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        
        this.message.setText(message);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        message.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("Texto ejemplo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
