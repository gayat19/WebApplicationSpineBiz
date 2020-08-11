package crud.mvcCrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import crud.mvcCrud.bean.Account;
import crud.mvcCrud.bean.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
	JdbcTemplate jdbcTemplate;
	
	public CustomerDaoImpl() {}
	public CustomerDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Customer> getAll() {
		String strSelect = "Select * from customer";
		List<Customer> customers = jdbcTemplate.query(strSelect, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer oneCustomer = new Customer();
				oneCustomer.setId(rs.getInt(1));
				oneCustomer.setName(rs.getString(2));
				oneCustomer.setAge(rs.getInt(3));
				return oneCustomer;
			}
		});
		return customers;
	}

	@Override
	public int save(Customer customer) {
		//Insert into customer values(?,?,?)
		int result = 0;
		try {
			jdbcTemplate.update("Insert into customer values(?,?,?)",customer.getId(),customer.getName(),customer.getAge());
			result = 1;
		}
		catch(Exception ex) {
			result = 0;
		}
		return result;
	}
	public int login(Customer customer) {
		int result = 0;
		String strSelect = "Select * from customer where id=?";
		Customer dbCustomer = jdbcTemplate.queryForObject(strSelect,new Object[] {customer.getId()}, new BeanPropertyRowMapper<Customer>(Customer.class));
		if(dbCustomer!= null && dbCustomer.getName().equals(customer.getName()))
			result = 1;
		return result;
	}

}
