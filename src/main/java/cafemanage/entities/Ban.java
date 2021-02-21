package cafemanage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "maban")
	private String maBan;
	@Column(name = "tenban")
	private String tenBan;
	@Column(name = "tinhtrang")
	private String tinhTrang;
	@Column(name = "ghichu")
	private String ghiChu;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ban")
	private List<HoaDon> listHoaDon;
}
