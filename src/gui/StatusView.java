package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public final class StatusView
    extends JPanel {

  public static final long serialVersionUID = 1L;
  JLabel statusLabel;
  JLabel jl;
  String status;
  Font errorFont;

  public static final StatusView instance = new StatusView();

  private StatusView() {
	  status = "Status: ";
	  jl = new JLabel(status);
	  statusLabel = new JLabel();
	  this.setBorder(new BevelBorder(BevelBorder.LOWERED));
	  this.setLayout(new FlowLayout());
	  this.add(jl);
	  this.add(statusLabel);
  }
  
  public void setStatus(String text) {
	  statusLabel.setForeground(Color.BLACK);
	  statusLabel.setText(text);
  }
  
  public void errorStatus(String text) {
	  statusLabel.setForeground(Color.RED);
	  statusLabel.setText(text);
  }
  
  public void clearStatus() {
	  this.setStatus("");
  }

}
