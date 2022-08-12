package fr.eni.blagues.ihm.vue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.ihm.controller.BlagueController;

public class EcranTop3Model extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private BlagueController blagueController = BlagueController.getInstance();

	private String[] columnNames = { "ID", "Libellé", "note" };
	
	private List<Blague> data = new ArrayList<Blague>();
	
	public EcranTop3Model() throws BLLException {
		updateData();
	}
	
	public void updateData() {
		try {
			data = blagueController.getAllBlagues();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		fireTableDataChanged(); //préviens la JTable qui contient ce model que les donnés ont changé
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= 0 && rowIndex < data.size()) {
			Blague a = data.get(rowIndex);
			switch (columnIndex) {
		
			case 0:
				return a.getIdBlague();
			case 1:
				return a.getTxtBlague();
			case 2:
				return a.getNote();
		}
		
	}
		return null;
	}
	
	public Blague getValueAt(int indexLigneSelectionnee) {
		if(indexLigneSelectionnee >= 0 && indexLigneSelectionnee < data.size()) {
			return data.get(indexLigneSelectionnee);
		}
		return null;
	}



}
