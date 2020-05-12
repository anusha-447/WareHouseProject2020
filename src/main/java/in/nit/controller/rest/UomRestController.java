package in.nit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	@Autowired
	private IUomService service;
	//1.get all
	@GetMapping("/all")
	public ResponseEntity<?> fetchAll(){
		ResponseEntity<?> resp=null;
		try {
			List<Uom> uoms=service.getAllUoms();
            if(uoms!=null && !uoms.isEmpty()) {
				resp=new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);
			}
			else {
				resp=new ResponseEntity<String>("mo date",HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to fetch the data",HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}
	//2.save operation
	@PostMapping("/save")
	public ResponseEntity<String> saveUom(@RequestBody Uom uom){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveUom(uom);
			resp= new ResponseEntity<String>("saved "+id,HttpStatus.OK);
			
		} catch (Exception e) {
			resp= new ResponseEntity<String>("unable to save ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
//3.update operation
	@PutMapping("/update")
	public ResponseEntity<String> updateUom(@RequestBody Uom uom){
		ResponseEntity<String> resp=null;
		try {
			service.updateUom(uom);
			resp= new ResponseEntity<String>("updated "+uom.getUomId(),HttpStatus.OK);
			
		} catch (Exception e) {
			resp= new ResponseEntity<String>("unable to updated "+uom.getUomId(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	//4.edit operation
	@GetMapping("/getOne")
	public ResponseEntity<?> getOneUom(@RequestParam("id") Integer id){
		ResponseEntity<?> resp=null;
		try {
			Uom uom=service.getOneUom(id);
			if(uom!=null) {
			resp=new ResponseEntity<Uom>(uom,HttpStatus.OK);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Uom '"+id+"' not exist",HttpStatus.BAD_REQUEST);
		}
		return null;
		
	}
	//5.delete operation
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteOneUom(@RequestParam("id") Integer id){
		ResponseEntity<?> resp=null;
		try {
			service.deleteUom(id);
			resp=new ResponseEntity<String>("deleted succesfully",HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Uom '"+id+"' not exist",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
}
