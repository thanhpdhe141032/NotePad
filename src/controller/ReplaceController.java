/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import jframe.MainJFrame;
import jframe.ReplaceJFrame;

/**
 *
 * @author Marlboro
 */
public class ReplaceController {
    
    //replace
    public void replace(MainJFrame mainFrame, ReplaceJFrame replaceJFrame) {
        replaceJFrame.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textAreaCurrent = mainFrame.getTxtArea().getText();
                String textFind = replaceJFrame.getTxtFind().getText();
                String textReplace = replaceJFrame.getTxtReplace().getText();
                mainFrame.getTxtArea().setText(textAreaCurrent.replaceFirst(textFind, textReplace));
                int indexCurrent = mainFrame.getTxtArea().getText().lastIndexOf(textReplace) + textReplace.length();
                int indexTextSearch = -1;
                indexTextSearch = mainFrame.getTxtArea().getText().indexOf(textFind, indexCurrent);
                //check data have or no
                if (indexTextSearch != -1) {
                    mainFrame.getTxtArea().setSelectionStart(indexTextSearch);
                    mainFrame.getTxtArea().setSelectionEnd(indexTextSearch + textFind.length());
                } else {
                    JOptionPane.showMessageDialog(replaceJFrame, "Cannot find \"" + textFind + "\"", "Result", 2);
                }
            }
        });
    }

    // replace all
    public void replaceAll(MainJFrame mainFrame, ReplaceJFrame replaceJFrame) {
        replaceJFrame.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainFrame.getTxtArea().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(replaceJFrame, "No text field found!!!", "Error", 2);
                } else {
                    String textAreaCurrent = mainFrame.getTxtArea().getText();
                    String textFind = replaceJFrame.getTxtFind().getText();
                    String textReplace = replaceJFrame.getTxtReplace().getText();
                    mainFrame.getTxtArea().setText(textAreaCurrent.replaceAll(textFind, textReplace));
                }
            }
        });
    }

    // check empty replace 
    public void checkEmptyReplace(ReplaceJFrame replaceJFrame) {
        replaceJFrame.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (replaceJFrame.getTxtFind().getText().trim().isEmpty()) {
                    replaceJFrame.getBtnReplace().setEnabled(false);
                    replaceJFrame.getBtnReplaceAll().setEnabled(false);
                } else {
                    replaceJFrame.getBtnReplace().setEnabled(true);
                    replaceJFrame.getBtnReplaceAll().setEnabled(true);
                }
            }
        });
    }

    // cancel replace
    public void cancelReplace(ReplaceJFrame replaceJFrame) {
        replaceJFrame.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceJFrame.setVisible(false);
            }
        });
    }
}
