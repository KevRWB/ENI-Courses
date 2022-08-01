package fr.eni.papeterie.bo;

public abstract class Article {
	private int idArticle;
	private String reference;
	String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;
	//Constructors
	
	public Article() {
		super();
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Article(String reference, String marque, String designation, float prixUnitaire, int qteStock) {
		super();
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	public Article(int idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock) {
		super();
		this.idArticle = idArticle;
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	//getteres setters
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [idArticle=");
		builder.append(idArticle);
		builder.append(", reference=");
		builder.append(reference);
		builder.append(", marque=");
		builder.append(marque);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", prixUnitaire=");
		builder.append(prixUnitaire);
		builder.append(", qteStock=");
		builder.append(qteStock);
		builder.append("]");
		return builder.toString();
	}
	
	//tostring
	
	
	
	
	
	
}
