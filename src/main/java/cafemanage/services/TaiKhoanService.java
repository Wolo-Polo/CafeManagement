package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cafemanage.entities.TaiKhoan;
import cafemanage.repositories.TaiKhoanReps;

@Service
public class TaiKhoanService implements UserDetailsService{
	@Autowired
	private TaiKhoanReps taiKhoanReps;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<TaiKhoan> getListTaiKhoan(){
		return taiKhoanReps.findAll();
	}
	
	public TaiKhoan getTaiKhoanById(String id){
		return taiKhoanReps.findById(id).get();
	}
	
	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
		taiKhoan.setPassword(passwordEncoder.encode(taiKhoan.getPassword()));
		return taiKhoanReps.save(taiKhoan);
	}
	
	public TaiKhoan editTaiKhoan(TaiKhoan taiKhoan) {
		return taiKhoanReps.save(taiKhoan);
	}
	
	public boolean deleteTaiKhoan(String id) {
		taiKhoanReps.deleteById(id);
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return taiKhoanReps.findById(username).get();
	}
}
