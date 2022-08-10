package fr.eni.papeterie.ihm;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bo.Article;

public class EcranCatalogue extends JFrame {

	private JScrollPane scrollPane;
	
	private JTable tableCatalogue;
	
	private CatalogueTableModel model;
	
	public EcranCatalogue() {
		setSize(600, 400);
		setLocation(300, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(getScrollPane());
	}

	public JScrollPane getScrollPane() {
		if(scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableCatalogue());
		}
		return scrollPane;
	}
	
	public JTable getTableCatalogue() {
		if(tableCatalogue == null) {
			try {
				model = new CatalogueTableModel();
				tableCatalogue = new JTable(model);
				tableCatalogue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableCatalogue.setRowHeight(30);
				tableCatalogue.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(e.getValueIsAdjusting()) {
							int indexLigneSelectionnee = tableCatalogue.getSelectedRow();
							Article articleSelectionne = model.getValueAt(indexLigneSelectionnee);
							System.out.println(articleSelectionne);
						}
					}
				});
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		return tableCatalogue;
	}

	
	
	
}
