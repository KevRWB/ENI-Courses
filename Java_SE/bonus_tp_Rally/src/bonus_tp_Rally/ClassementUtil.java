package bonus_tp_Rally;

public class ClassementUtil {
	
	public static Resultat[] classerParTemps(Resultat[] resultats) {
		for (int i = 0; i < resultats.length - 1; i++) {
			if(resultats[i+1] == null) break;
			for (int j = i+1 ; j < resultats.length; j++) {
				if(resultats[i].getTemps().after(resultats[j].getTemps())  ) {
					Resultat temp = resultats[i];
					 resultats[i] =  resultats[j];
					 resultats[j] = temp;
				}
			}
		}	
		return resultats;
	}
	
	
	public static Classement[] classerParTemps(Classement[] classement) {
		
		for (int i = 0; i < classement.length - 1; i++) {
			if(classement[i+1] == null) break;
			for (int j = i+1 ; j < classement.length; j++) {
				if(classement[i].getCumulTemps().after(classement[j].getCumulTemps())  ) {
					Classement temp = classement[i];
					classement[i] =  classement[j];
					classement[j] = temp;
				}
			}
		}	
		return classement;
	}
	
	public static Resultat[] classerParEquipe(Resultat[] resultats) {
		
		for (int i = 0; i < resultats.length - 1; i++) {
			if(resultats[i+1] == null) break;
			for (int j = i+1 ; j < resultats.length; j++) {
				if(resultats[i].getEquipage().getDossard() > resultats[j].getEquipage().getDossard()) {
					Resultat temp = resultats[i];
					 resultats[i] =  resultats[j];
					 resultats[j] = temp;
				}
			}
		}
		return resultats;
	}	
	
}
