/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import jframe.MainJFrame;

/**
 *
 * @author Marlboro
 */
public class FileController {
    private final JTextArea txtArea;
    private File currentFile;
    private boolean isSaved = false;
    private String fileContent = "";
    
    public FileController(JTextArea textArea) {
        this.txtArea = textArea;
    }
    
    //check save file
    private boolean checkSave(MainJFrame mainFrame) {
        String message = "<html><div style = 'color:blue'>Do you want to save the changes to file </div><html>";
        
        isSaved = fileContent.equals(txtArea.getText());
        if (isSaved == false) {
            int x = JOptionPane.showConfirmDialog(mainFrame, message, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                if (currentFile == null) {
                    saveAsToFile(mainFrame);
                } else {
                    writeTextAreaToFile(mainFrame);
                }
            }
            // user click close when x == -1 
            if (x == JOptionPane.CANCEL_OPTION || x == -1) {
                return true;
            }
        }
        return false;
    }
     
    
    public void newFile(MainJFrame mainFrame) {
        if (checkSave(mainFrame)) { //if the file has not been saved
            return;
        }
        txtArea.setText("");
    }
    
    // setup file chooser
    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();  //dialog chooser
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //set default directory
        
//        fileChooser.setAcceptAllFileFilterUsed(false); //dont acp all type file
        FileNameExtensionFilter filterJava = new FileNameExtensionFilter("Java Source File(*.java)", "java"); //file extensions filter
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text Files(*.txt)", "txt");
        fileChooser.addChoosableFileFilter(filterJava);
        fileChooser.addChoosableFileFilter(filterTxt);
        
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {  //for when choose ok or cancel
            File selectedFile = fileChooser.getSelectedFile();
            currentFile = selectedFile;
            
            try {
                fileContent = "";
                BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                String line = "";
                while ((line = br.readLine()) != null) {
                    fileContent += line + '\n';
                }
                
                txtArea.setText(fileContent);   //read content file in txtArea
                
            } catch (FileNotFoundException ex) { //cant find file
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    // save file
    public void saveFile() {
        try {
            if (currentFile != null && currentFile.exists()) {  //check current file 
                String txtAreaContent = txtArea.getText();
                FileOutputStream fos = new FileOutputStream(currentFile);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                bw.write(txtAreaContent);
                bw.close();
                
                fileContent = txtAreaContent;
                isSaved = true;
            }
        }catch(IOException ex) {
            System.out.println(ex);
        }
    }
    
    // exit file
    public void exitNote(MainJFrame mainFrame) {
        if (checkSave(mainFrame)) { //if the file has not been saved
            return;
        }
        System.exit(0);
    }
    
    
    //save as to file
    private void saveAsToFile(MainJFrame mainFrame) {
        File checkFile = null;
        while (true) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(mainFrame);
            
            checkFile = fileChooser.getSelectedFile();
            
            if (checkFile == null || !checkFile.exists()) {
                break;
            }
            int option = JOptionPane.showConfirmDialog(mainFrame, "Do you want to replace it?", "Save As", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                break;
            }
        }
        
        if(checkFile != null) {
            currentFile = checkFile;
            fileContent = "";
            writeTextAreaToFile(mainFrame);
        }
    }
    
    //save as file
    public void saveAsFile(MainJFrame mainFrame) {
        if (checkSave(mainFrame)) {
            return;
        }
        saveAsToFile(mainFrame);
    }
    
    //write text area to file
    private void writeTextAreaToFile(MainJFrame mainFrame) {
        FileWriter fw = null;
        try {
            if (currentFile == null) {
                saveAsToFile(mainFrame);
                return;
            }
            fw = new FileWriter(currentFile);
            fw.write(txtArea.getText());
            fileContent = txtArea.getText();
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
}
