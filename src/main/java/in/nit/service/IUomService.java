package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomService {

	public Integer saveUom(Uom uom);

	public List<Uom> getAllUoms();

	public void deleteUom(Integer id);

	public Uom getOneUom(Integer id);

	public void updateUom(Uom uom);
	
	public List<Object[]> getUomIdAndModel();
	
}
