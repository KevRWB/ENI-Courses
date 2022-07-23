package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.GregorianCalendar;

public class Adresse {
private String mentionComp;
private int numero;
private String compNumero;
private String voie;
private int cp;
private String ville;
private LocalDate date = LocalDate.of(2022, 12, 24);
public Adresse(String mentionComp, int numero, String compNumero, String voie, int cp, String ville) {
	this.setMentionComp(mentionComp);
	this.setNumero(numero); 
	this.setCompNumero(compNumero);
	this.setVoie(voie);
	this.setCp(cp);
	this.setVille(ville);
}

public Adresse(int numero, String compNumero, String voie, int cp, String ville) {
	this(null,numero,compNumero,voie,cp,ville);
}

public String getMentionComp() {
	return mentionComp;
}
public void setMentionComp(String mentionComp) {
	this.mentionComp = mentionComp;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getCompNumero() {
	return compNumero;
}
public void setCompNumero(String compNumero) {
	this.compNumero = compNumero;
}
public String getVoie() {
	return voie;
}
public void setVoie(String voie) {
	this.voie = voie;
}
public int getCp() {
	return cp;
}
public void setCp(int cp) {
	this.cp = cp;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public void afficher() {
	System.out.println(this.toString());
	System.out.println(this.sbToString());
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	if(!(mentionComp==null))
	{
	builder.append(mentionComp);
	builder.append(String.format("%n"));
	}
	builder.append(numero);
	if(!(compNumero==null)) {
		builder.append(compNumero);
	}
	builder.append(" ");
	builder.append(voie);
	builder.append(String.format("%n"));
	builder.append(cp);
	builder.append(" ");
	builder.append(ville);
	return builder.toString();
}
public String sbToString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Hello voici la date du jour :");
	sb.append(String.format("%n"));
	DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	sb.append(date.format(formatDate)); 
	
	return sb.toString();
}

}


