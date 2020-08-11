package crud.mvcCrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import crud.mvcCrud.bean.Customer;
import crud.mvcCrud.dao.CustomerDao;

@Controller
public class HomeController {

	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/customers")
	public ModelAndView getAllCustomers() throws IOException{
		ModelAndView modelAndView =new ModelAndView("customerlist");
		List<Customer> customers = customerDao.getAll();
		modelAndView.addObject("customers",customers);
		return modelAndView;
	}
	
	@RequestMapping(value="/add")
	public ModelAndView addCustomer() throws IOException{
		ModelAndView modelAndView =new ModelAndView("addCustomer");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView userLogin() throws IOException{
		ModelAndView modelAndView =new ModelAndView("userlogin");
		return modelAndView;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView userPostLogin(@ModelAttribute Customer customer) throws IOException{
		ModelAndView modelAndView =null;
		int res = customerDao.login(customer);
		System.out.println(res);
		if(res == 1)
		{
			System.out.println("Done");
			modelAndView =new ModelAndView("home");
			modelAndView.addObject("message","Welcome. You are Logged in...");
		}
		else
		{
			modelAndView =new ModelAndView("userlogin");
			modelAndView.addObject("message","Invalid username or password");
		}
			
		return modelAndView;
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute Customer customer) throws IOException{
		ModelAndView modelAndView =null;//=new ModelAndView("addCustomer");
		try {
			if(customer != null)
			{
				customerDao.save(customer);
				modelAndView = new ModelAndView("welcome");
				modelAndView.addObject("customer",customer);
			}
		} catch (Exception e) {
			modelAndView = new ModelAndView("addCustomer");
			modelAndView.addObject("message","Could not add customer");
		}
		return modelAndView;
	}
}
