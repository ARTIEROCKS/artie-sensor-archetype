package artie.sensor.screenwebcam;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.services.ArtieClientSensorImpl;
import artie.sensor.screenwebcam.enums.ConfigurationEnum;
import artie.sensor.screenwebcam.services.ScreenService;

@Service
public class ScreenWebcamSensor extends ArtieClientSensorImpl{

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
			this.screenService.start();
			this.screenServiceIsActive = true;
		}
	}

	@Override
	public void stop() {
		//If the screen capture is active
		if(this.sampleServiceIsActive){
			this.screenService.stop();
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
