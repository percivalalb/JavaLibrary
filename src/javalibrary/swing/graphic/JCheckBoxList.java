package javalibrary.swing.graphic;

import java.awt.Component;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class JCheckBoxList extends JList<JCheckBox> {
	
	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

	public JCheckBoxList() {
		this.setCellRenderer(new CellRenderer());
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = locationToIndex(e.getPoint());
				if(index != -1) {
					JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
					checkbox.setSelected(!checkbox.isSelected());
					addSelectionInterval(index, index);
					repaint();
				}
			}
		});
		
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}

	public JCheckBoxList(ListModel<JCheckBox> model){
		this();
		setModel(model);
	}

  	protected class CellRenderer implements ListCellRenderer<JCheckBox> {
	  
  		public Component getListCellRendererComponent(JList<? extends JCheckBox> list, JCheckBox value, int index, boolean isSelected, boolean cellHasFocus) {
		  	JCheckBox checkbox = value;

		  	//Drawing checkbox, change the appearance here
	      	checkbox.setBackground(isSelected ? getSelectionBackground() : getBackground());
	      	checkbox.setForeground(isSelected ? getSelectionForeground() : getForeground());
	      	checkbox.setEnabled(isEnabled());
	      	checkbox.setFont(getFont());
	      	checkbox.setFocusPainted(false);
	      	checkbox.setBorderPainted(true);
	      	checkbox.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
	      	return checkbox;
	  	}
  	}
}