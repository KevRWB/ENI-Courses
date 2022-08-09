package fr.eni.papeterie.ihm;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;

public class CatalogueTableModel extends AbstractTableModel {

	private final static ImageIcon ICON_RAMETTE = new ImageIcon(CatalogueTableModel.class.getResource("images/ramette.gif"));
	private final static ImageIcon ICON_STYLO = new ImageIcon(CatalogueTableModel.class.getResource("images/pencil.gif"));
	
	private String[] columnNames = { "Type", "Référence", "Désignation", "Marque", "Stock", "Prix Unitaire" };

	private List<Article> data = new ArrayList<Article>();

	public CatalogueTableModel() throws BLLException {
		data = CatalogueController.getInstance().getCatalogue();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnIndex == 0 ? ImageIcon.class : String.class;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= 0 && rowIndex < data.size()) {
			Article a = data.get(rowIndex);
			switch (columnIndex) {
			case 0:
				//return (a instanceof Stylo) ? ICON_STYLO : ICON_RAMETTE;
				if(a instanceof Stylo) {
					return ICON_STYLO;
				} else {
					return ICON_RAMETTE;
				}
			case 1:
				return a.getReference();
			case 2:
				return a.getDesignation();
			case 3:
				return a.getMarque();
			case 4:
				return a.getQteStock();
			case 5:
				return String.format("%.2f €", a.getPrixUnitaire());
			}
		}
		return null;
	}

	public Article getValueAt(int indexLigneSelectionnee) {
		if(indexLigneSelectionnee >= 0 && indexLigneSelectionnee < data.size()) {
			return data.get(indexLigneSelectionnee);
		}
		return null;
	}

}
