package persistence.dao;

import java.util.List;
import model.Copertina;

public interface CopertinaDao {

	public void save(Copertina copertina); // Create

	public Copertina findByPrimaryKey(Long id); // Retrieve

	public List<Copertina> findAll();

	public void update(Copertina copertina); // Update

	public void delete(Copertina copertina); // Delete

}