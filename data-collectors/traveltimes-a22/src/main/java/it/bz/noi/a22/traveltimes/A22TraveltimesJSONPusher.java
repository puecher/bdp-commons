package it.bz.noi.a22.traveltimes;

import it.bz.idm.bdp.dto.DataMapDto;
import it.bz.idm.bdp.dto.ProvenanceDto;
import it.bz.idm.bdp.dto.RecordDtoImpl;
import it.bz.idm.bdp.json.JSONPusher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class A22TraveltimesJSONPusher extends JSONPusher
{

	private String stationtype;
	private String origin;
	private String provenanceVersion;
	private String provenanceName;

	public <T> DataMapDto<RecordDtoImpl> mapData(T arg0)
	{
		throw new IllegalStateException("it is used by who?");
	}

	public A22TraveltimesJSONPusher() {
		init();
	}

	@PostConstruct
	public void init() {
		A22Properties prop = new A22Properties("a22traveltimes.properties");

		stationtype = prop.getProperty("stationtype");
		origin = prop.getProperty("origin");
		provenanceName = prop.getProperty("provenance_name");
		provenanceVersion = prop.getProperty("provenance_version");

		super.init();
	}

	@Override
	public String initIntegreenTypology()
	{
		return stationtype;
	}

	@Override
	public ProvenanceDto defineProvenance() {
		return new ProvenanceDto(null, provenanceName, provenanceVersion,  origin);
	}
}