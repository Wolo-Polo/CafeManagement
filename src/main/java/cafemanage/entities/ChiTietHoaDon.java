package cafemanage.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "cthoadon")
public class ChiTietHoaDon {
	//@JsonIgnore //khong hien id trong json
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macthoadon")
	private Integer maCTHoaDon;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mahoadon")
	private HoaDon hoaDon;
	@ManyToOne
	@JoinColumn(name = "mamonan")
	private MonAn monAn;
	@Column(name = "soluong")
	private Integer soLuong;
	@Column(name = "dongia")
	private BigDecimal donGia;
	@Column(name = "ghichu")
	private String ghiChu;
}
