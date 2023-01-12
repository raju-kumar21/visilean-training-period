package com.imageupload.springboot.restapi.imageuploadrestapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imageupload.springboot.restapi.imageuploadrestapi.entity.ImageData;

@Repository
public interface StorageRepository extends CrudRepository<ImageData,Long> {
   
    Optional<ImageData> findByName(String fileName);
}
