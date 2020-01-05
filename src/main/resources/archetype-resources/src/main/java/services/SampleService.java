package ${package}.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.services.ArtieClientSensorImpl;


@Service
public class SampleService extends ArtieClientSensorImpl {
	
	@Value("${artie.sensor.sample.name}")
	private String paramName;
	
	@Value("${artie.sensor.sample.version}")
	private String paramVersion;
	
	@Value("${artie.sensor.sample.author}")
	private String paramAuthor;
	
	
	/**
	 * About the sensor information
	 */
	private void sensorInformation(){
		this.name = this.paramName;
		this.version = this.paramVersion;
		this.author = this.paramVersion;
	}
	
	@PostConstruct
	public void init(){
		this.sensorInformation();
		this.isAlive = true;
	}
	
	/**
	 * Getting the sensor data from the listeners
	 * @return
	 */
	public List<SensorObject> getSensorData(){
		return this.getSensorData();
	}
	
	@Override
	public void start() {
		//Do something
	}
	
	@Override
	public void stop() {
		//Do something
	}
}
