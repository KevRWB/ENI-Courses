package fr.eni.papeterie.ihm;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bo.Article;

public class EcranCatalogue extends JFrame implements IPanelBoutonsObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	
	private JTable tableCatalogue;
	
	private CatalogueTableModel model;
	
	public EcranCatalogue() {
		setSize(600, 400);
		setLocation(300, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(getScrollPane());
		
		//ajoute l'écran EcranCatalogue comme étant un observer du PanelBoutons
		PanelBoutons.getInstance().addPanelBoutonObserver(this);
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
							try {
								CatalogueController.getInstance().setArticleSelectionne(articleSelectionne);
							} catch (BLLException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
				
				//s'il y a des données dans la JTable
				if(model.getRowCount() > 0) {
					//sélectionne la ligne 0 de la JTable
					tableCatalogue.setRowSelectionInterval(0, 0);
				}
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		return tableCatalogue;
	}

	@Override
	public void precedent() {
		int position = CatalogueController.getInstance().getPosition();
		tableCatalogue.setRowSelectionInterval(position, position);
	}

	@Override
	public void suivant() {
		int position = CatalogueController.getInstance().getPosition();
		tableCatalogue.setRowSelectionInterval(position, position);
	}

	@Override
	public void nouveau() {	}

	@Override
	public void enregistrer() {
		try {
			model.updateData();
			int position = CatalogueController.getInstance().getPosition();
			tableCatalogue.setRowSelectionInterval(position, position);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer() {
		try {
			model.updateData();
			int position = CatalogueController.getInstance().getPosition();
			tableCatalogue.setRowSelectionInterval(position, position);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
