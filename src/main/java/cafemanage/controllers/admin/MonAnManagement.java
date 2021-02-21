package cafemanage.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.MonAn;
import cafemanage.services.MonAnService;

@RestController
public class MonAnManagement {
	@Autowired
	private MonAnService monAnService;
	
	@GetMapping("/api/admin/monan")
	public List<MonAn> getListMonAn(){
		List<MonAn> result = monAnService.getListMonAn();
		return result;
	}
	@GetMapping("/api/admin/monan/{id}")
	public MonAn getMonAnById(@PathVariable(name = "id") String id){
		return monAnService.getMonAnById(id);
	}
	
	@PostMapping("/api/admin/monan")
	public MonAn addMonAn(@RequestBody MonAn monAn) {
		return monAnService.addMonAn(monAn);
	}
	
	@PutMapping("/api/admin/monan")
	public MonAn editMonAn(@RequestBody MonAn monAn) {
		return monAnService.editMonAn(monAn);
	}
	
	@DeleteMapping("/api/admin/monan/{id}")
	public ResponseEntity<?> deleteMonAn(@PathVariable(name = "id") String id) {
		if(monAnService.deleteMonAn(id)) {
			return ResponseEntity.ok().build();			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
}
