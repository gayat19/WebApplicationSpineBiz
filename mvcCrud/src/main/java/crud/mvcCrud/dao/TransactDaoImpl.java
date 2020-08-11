package crud.mvcCrud.dao;


import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import crud.mvcCrud.bean.*;


public class TransactDaoImpl implements TransactDao {
	
	JdbcTemplate jdbcTemplate;
	
	public TransactDaoImpl() {}
	public TransactDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Override
	public String doTransaction(Transaction transaction) {
		String strSelect = "Select * from accounts where accountnumber = ?";
		System.out.println(transaction.getFromAccount());
		Account fromaccount = jdbcTemplate.queryForObject(strSelect,new Object[] {transaction.getFromAccount()}, new BeanPropertyRowMapper<Account>(Account.class));
		strSelect = "Select * from accounts where accountnumber = ?";
		Account toaccount = jdbcTemplate.queryForObject(strSelect,new Object[] {transaction.getToAccount()}, new BeanPropertyRowMapper<Account>(Account.class));
		if(fromaccount!=null && toaccount!=null && fromaccount.getBalance()>transaction.getAmount())
		{
			String sql="insert into transactions(fromaccount,toaccount,amount) values('"+transaction.getFromAccount()+"','"+transaction.getToAccount()+
					"',"+transaction.getAmount()+")";
			jdbcTemplate.update(sql);
			float newbalance = fromaccount.getBalance()-transaction.getAmount();
			sql = "Update accounts set balance = "+newbalance+" where accountnumber = '"+transaction.getFromAccount()+"'";
			jdbcTemplate.update(sql);
			newbalance = toaccount.getBalance()+transaction.getAmount();
			sql = "Update accounts set balance = "+newbalance+" where accountnumber = '"+transaction.getToAccount()+"'";
			jdbcTemplate.update(sql);
			return "Done";
		}
		return "Failed";
	}


}
