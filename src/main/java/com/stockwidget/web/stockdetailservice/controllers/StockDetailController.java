package com.stockwidget.web.stockdetailservice.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockwidget.web.stockdetailservice.NextSequenceService;
import com.stockwidget.web.stockdetailservice.dao.Stock;
import com.stockwidget.web.stockdetailservice.db.Stockdetaildbservice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "StockDetail", description = "Operation show all stock details.")
class StockDetailController {

	private Stockdetaildbservice stockdetaildbservice;
	private NextSequenceService serquenceService;

	@Autowired
	public StockDetailController(Stockdetaildbservice stockdetaildbservice, NextSequenceService serquenceService) {
		this.stockdetaildbservice = stockdetaildbservice;
		this.serquenceService = serquenceService;
	}

	@ApiOperation(value = "View a list of added stocks", response = Stock.class)
	@RequestMapping(value = "/stockdetail", method = RequestMethod.GET, produces = "application/json")
	public List<Stock> getStockDetail() {
		return stockdetaildbservice.getStockDetail();
	}

	@ApiOperation(value = "Operation is to add stock", response = Stock.class)
	@RequestMapping(value = "/addstock", method = RequestMethod.POST)
	public void addStockDetail(@RequestBody @Valid Stock stock) {
		stockdetaildbservice.add(stock);
	}

	@ApiOperation(value = "Operation is to valid stock", response = Stock.class)
	@RequestMapping(value = "/isvalidstock", method = RequestMethod.GET, produces = "application/json")
	public Stock isValidStock(@RequestParam String stockName) throws ParseException {

		Stock stock = new Stock();
		stock.setId(serquenceService.getNextSequence("hosting"));
		stock.setName(stockName);
		stock.setUnitValue("0.00");
		stock.setPreviousVal("2.30");
		stock.setGrowthRate("0.2");
		stock.setGrowthStatus("Up");

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String format = sdf.format(calendar.getTime());
		Date date = sdf.parse(format);
		stock.setTschange(date);

		return stock;
	}

	@ApiOperation(value = "Operation is to delete stock", response = Stock.class)
	@RequestMapping(value = "/deletestock", method = RequestMethod.POST, produces = "application/json")
	public void delete(@RequestBody @Valid Stock stock) {
		stockdetaildbservice.delete(stock);
	}

}
