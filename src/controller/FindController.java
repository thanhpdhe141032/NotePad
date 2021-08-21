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
import javax.swing.text.BadLocationException;
import jframe.FindJFrame;
import jframe.MainJFrame;

/**
 *
 * @author Marlboro
 */
public class FindController {
    
    //find
    public void find(MainJFrame mainFrame, FindJFrame findJFrame) {
        findJFrame.getBtnFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtFind = findJFrame.getTxtFind().getText();
                int indexCurrent;
                int indexTextSearch = -1;   //index when user search anything. if have no then assign it's -1
                //find after
                if (findJFrame.getIsDown().isSelected()) {
                    // must choose to change
                    indexCurrent = mainFrame.getTxtArea().getSelectionEnd();
                    indexTextSearch = mainFrame.getTxtArea().getText().indexOf(txtFind, indexCurrent);
                } else {
                    try {
                        indexCurrent = mainFrame.getTxtArea().getSelectionStart();
                        String textCurrentCheck = mainFrame.getTxtArea().getText(0, indexCurrent);
                        indexTextSearch = textCurrentCheck.lastIndexOf(txtFind);
                    } catch (BadLocationException ex) {
                        System.out.println(ex);
                    }
                }
                // check text have or no
                if (indexTextSearch != -1) {
                    mainFrame.getTxtArea().setSelectionStart(indexTextSearch);
                    mainFrame.getTxtArea().setSelectionEnd(indexTextSearch + txtFind.length());
                } else {
                    JOptionPane.showMessageDialog(findJFrame, "Cannot find \"" + txtFind + "\"", "Cannot Find", 2);
                }
            }
        });
    }

    //cancel
    public void cancelFind(FindJFrame findJFrame) {
        findJFrame.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findJFrame.setVisible(false);
            }
        });
    }

    // check user not input
    public void checkEmptyFind(FindJFrame findJFrame) {
        findJFrame.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (findJFrame.getTxtFind().getText().trim().isEmpty()) {
                    findJFrame.getBtnFind().setEnabled(false);
                } else {
                    findJFrame.getBtnFind().setEnabled(true);
                }
            }
        });
    }
}
