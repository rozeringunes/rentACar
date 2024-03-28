package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.BrandMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentACar1.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository brandRepository;

    public void brandShouldBeExist(Optional<Brand> brand) {
        if (brand.isEmpty()) {
            throw new BusinessException(BrandMessages.brandNotFound);
        }
    }

    public void brandIdShouldBeExist(int brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if (brand.isEmpty()) {
            throw new BusinessException(BrandMessages.brandNotFound);
        }
    }

    public void brandNameCanNotBeDuplicatedWhenInserted(String name) {
        Optional<Brand> foundOptionalBrand = brandRepository.findByNameIgnoreCase(name.trim());
        if (foundOptionalBrand.isPresent()) {
            throw new BusinessException(BrandMessages.brandAlreadyExists);
        }
    }

    public void brandNameCanNotBeDuplicatedWhenUpdated(int id, String name) {
        boolean exists = brandRepository.existsByNameIgnoreCaseAndIdIsNot(name.trim(), id);
        if (exists) {
            throw new BusinessException(BrandMessages.brandAlreadyExists);
        }
    }
}