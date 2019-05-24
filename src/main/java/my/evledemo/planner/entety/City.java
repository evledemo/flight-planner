package my.evledemo.planner.entety;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ctity")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String iata;
	private String currencyCode;
	private Double longitude;
	private Double latitude;
	private String shortName;
	private String countryName;
	private String countryCode;
	@ElementCollection
	@CollectionTable(name="alias", joinColumns=@JoinColumn(name="alias_fk"))
	@Column(name="value")
	private List<String> aliases;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cityFrom")
	private List<Connection> connections;

}
