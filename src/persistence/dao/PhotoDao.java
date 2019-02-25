package persistence.dao;

import java.util.List;
import model.Photo;

public interface PhotoDao {

	public void save(Photo photo); // Create

	public Photo findByPrimaryKey(Long id); // Retrieve

	public List<Photo> findAll();

	public void update(Photo photo); // Update

	public void delete(Photo photo); // Delete

}
