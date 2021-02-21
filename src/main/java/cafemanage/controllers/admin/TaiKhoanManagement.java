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

import cafemanage.entities.TaiKhoan;
import cafemanage.services.TaiKhoanService;

@RestController
public class TaiKhoanManagement {
	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@GetMapping("/api/admin/taikhoan")
	public List<TaiKhoan> getListTaiKhoan(){
		List<TaiKhoan> result = taiKhoanService.getListTaiKhoan();
		return result;
	}
	@GetMapping("/api/admin/taikhoan/{id}")
	public TaiKhoan getTaiKhoanById(@PathVariable(name = "id") String id){
		return taiKhoanService.getTaiKhoanById(id);
	}
	
	@PostMapping("/api/admin/taikhoan")
	public TaiKhoan addTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
		return taiKhoanService.addTaiKhoan(taiKhoan);
	}
	
	@PutMapping("/api/admin/taikhoan")
	public TaiKhoan editTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
		return taiKhoanService.editTaiKhoan(taiKhoan);
	}
	
	@DeleteMapping("/api/admin/taikhoan/{id}")
	public ResponseEntity<?> deleteTaiKhoan(@PathVariable(name = "id") String id) {
		if(taiKhoanService.deleteTaiKhoan(id)) {
			return ResponseEntity.ok().build();			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
}
