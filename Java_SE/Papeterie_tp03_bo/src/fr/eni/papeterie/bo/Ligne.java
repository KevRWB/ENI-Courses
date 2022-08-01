package fr.eni.papeterie.bo;

public class Ligne {
	private int qte;
	private Article article;
	private int countLignes = 0;
	
	public Ligne(Article article, int qte) {
		this.qte = qte;
		this.article = article;
		countLignes++;
	}
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ligne ");
		builder.append("[ ");
		builder.append(" article=");
		builder.append(article);
		builder.append(String.format("%n"));
		return builder.toString();
	}
	public int getCountLignes() {
		return countLignes;
	}
	public void setCountLignes(int countLignes) {
		this.countLignes = countLignes;
	}
	
	
	
	
	
}
