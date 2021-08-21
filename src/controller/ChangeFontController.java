/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jframe.ChangeFontJFrame;
import jframe.MainJFrame;

/**
 *
 * @author Thanh Dang
 */
public class ChangeFontController {
      
    public void setupChangeFontForm(ChangeFontJFrame changeFontForm) {
//        changeFontForm.getJpnReview().setPreferredSize(new Dimension(150, 50));
        changeFontForm.setTitle("Font");
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        changeFontForm.getListFont().setListData(fonts);
        String styles[] = {"Regular", "Bold", "Italic", "Bold Italic"};
        changeFontForm.getListStyle().setListData(styles);
        String sizes[] = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "36", "40", "72", "80"};
        changeFontForm.getListSize().setListData(sizes);
    }

    //setup change font
    public void setupChangeFont(MainJFrame main, ChangeFontJFrame changeFontForm) {
        String fontCurrent = main.getTxtArea().getFont().getFamily();
        int styleCurrent = main.getTxtArea().getFont().getStyle();
        int sizeCurrent = main.getTxtArea().getFont().getSize();
        changeFontForm.getListFont().setSelectedValue(fontCurrent, true);
        changeFontForm.getListStyle().setSelectedIndex(styleCurrent);
        changeFontForm.getListSize().setSelectedValue(Integer.toString(sizeCurrent), true);
        changeFontForm.getTxtSize().setText(Integer.toString(sizeCurrent));
        changeFontForm.getTextFont().setText(fontCurrent);
        changeFontForm.getTextStyle().setText(changeFontForm.getListStyle().getSelectedValue());
    }

    //change font
    public void changeFont(ChangeFontJFrame changeFontForm) {
        changeFontForm.getListFont().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String fontChoose = changeFontForm.getListFont().getSelectedValue();
                int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                int sizeCurrent = changeFontForm.getTextReview().getFont().getSize();
                changeFontForm.getTextFont().setText(fontChoose);
                changeFontForm.getTextReview().setFont(new Font(fontChoose, styleCurrent, sizeCurrent));
            }
        });
    }
    
    //change style
    public void changeStyle(ChangeFontJFrame changeFontForm) {
        changeFontForm.getListStyle().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int styleChoose = changeFontForm.getListStyle().getSelectedIndex();
                String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                int sizeCurrent = changeFontForm.getTextReview().getFont().getSize();
                switch (styleChoose) {
                    case 0:
                        changeFontForm.getTextStyle().setText("Regular");
                        break;
                    case 1:
                        changeFontForm.getTextStyle().setText("Bold");
                        break;
                    case 2:
                        changeFontForm.getTextStyle().setText("Italic");
                        break;
                    case 3:
                        changeFontForm.getTextStyle().setText("Bold Italic");
                        break;
                }
                changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleChoose, sizeCurrent));
            }
        });
    }

    //change size
    public void changeSize(ChangeFontJFrame changeFontForm) {
        changeFontForm.getListSize().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String sizeChoose = changeFontForm.getListSize().getSelectedValue();
                String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                if (sizeChoose != null && !sizeChoose.isEmpty()
                    && fontCurrent != null && !fontCurrent.isEmpty())
                {
                    changeFontForm.getTextSize().setText(sizeChoose);
                    changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleCurrent, Integer.parseInt(sizeChoose)));   
                }
            }
        });
        changeFontForm.getTextSize().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String sizeChoose = changeFontForm.getTextSize().getText();
                if (sizeChoose != null && !sizeChoose.isEmpty()) {
                    String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                    int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                    changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleCurrent, Integer.parseInt(sizeChoose)));
                }
            }
        });
    }
    
    //ok or cancel
    public void clickButtonChangeFontForm(MainJFrame mainFrame, ChangeFontJFrame changeFontForm) {
        changeFontForm.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontCurrent = changeFontForm.getListFont().getSelectedValue();
                int styleCurrent = changeFontForm.getListStyle().getSelectedIndex();
                int sizeCurrent = Integer.parseInt(changeFontForm.getTextSize().getText());
                mainFrame.getTxtArea().setFont(new Font(fontCurrent, styleCurrent, sizeCurrent));
                changeFontForm.setVisible(false);
            }
        });
         changeFontForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFontForm.setVisible(false);
            }
        });
    }
}
