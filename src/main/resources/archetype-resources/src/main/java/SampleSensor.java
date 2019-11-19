package ${package};

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ${package}.enums.ConfigurationEnum;
import ${package}.services.SampleService;
import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.services.ArtieClientSensorImpl;

@Service
public class SampleSensor extends ArtieClientSensorImpl{

	//Configuration
	@Value("${artie.sensor.sample.active}")
	private String sampleSensorActive;
	
	//Services
	@Autowired
	private SampleService sampleService;
	
	//Attributes
	private boolean sampleServiceIsActive = false;
	
	/**
	 * About the sensor information
	 */
	public void sensorInformation(){
		this.name = "Screen and Webcam Sensor";
		this.version = "0.0.1";
		this.author = "Luis-Eduardo Imbernón";
	}
	
	@PostConstruct
	public void init(){
		this.sensorInformation();
		
		//Initialize the configuration
		this.configuration.putIfAbsent(ConfigurationEnum.SENSOR_ACTIVE.toString(),this.sampleSensorActive);
		this.sampleServiceIsActive = false;
	}
	
	@Override
	public void start() {
		
		//If the screen capture is enabled
		if(Boolean.parseBoolean(this.configuration.get(ConfigurationEnum.SENSOR_ACTIVE.toString()))){
			this.sampleService.start();
			this.sampleServiceIsActive = true;
		}
	}

	@Override
	public void stop() {
		//If the screen capture is active
		if(this.sampleServiceIsActive){
			this.sampleService.stop();
		}
	}
	
	/**
	 * Getting all the sensor data
	 * @return
	 */
	public List<SensorObject> getSensorData(){
		return this.sensorData;
	}
}
