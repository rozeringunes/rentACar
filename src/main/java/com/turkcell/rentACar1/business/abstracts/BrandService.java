package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentACar1.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentACar1.business.dtos.responses.brands.CreatedBrandResponse;
import com.turkcell.rentACar1.business.dtos.responses.brands.GetAllBrandsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.brands.GetBrandResponse;
import com.turkcell.rentACar1.business.dtos.responses.brands.UpdatedBrandResponse;

import java.util.List;

public interface  BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest );
    UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    List<GetAllBrandsListItemDto>getAll();
    GetBrandResponse get(int id);


}
