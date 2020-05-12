package in.nit.dao;

import java.util.List;

import in.nit.model.Part;


public interface IPartDao {
	
    public Integer savePart(Part part);
    
	public List<Part> getAllParts();
	
	public void deletePart(Integer id);
	
	public Part  getOnePart(Integer id);
	
	public void updatePartType(Part part);
	
	public List<Object[]> getOrderIdAndCode();
		
	
	
}


