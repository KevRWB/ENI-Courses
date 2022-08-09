package fr.eni.papeterie.bo;

public class Ligne {

	protected int qte;
	
	private Article article;

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	public float getPrix() {
		return this.article.getPrixUnitaire();
	}

	public Ligne(Article article, int qte) {
		this.article = article;
		this.qte = qte;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ligne [qte=");
		builder.append(qte);
		builder.append(", prix=");
		builder.append(getPrix());
		builder.append(", article=");
		builder.append(article);		
		builder.append("]");
		return builder.toString();
	}

	
}
