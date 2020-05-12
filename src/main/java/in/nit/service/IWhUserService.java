package in.nit.service;

import java.util.List;

import in.nit.model.WhUserType;

public interface IWhUserService {
	
	public Integer saveWhUser(WhUserType user);
	
	public List<WhUserType> getAllWhUsers();
	
	public void deleteWhUser(Integer id);

	public WhUserType getOneWhUser(Integer id);
	
	public void updateWhuser(WhUserType user);
	 
	public List<Object[]> getUserTypeAndCode(String user);
}
