package com.tony.javademo01.repository;

import com.tony.javademo01.entity.product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRespository  extends CrudRepository<product,Integer> {
}
