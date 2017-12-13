package com.stockmonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stockmonitor.entity.StockAccount;

@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface StockAccountRepository extends JpaRepository<StockAccount, Long> {

}