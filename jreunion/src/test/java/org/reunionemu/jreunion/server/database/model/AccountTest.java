package org.reunionemu.jreunion.server.database.model;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reunionemu.jreunion.dao.AccountDao;
import org.reunionemu.jreunion.model.Account;
import org.reunionemu.jreunion.model.jpa.AccountImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/**/*-context.xml", 
	"classpath*:/spring/**/*-context-test.xml"})
public class AccountTest {

	@Autowired
	@Qualifier("accountRepository")
	AccountDao<Account> accountRepository;
	
	@Test
	public void test() {
		Assert.assertNotNull(accountRepository);
		Account account = new AccountImpl();
		account.setUsername("test");
		account.setEmail("test@example.com");
		account.setName("John Doe");
		account.setPassword("1234");
		
		accountRepository.save(account);
		
		List<Account> accounts = accountRepository.findByEmail("test@example.com");
		Assert.assertNotNull(accounts);
		Assert.assertThat(accounts.size(), greaterThan(0));
		
		accountRepository.delete(accounts);
		accounts = accountRepository.findByEmail("test@example.com");
		Assert.assertThat(accounts.size(), is(0));		
	}

}
