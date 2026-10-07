package com.salesianostriana.dam.ejemploasociaciones.repositories;

import com.salesianostriana.dam.ejemploasociaciones.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
