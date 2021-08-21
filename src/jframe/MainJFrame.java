/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import controller.EditController;
import controller.FileController;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author Marlboro
 */
public class MainJFrame extends javax.swing.JFrame {
    FileController fileController;
    EditController editController;
    
    public MainJFrame() {
        initComponents();
        
        fileController = new FileController(txtArea);
        editController = new EditController(this,txtArea);
        
    }
    
    public JMenuItem getEditCopy() {
        return editCopy;
    }

    public void setEditCopy(JMenuItem editCopy) {
        this.editCopy = editCopy;
    }
    
    public JMenuItem getEditCut() {
        return editCut;
    }

    public void setEditCut(JMenuItem editCut) {
        this.editCut = editCut;
    }
    
    public JMenuItem getFind() {
        return find;
    }

    public void setFind(JMenuItem find) {
        this.find = find;
    }

    public JMenuItem getReplace() {
        return replace;
    }

    public void setReplace(JMenuItem replace) {
        this.replace = replace;
    }
    
    public JMenuItem getEditRedo() {
        return editRedo;
    }

    public void setEditRedo(JMenuItem editRedo) {
        this.editRedo = editRedo;
    }

    public JMenuItem getEditUndo() {
        return editUndo;
    }

    public void setEditUndo(JMenuItem editUndo) {
        this.editUndo = editUndo;
    }
    
    public JMenuItem getEditPaste() {
        return editPaste;
    }

    public void setEditPaste(JMenuItem editPaste) {
        this.editPaste = editPaste;
    }
    
    public JTextArea getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileNew = new javax.swing.JMenuItem();
        fileOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fileSave = new javax.swing.JMenuItem();
        fileSaveAs = new javax.swing.JMenuItem();
        fileExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        editUndo = new javax.swing.JMenuItem();
        editRedo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        editCut = new javax.swing.JMenuItem();
        editCopy = new javax.swing.JMenuItem();
        editPaste = new javax.swing.JMenuItem();
        editSelectAll = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        find = new javax.swing.JMenuItem();
        replace = new javax.swing.JMenuItem();
        editChangeFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAreaCaretUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(txtArea);

        menuFile.setText("File");

        fileNew.setText("New");
        fileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNewActionPerformed(evt);
            }
        });
        menuFile.add(fileNew);

        fileOpen.setText("Open");
        fileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenActionPerformed(evt);
            }
        });
        menuFile.add(fileOpen);
        menuFile.add(jSeparator1);

        fileSave.setText("Save");
        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveActionPerformed(evt);
            }
        });
        menuFile.add(fileSave);

        fileSaveAs.setText("Save As");
        fileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(fileSaveAs);

        fileExit.setText("Exit ");
        fileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });
        menuFile.add(fileExit);

        menuBar.add(menuFile);

        menuEdit.setText("Edit");

        editUndo.setText("Undo");
        editUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUndoActionPerformed(evt);
            }
        });
        menuEdit.add(editUndo);

        editRedo.setText("Redo");
        editRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRedoActionPerformed(evt);
            }
        });
        menuEdit.add(editRedo);
        menuEdit.add(jSeparator2);

        editCut.setText("Cut");
        editCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCutActionPerformed(evt);
            }
        });
        menuEdit.add(editCut);

        editCopy.setText("Copy");
        editCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCopyActionPerformed(evt);
            }
        });
        menuEdit.add(editCopy);

        editPaste.setText("Paste");
        editPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasteActionPerformed(evt);
            }
        });
        menuEdit.add(editPaste);

        editSelectAll.setText("SelectAll");
        editSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectAllActionPerformed(evt);
            }
        });
        menuEdit.add(editSelectAll);
        menuEdit.add(jSeparator3);

        find.setText("Find");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        menuEdit.add(find);

        replace.setText("Replace");
        replace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceActionPerformed(evt);
            }
        });
        menuEdit.add(replace);

        editChangeFont.setText("Change font");
        editChangeFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editChangeFontActionPerformed(evt);
            }
        });
        menuEdit.add(editChangeFont);

        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNewActionPerformed
        fileController.newFile(this);
    }//GEN-LAST:event_fileNewActionPerformed

    private void fileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenActionPerformed
        fileController.openFile();
    }//GEN-LAST:event_fileOpenActionPerformed

    private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
        fileController.saveFile();
    }//GEN-LAST:event_fileSaveActionPerformed

    private void fileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAsActionPerformed
        fileController.saveAsFile(this);
    }//GEN-LAST:event_fileSaveAsActionPerformed

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileExitActionPerformed
        fileController.exitNote(this);
    }//GEN-LAST:event_fileExitActionPerformed

    private void editUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUndoActionPerformed
        editController.undo();
    }//GEN-LAST:event_editUndoActionPerformed

    private void editRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRedoActionPerformed
        editController.redo();
    }//GEN-LAST:event_editRedoActionPerformed

    private void txtAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAreaCaretUpdate
        editController.caretUpdate();
    }//GEN-LAST:event_txtAreaCaretUpdate

    private void editCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCutActionPerformed
        editController.actions("cut");
    }//GEN-LAST:event_editCutActionPerformed

    private void editCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCopyActionPerformed
        editController.actions("copy");
    }//GEN-LAST:event_editCopyActionPerformed

    private void editPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasteActionPerformed
        editController.actions("paste");
    }//GEN-LAST:event_editPasteActionPerformed

    private void editSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectAllActionPerformed
        editController.actions("selectAll");
    }//GEN-LAST:event_editSelectAllActionPerformed

    private void editChangeFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editChangeFontActionPerformed
        editController.onChangeFont();
    }//GEN-LAST:event_editChangeFontActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        editController.onFind();
    }//GEN-LAST:event_findActionPerformed

    private void replaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceActionPerformed
        editController.onReplace();
    }//GEN-LAST:event_replaceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editChangeFont;
    private javax.swing.JMenuItem editCopy;
    private javax.swing.JMenuItem editCut;
    private javax.swing.JMenuItem editPaste;
    private javax.swing.JMenuItem editRedo;
    private javax.swing.JMenuItem editSelectAll;
    private javax.swing.JMenuItem editUndo;
    public javax.swing.JMenuItem fileExit;
    private javax.swing.JMenuItem fileNew;
    public javax.swing.JMenuItem fileOpen;
    private javax.swing.JMenuItem fileSave;
    private javax.swing.JMenuItem fileSaveAs;
    private javax.swing.JMenuItem find;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem replace;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
