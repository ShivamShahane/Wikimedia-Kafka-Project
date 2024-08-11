package com.kafka.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafka.consumer.entity.WikimediaData;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
	
	

}
