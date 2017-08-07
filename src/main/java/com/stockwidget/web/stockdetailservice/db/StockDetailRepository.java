package com.stockwidget.web.stockdetailservice.db;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.stockwidget.web.stockdetailservice.dao.Stock;

public interface StockDetailRepository extends Repository<Stock, String> {

	List<Stock> findAll();

	Stock save(Stock stock);
}
