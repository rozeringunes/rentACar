package com.turkcell.rentACar1.business.abstracts;

public interface FindeksScoreService {
    int getScoreForIndividual(String identityNumber);
    int getScoreForCorporate (String taxNo);

}
