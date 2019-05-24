package my.evledemo.planner.transport.dtc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.evledemo.planner.transport.dto.PriceDTO;

import java.util.List;

@Getter
@Setter
@ToString
public class PriceDTC {
	private String itaFrom;
	private String itaTo;
	private List<PriceDTO> pricesOutbound;
	private List<PriceDTO> pricesReturn;
}
