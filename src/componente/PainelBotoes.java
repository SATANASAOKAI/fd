package componente;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;

public class PainelBotoes extends javax.swing.JPanel {

    private List<MeuCampo> campos = new ArrayList<MeuCampo>();

    public PainelBotoes() {
        initComponents();
    }

    public List<MeuCampo> getCampos() {
        if (campos.isEmpty()) {
            JInternalFrame janela = (JInternalFrame) getFocusCycleRootAncestor();
            for (Component c : janela.getContentPane().getComponents()) {
                if (c instanceof MeuCampo) {
                    campos.add((MeuCampo) c);
                }
            }
        }
        return campos;
    }

    public void habilitarCampos(boolean status) {
        for (MeuCampo c : getCampos()) {
            c.setEnabled(status);
        }
    }

    public void limparCampos() {
        for (MeuCampo c : getCampos()) {
            c.setText("");
        }
    }

    public void habilarBotoes(boolean status) {
        btInserir.setEnabled(status);
        btConsultar.setEnabled(status);
        btConfirmar.setEnabled(!status);
        btCancelar.setEnabled(!status);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btConsultar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        btConsultar.setText("Consultar");
        btConsultar.setPreferredSize(new java.awt.Dimension(80, 25));
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        btInserir.setText("Inserir");
        btInserir.setPreferredSize(new java.awt.Dimension(80, 25));
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.setPreferredSize(new java.awt.Dimension(80, 25));

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.setPreferredSize(new java.awt.Dimension(80, 25));

        btConfirmar.setText("Confirmar");
        btConfirmar.setEnabled(false);
        btConfirmar.setPreferredSize(new java.awt.Dimension(80, 25));

        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.setPreferredSize(new java.awt.Dimension(80, 25));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btConsultar.getAccessibleContext().setAccessibleDescription("");
        btConsultar.getAccessibleContext().setAccessibleParent(btAlterar);
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        // TODO add your handling code here:
        limparCampos();
        habilitarCampos(true);
        habilarBotoes(false);
    }//GEN-LAST:event_btInserirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        limparCampos();
        habilitarCampos(false);
        habilarBotoes(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    public void btConsultarActionPerformed2(java.awt.event.ActionEvent evt){
        
    }
    
    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        try {
           Class c = Class.forName("telas."+getFocusCycleRootAncestor().getClass().getSimpleName()+"Consulta");
           c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    public javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    // End of variables declaration//GEN-END:variables
}
