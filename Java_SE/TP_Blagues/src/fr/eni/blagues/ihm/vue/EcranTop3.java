package fr.eni.blagues.ihm.vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.ihm.controller.BlagueController;
import fr.eni.blagues.ihm.controller.BlagueController.BlagueControllerListener;

public class EcranTop3  extends JFrame implements BlagueControllerListener {

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	
	private JTable tableTop3;
	
	private EcranTop3Model model;
	
	private BlagueController blagueController = BlagueController.getInstance();
	
	public EcranTop3() throws BLLException {
		setSize(600, 400);
		setLocation(900, 50);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		setContentPane(getScrollPane());
		blagueController.addListener(this);
		
	}	
	public JScrollPane getScrollPane() throws BLLException {
		if(scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableModel());
		}
		return scrollPane;
	}
	
	public JTable getTableModel() throws BLLException {
		if(tableTop3 == null) {
			model = new EcranTop3Model();
			tableTop3 = new JTable(model);
			tableTop3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableTop3.setRowHeight(30); 
	
			//s'il y a des données dans la JTable
			if(model.getRowCount() > 0) {
				//sélectionne la ligne 0 de la JTable
				tableTop3.setRowSelectionInterval(0, 0);
			}
			//Mouse listener
			tableTop3.addMouseListener(new MouseAdapter() {
				  public void mouseClicked (MouseEvent event) {
					  int indexLigneSelectionnee = tableTop3.getSelectedRow();
						Blague blagueSelectionne = model.getValueAt(indexLigneSelectionnee);
						blagueController.setBlagueActive(blagueSelectionne);
						System.out.println("Coucou "+blagueSelectionne);
						
						blagueController.preventOnTableClick();
				  }
			});
				    
//			
//			tableTop3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//				
//				@Override
//				public void valueChanged(ListSelectionEvent e) {
//					if(e.getValueIsAdjusting()) {
//						int indexLigneSelectionnee = tableTop3.getSelectedRow();
//						Blague blagueSelectionne = model.getValueAt(indexLigneSelectionnee);
//						blagueController.setBlagueActive(blagueSelectionne);
//						System.out.println("Coucou "+blagueSelectionne);
//						
//						blagueController.preventOnTableClick();
//					}
//				}
//			});
		}
		return tableTop3;
	}
	@Override
	public void printBlagueActive() {
	
	}
	@Override
	public void updateData() {
		model.updateData();	
	}

}


