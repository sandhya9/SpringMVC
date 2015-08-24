package bluemix.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myjpa.CustomerAcct;

@Repository
public class AccountService {
	private DataSource dataSource;
	private EntityManager entityManager;
		
	@Transactional
	public Collection<CustomerAcct> getAccounts() {
		Query qry = entityManager.createNamedQuery("listCustomers");
		Collection<CustomerAcct> foundAccounts = qry.getResultList();
		return foundAccounts;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@PersistenceContext (unitName="bluemix-springmvc")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	
	private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
        entityManager = emf.createEntityManager();
    }
}
