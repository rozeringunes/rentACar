package com.turkcell.rentACar1.adapter;

import com.turkcell.rentACar1.business.abstracts.FindeksScoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindeksScoreAdapter implements FindeksScoreService {
    @Override
    public int getScoreForIndividual(String identityNumber) {
        return(int)Math.floor(Math.random()*1901);
    }

    @Override
    public int getScoreForCorporate(String taxNo) {
        return(int)Math.floor(Math.random()*1901);
    }
}
