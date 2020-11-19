package com.marcelohidalgo.springbootmicroserviceforexservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelohidalgo.springbootmicroserviceforexservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

}
