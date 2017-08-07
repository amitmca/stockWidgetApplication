package com.stockwidget.web.stockdetailservice.db;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockwidget.web.stockdetailservice.dao.Stock;

@Service
public class Stockdetaildbservice {

	private StockDetailRepository detailRepository;

	Stockdetaildbservice(StockDetailRepository detailRepository) {
		this.detailRepository = detailRepository;
	}

	public List<Stock> getStockDetail() {

		List<Stock> stockDetail = detailRepository.findAll();

		return stockDetail;
	}

	public void add(Stock stock) {
		detailRepository.save(stock);
	}
	
	public void delete(Stock stock){
		detailRepository.delete(stock);
	}

}
