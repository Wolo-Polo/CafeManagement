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

import cafemanage.entities.Ban;
import cafemanage.services.BanService;

@RestController
public class BanManagement {
	@Autowired
	private BanService banService;
	
	@GetMapping("/api/admin/ban")
	public List<Ban> getListBan(){
		List<Ban> result = banService.getListBan();
		return result;
	}
	@GetMapping("/api/admin/ban/{id}")
	public Ban getBanById(@PathVariable(name = "id") String id){
		return banService.getBanById(id);
	}
	
	@PostMapping("/api/admin/ban")
	public Ban addBan(@RequestBody Ban ban) {
		return banService.addBan(ban);
	}
	
	@PutMapping("/api/admin/ban")
	public Ban editBan(@RequestBody Ban ban) {
		return banService.editBan(ban);
	}
	
	@DeleteMapping("/api/admin/ban/{id}")
	public ResponseEntity<?> deleteBan(@PathVariable(name = "id") String id) {
		if(banService.deleteBan(id)) {
			return ResponseEntity.ok().build();			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
}
