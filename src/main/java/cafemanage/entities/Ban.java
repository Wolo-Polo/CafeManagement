package cafemanage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "ban")
public class Ban {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maban")
	private Integer maBan;
	@Column(name = "mota")
	private String moTa;
	@Column(name = "tinhtrang")
	private String tinhTrang;
	@Column(name = "ghichu")
	private String ghiChu;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ban")
	private List<HoaDon> listHoaDon;
}
