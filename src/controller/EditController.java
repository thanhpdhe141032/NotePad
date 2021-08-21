/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;
import jframe.ChangeFontJFrame;
import jframe.FindJFrame;

import jframe.MainJFrame;
import jframe.ReplaceJFrame;

/**
 *
 * @author Marlboro
 */
public class EditController {
    private final JTextArea txtArea;
    private final UndoManager undoManager;
    private final MainJFrame mainFrame;
    private final ChangeFontJFrame changeFontForm;
    private final FindJFrame findJFrame;
    private final ReplaceJFrame replaceJFrame;
    
    public EditController(MainJFrame mainFrame, JTextArea textArea) {
        this.txtArea = textArea;
        this.mainFrame = mainFrame;
        this.changeFontForm = new ChangeFontJFrame();
        this.findJFrame = new FindJFrame();
        this.replaceJFrame = new ReplaceJFrame();
        
        
        undoManager = new UndoManager();
        txtArea.getDocument().addUndoableEditListener(undoManager);
        canEdit();
        canUndoRedo();
    }
    
    
    //set enabled and disabled
    public void caretUpdate() {
        String textCurrent = txtArea.getText();
        // can undo redo when user change text
        if (textCurrent.length() != 0) {
            mainFrame.getFind().setEnabled(true);
            mainFrame.getReplace().setEnabled(true);
        }
        // can show cut, copy
        if (txtArea.getSelectedText() != null) {
            mainFrame.getEditCut().setEnabled(true);
            mainFrame.getEditCopy().setEnabled(true);
        } else {
            mainFrame.getEditCut().setEnabled(false);
            mainFrame.getEditCopy().setEnabled(false);
        }
        
        if (undoManager.canUndo()) {
            mainFrame.getEditUndo().setEnabled(true);
        } else {
            mainFrame.getEditUndo().setEnabled(false);
        }
        if (undoManager.canRedo()) {
            mainFrame.getEditRedo().setEnabled(true);
        } else {
            mainFrame.getEditRedo().setEnabled(false);
        }
    }
    
    public void undo() {
        undoManager.undo();
    }
    
    public void redo() {
        undoManager.redo();
    }
    
    //action about copy, cut, paste and select all
    public void actions(String type) {
        switch(type) {
            case "copy":
                txtArea.copy();
                break;
            case "cut":
                txtArea.cut();
                break;
            case "paste":
                txtArea.paste();
                break;
            case "selectAll":
                txtArea.selectAll();
                break;
        }
    }
    
    private void canEdit() {
        // when open editor can't undo, redo
        mainFrame.getEditCopy().setEnabled(false);
        mainFrame.getEditCut().setEnabled(false);
        mainFrame.getFind().setEnabled(false);
        mainFrame.getReplace().setEnabled(false);
    }
    
    private void canUndoRedo() {
        // when new app, user can't undo redo
        mainFrame.getEditUndo().setEnabled(false);
        mainFrame.getEditRedo().setEnabled(false);
    }
    
    //find
    public void onFind(){
        findJFrame.setVisible(true);
        findJFrame.getBtnFind().setEnabled(false);

        FindController findController = new FindController();
        findController.checkEmptyFind(findJFrame);
        findController.find(mainFrame, findJFrame);
        findController.cancelFind(findJFrame);
    }
    
    //replace
    public void onReplace(){
        replaceJFrame.setVisible(true);
        replaceJFrame.getBtnReplace().setEnabled(false);
        replaceJFrame.getBtnReplaceAll().setEnabled(false);

        ReplaceController replaceController = new ReplaceController();
        replaceController.checkEmptyReplace(replaceJFrame);
        replaceController.replace(mainFrame, replaceJFrame);
        replaceController.replaceAll(mainFrame, replaceJFrame);
        replaceController.cancelReplace(replaceJFrame);
    }
    
    public void onChangeFont() {
        changeFontForm.setVisible(true);

        ChangeFontController changeFontController = new ChangeFontController();
        changeFontController.setupChangeFont(mainFrame, changeFontForm);
        changeFontController.setupChangeFontForm(changeFontForm);
        changeFontController.changeFont(changeFontForm);
        changeFontController.changeSize(changeFontForm);
        changeFontController.changeStyle(changeFontForm);
        changeFontController.clickButtonChangeFontForm(mainFrame, changeFontForm);
    }
}
