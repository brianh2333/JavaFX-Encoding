//Author: Brian Harms

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MainController implements Initializable{

    @FXML
    public TextArea encodedTextArea;

    @FXML
    public TextArea decodedTextArea;

    @FXML
    private ComboBox<String> comboBox;
    
    @FXML
    private ComboBox<String> shiftComboBox;

    @FXML
    private Button runButton;
    
    @FXML
    private Button clearBtn;
    
    private int shift;
    
    //First combo box choices.
    ObservableList<String> cipherList = FXCollections.observableArrayList(
    		"Caesar cipher",
    		"Binary to Text/Text to Binary");
    
    //Second combo box choices.
    ObservableList<String> shiftList = FXCollections.observableArrayList("0", "1", "2", "3", "4", "5",
    		"6", "7", "8", "9", "10", "11", "12", "13", "14","15", "16", "17", "18", "19", "20"
    		, "21", "22", "23", "24", "25", "26");
    
    public Ciphers ciphers = new Ciphers();

    @FXML
    void handleButtonClick(ActionEvent event) {
    	if (event.getSource() == runButton)
    	{
    		boolean encoding = true;
    		try {
        		if (encodedTextArea.getText().length() > 0) {
        			decodedTextArea.setText("");
        			encoding = false;
        		} else if (decodedTextArea.getText().length() > 0) {
        			encoding = true;
        			encodedTextArea.setText("");
        		}
    		} catch (Exception e) {
    			System.out.println("There was an error.");
    		}

    		System.out.println("Encoding: " + encoding);
    		
    		
        	if (comboBox.getValue().equals("Caesar cipher")) 
        	{
        		if (!encoding) {
        			System.out.println("Decoding");
        			//Decoding
                    char [] encodedText = encodedTextArea.getText().toCharArray();
                    char [] decodedText = new char[encodedText.length];
                    String s = "";
                    for (int i = 0; i < encodedText.length; i++) {
                    	decodedText[i] = ciphers.CaesarCipher(encodedText[i], shift, false);
                    	s += decodedText[i];
                    }
                    System.out.println(s);
                    decodedTextArea.setText(s);

            	}
        		else if (encoding){
        			System.out.println("Encoding");
                    char [] decodedText = decodedTextArea.getText().toCharArray();
                    char [] encodedText = new char[decodedText.length];
                    String s = "";
                    for (int i = 0; i < decodedText.length; i++) {
                    	encodedText[i] = ciphers.CaesarCipher(decodedText[i], shift, true);
                    	s += encodedText[i];
                    }
                    System.out.println(s);
                    encodedTextArea.setText(s);
                    
        		}
        	}
        	else if (comboBox.getValue().equals("Binary to Text/Text to Binary")) {
        		if (!encoding) 
        		{
        			try 
        			{
        				decodedTextArea.setText(ciphers.BinaryToText(encodedTextArea.getText()));
        			}
        			catch(Exception e) {
        				System.out.println("There was an error.");
        			}

        		}
        		else 
        		{
        			try 
        			{
        				encodedTextArea.setText(ciphers.TextToBinary(decodedTextArea.getText()));
        			}  
        		    catch(Exception e) {
        			    System.out.println("There was an error.");
        		    }
 
        	    }
    	    }
        	else
        		System.out.println("Choose a cipher!");
    	}
    	
    	else if (event.getSource() == clearBtn) {
            decodedTextArea.setText("");
            encodedTextArea.setText("");
    	}

    }

    //When combo box is interacted upon.
    @FXML
    void onComboBoxChanged(ActionEvent event) {
        if(event.getSource() == shiftComboBox) {
        	shift = Integer.parseInt(shiftComboBox.getValue());
        }
    }

    //When application is run.
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shift = 0;
		shiftComboBox.setItems(shiftList);
		comboBox.setItems(cipherList);
		
	}

}
