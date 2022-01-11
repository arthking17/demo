package tn.itss.t24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.itss.t24.model.Client;
import tn.itss.t24.service.IClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoApplicationTests {

	@Autowired
	IClientService cs;
	
	static Client clientAdded;
	
	/*@Test
	public void contextLoads() {
		Client c = new Client("a1", "william", "abc2022", 22, "rib1", new Date());
		Client c2 = new Client("a2", "mohamed laroussi", "ml2022", 33, "rib2", new Date());
		//cs.addClient(c);
		//cs.addClient(c2);
		cs.getAllClients();
	}*/
	
	@Test
	public void DtestRetrieveAllUsers() {
		List<Client> listClients = cs.getAllClients(); 
		Assert.assertTrue(1<= listClients.size());
	}
	
	
	@Test
	public void AtestAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Client c = new Client("a3", "sofiane", "st2022", 22, "rib3", new Date());
		clientAdded = cs.addClient(c);
		Assert.assertEquals(c.getName(), clientAdded.getName());
	}
 
	@Test
	public void BtestModifyUser() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Client c = new Client("a3", "sofiane tebib", "st2022", 33, "rib3", new Date());
		Client clientUpdated  = cs.updateClient(c); 
		Assert.assertEquals(c.getName(), clientUpdated.getName());
	}

	@Test
	public void CtestRetrieveUser() {
		Client clientRetrieved = cs.getClient(clientAdded.getId()); 
		Assert.assertNotNull(clientRetrieved);
	
	}
	
	@Test
	public void EtestDeleteUser() {
		cs.deleteClient(clientAdded.getId());
	   Assert.assertNull(cs.getClient(clientAdded.getId()));
	  
	}
}
