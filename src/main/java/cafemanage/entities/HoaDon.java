package cafemanage.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mahoadon")
	private Integer maHoaDon;
	@ManyToOne
	@JoinColumn(name = "maban")
	private Ban ban;
	@Column(name = "tennhanvien")
	private String tenNhanVien;
	@Column(name = "thoigian")
	private Timestamp thoiGian;
	@Column(name = "tongtien")
	private BigDecimal tongTien;
	@Column(name = "dathanhtoan")
	private Boolean daThanhToan;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "hoaDon", cascade = CascadeType.ALL)
	private List<ChiTietHoaDon> listChiTietHoaDon;
	
	public void setListChiTietHoaDon(List<ChiTietHoaDon> listChiTietHoaDon) {
		for(ChiTietHoaDon chiTietHoaDon : listChiTietHoaDon) {
			chiTietHoaDon.setHoaDon(this);
		}
		this.listChiTietHoaDon = listChiTietHoaDon;
	}
}
