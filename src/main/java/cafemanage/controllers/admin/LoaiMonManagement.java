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

import cafemanage.entities.LoaiMon;
import cafemanage.services.LoaiMonService;

@RestController
public class LoaiMonManagement {
	@Autowired
	private LoaiMonService loaiMonService;
	
	@GetMapping("/api/admin/loaimon")
	public List<LoaiMon> getListLoaiMon(){
		List<LoaiMon> result = loaiMonService.getListLoaiMon();
		return result;
	}
	@GetMapping("/api/admin/loaimon/{id}")
	public LoaiMon getLoaiMonById(@PathVariable(name = "id") Integer id){
		return loaiMonService.getLoaiMonById(id);
	}
	
	@PostMapping("/api/admin/loaimon")
	public LoaiMon addLoaiMon(@RequestBody LoaiMon loaiMon) {
		return loaiMonService.addLoaiMon(loaiMon);
	}
	
	@PutMapping("/api/admin/loaimon")
	public LoaiMon editLoaiMon(@RequestBody LoaiMon loaiMon) {
		return loaiMonService.editLoaiMon(loaiMon);
	}
	
	@DeleteMapping("/api/admin/loaimon/{id}")
	public ResponseEntity<?> deleteLoaiMon(@PathVariable(name = "id") Integer id) {
		if(loaiMonService.deleteLoaiMon(id)) {
			return ResponseEntity.ok().build();			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
}
