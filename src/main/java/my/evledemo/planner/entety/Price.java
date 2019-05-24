package my.evledemo.planner.entety;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "price")
@EntityListeners(AuditingEntityListener.class)
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	private Double price;
	private Double priceEuro;
	@CreatedDate
	private Date createdDate;
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "connection_fk", nullable = false)
	@JsonIgnore
	private Connection connection;
}
