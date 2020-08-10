package crud.mvcCrud.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import crud.mvcCrud.bean.Transaction;
import crud.mvcCrud.dao.TransactDao;

@Controller
public class TransactionController {
	@Autowired
	TransactDao transactionDao;
	
	@RequestMapping(value="/transact")
	public ModelAndView transactNow() throws IOException{
		ModelAndView modelAndView =new ModelAndView("transact");	
		return modelAndView;
	}
	@RequestMapping(value="/transact", method=RequestMethod.POST)
	public ModelAndView doneTransaction(@ModelAttribute Transaction transaction) throws IOException{
		ModelAndView modelAndView =new ModelAndView("result");
		
		String strRes = transactionDao.doTransaction(transaction);
		modelAndView.addObject("Message",strRes);
		return modelAndView;
	}
	@RequestMapping(value="/showResult")
	public ModelAndView showTransactionResult() throws IOException{
		ModelAndView modelAndView =new ModelAndView("result");
		
		return modelAndView;
	}

}
