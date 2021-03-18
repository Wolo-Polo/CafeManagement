package cafemanage.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DoanhSo {
	@Id
	private Integer id;
	private Integer thang;
	private Integer soluonghoadon;
	private Double doanhthu;
}
