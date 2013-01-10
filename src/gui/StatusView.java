package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * A class for posting a status at the bottom of the spreadsheet
 * Returns errormessages  
 */

public final class StatusView
    extends JPanel {

 
  public static final long serialVersionUID = 1L;
  
  JLabel statusLabel;
  JLabel jl;
  String status;

  
  public static final StatusView instance = new StatusView();

  /**
   * StatusView() initiates the above variables
   * Two labels are used to make the output easier on the eye
   */
  private StatusView() {
	  FlowLayout layout = new FlowLayout();
	  layout.setAlignment(FlowLayout.LEFT);
	  status = "Status: ";
	  jl = new JLabel(status);
	  statusLabel = new JLabel();
	  this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	  this.setLayout(layout);
	  this.add(jl);
	  this.add(statusLabel);
  }
  
  /**
   * Sets the status
   * @param text Holds the message to be displayed
   * Color changing is used to make resetting the status easier
   */
  public void setStatus(String text) {
	  statusLabel.setForeground(Color.BLACK);
	  statusLabel.setText(text);
  }
  
  /**
   * Same as setStatus except for the color change
   * @param text Holds the message to be displayed
   */
  public void errorStatus(String text) {
	  statusLabel.setForeground(Color.RED);
	  statusLabel.setText(text);
  }
  
  /** Clears the status field */
  public void clearStatus() {
	  this.setStatus("");
  }

}
