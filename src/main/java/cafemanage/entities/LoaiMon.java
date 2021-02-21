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
@Table(name = "loaimon")
public class LoaiMon {
	@Id
	@Column(name = "maloaimon")
	private String maLoaiMon;
	@Column(name = "tenloaimon")
	private String tenLoaiMon;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiMon")
	private List<MonAn> listMonAn;
}
