package cafemanage.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "monan")
public class MonAn {
	@Id
	@Column(name = "mamonan")
	private String maMonAn;
	@Column(name = "tenmonan")
	private String tenMonAn;
	@Column(name = "hinhanh")
	private String hinhAnh;
	@Column(name = "dongia")
	private BigDecimal donGia;
	@ManyToOne
	@JoinColumn(name = "maloaimon")
	private LoaiMon loaiMon;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "monAn")
	private List<ChiTietHoaDon> listChiTietHoaDon;
}
