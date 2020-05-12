package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
import in.nit.service.IPartService;
@Service
public class PartServiceImpl  implements IPartService{

	
	@Autowired
	private IPartDao dao;
	@Override
	@Transactional
	public Integer savePart(Part part) {
		// TODO Auto-generated method stub
		return dao.savePart(part);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Part> getAllParts() {
		// TODO Auto-generated method stub
		List<Part> list=dao.getAllParts();
		Collections.sort(list, (o1,o2)->o1.getPid()-o2.getPid());
		return list;
	}

	@Override
	@Transactional
	public void deletePart(Integer id) {
		// TODO Auto-generated method stub
		dao.deletePart(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Part getOnePart(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOnePart(id);
	}

	@Override
	@Transactional
	public void updatePartType(Part part) {
		// TODO Auto-generated method stub
		dao.updatePartType(part);;
	}

	@Override
	public List<Object[]> getOrderIdAndCode() {
		// TODO Auto-generated method stub
		List<Object[]> list=dao.getOrderIdAndCode();
		return list;
	}

	

	
}
