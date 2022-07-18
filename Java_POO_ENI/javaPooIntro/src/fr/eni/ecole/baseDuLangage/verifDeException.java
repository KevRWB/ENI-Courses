package fr.eni.ecole.baseDuLangage;

public class verifDeException {

	//MAIN PROGRAM
	public static void main(String[] args) {
		
		int faces = 1;
		
		try {
			verifNbFaces(faces);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//  METHODS
	private static void verifNbFaces(int nbFaces) throws Exception {
		if (nbFaces <= 1)
				throw new Exception("Un dé doit avoir au moins deux faces");
	}

}
