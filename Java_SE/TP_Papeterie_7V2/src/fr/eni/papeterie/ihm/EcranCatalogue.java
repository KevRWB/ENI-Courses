package fr.eni.papeterie.ihm;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.ihm.PanelBoutons.Listeners;

public class EcranCatalogue extends JFrame implements Listeners{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	
	private JTable tableCatalogue;
	
	private CatalogueTableModel model;
	
	private int indexRow = 0;
	private Article currentArticle;

		
	private EcranCatalogueClick ecranCatalogueClick = EcranCatalogueClick.getInstance();
	
	public EcranCatalogue() {
		PanelBoutons.getInstance().ajouterObservateur(this);
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
				tableCatalogue.setRowSelectionInterval(0, 0);
				//----------------
				tableCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
				    @Override
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	indexRow = tableCatalogue.getSelectedRow();
				    	currentArticle = model.getValueAt(indexRow);
				    	EcranCatalogueClick.getInstance().setCurrentArticle(currentArticle);
				    	System.out.println(currentArticle);
				    }
				});
				//-----------------
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

	@Override
	public void precedent() {
		if(indexRow == 0) {
		}else {
			indexRow--;
			tableCatalogue.setRowSelectionInterval(0, indexRow);
		}	
	}

	@Override
	public void suivant() {
		if(indexRow == model.getData().size() - 1) {
		}else {
			indexRow++;
			tableCatalogue.setRowSelectionInterval(0, indexRow);
		}
		
	}

	@Override
	public void nouveau() {		
	}
	@Override
	public void enregistrer() {
		model.fireTableDataChanged();
		tableCatalogue.setModel(model); 
		tableCatalogue.repaint();
	}
	@Override
	public void supprimer() {
		try {
			model = new CatalogueTableModel();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		tableCatalogue.setModel(model); 
		tableCatalogue.repaint();
	}
	
}
