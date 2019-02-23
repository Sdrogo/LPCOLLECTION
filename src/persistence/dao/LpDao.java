package persistence.dao;
import java.util.List;
import model.Lp;

public interface LpDao {

	public void save(Lp lp);  // Create 
	public Lp findByPrimaryKey(Long id);// Retrieve
	public List<Lp> findAll();       
	public void update(Lp lp); //Update
	public void delete(Lp lp); //Delete	
	public boolean findByName(String titolo);

}
