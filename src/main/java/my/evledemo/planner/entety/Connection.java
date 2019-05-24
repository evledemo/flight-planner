package my.evledemo.planner.entety;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "connection")
public class Connection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date operationStartDate;
	private Date rescueEndDate;
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "city_to_fk", nullable = false)
	@JsonIgnore
	private City cityTo;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "city_from_fk", nullable = false)
	@JsonIgnore
	private City cityFrom;
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, cascade = CascadeType.ALL, mappedBy = "connection")
	private List<Price> priceList;
}
