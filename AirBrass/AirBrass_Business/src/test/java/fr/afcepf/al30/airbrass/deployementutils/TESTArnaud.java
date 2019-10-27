package fr.afcepf.al30.airbrass.deployementutils;

import fr.afcepf.al30.airbrass.business.api.IBusinessProduit;
import fr.afcepf.al30.airbrass.business.impl.BusinessProduit;
import fr.afcepf.al30.airbrass.exceptions.AirBrassException;

public class TESTArnaud {

	public static void main(String[] args) throws AirBrassException {
		
		IBusinessProduit prod = new BusinessProduit();
		System.out.println(prod.getVuesByProduit(1));

	}

}
