package com.stockmonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stockmonitor.entity.StockAccount;

@RepositoryRestResource(collectionResourceRel = "monitorings", path = "monitorings")
public interface StockAccountRepository extends JpaRepository<StockAccount, Long> {

}