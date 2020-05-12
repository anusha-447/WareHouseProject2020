package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	@Autowired
    private IUomDao dao;
	@Override
	@Transactional
	public Integer saveUom(Uom uom) {
		// TODO Auto-generated method stub
		return dao.saveUom(uom);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		List<Uom> list=dao.getAllUoms();
		Collections.sort(list, (o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
		
	}
	@Override
	@Transactional
	public void deleteUom(Integer id) {
		// TODO Auto-generated method stub
	        dao.deleteUom(id);
	}
	@Override
	@Transactional(readOnly=true)
	public Uom getOneUom(Integer id) {
		// TODO Auto-generated method stub
		
		return dao.getOneUom(id);
	}
	@Override
	@Transactional
	public void updateUom(Uom uom) {
		// TODO Auto-generated method stub
		dao.updateUom(uom);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getUomIdAndModel() {
		// TODO Auto-generated method stub
		return dao.getUomIdAndModel();
	}

	

}
