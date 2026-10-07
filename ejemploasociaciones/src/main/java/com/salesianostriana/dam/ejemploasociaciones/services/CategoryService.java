package com.salesianostriana.dam.ejemploasociaciones.services;

import com.salesianostriana.dam.ejemploasociaciones.repositories.CategoryRepository;
import com.salesianostriana.dam.ejemploasociaciones.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public <List> getAllCategories(){
        List<Category> result = categoryRepository.findAll();
        if(result.isEmpty()){

            throw new RuntimeException("No se puede ver la lista");

        }

    }


}
