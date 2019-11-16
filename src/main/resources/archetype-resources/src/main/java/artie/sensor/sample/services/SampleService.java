package artie.sensor.screenwebcam.services;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.agomezmoron.multimedia.recorder.VideoRecorder;
import com.github.agomezmoron.multimedia.recorder.configuration.VideoRecorderConfiguration;

import artie.sensor.common.dto.SensorObject;
import artie.sensor.screenwebcam.ScreenWebcamSensor;
import artie.sensor.screenwebcam.enums.ConfigurationEnum;
import artie.sensor.screenwebcam.listeners.ScreenListener;


@Service
public class SampleService {
	
	
	/**
	 * Function to start the sensor
	 */
	public void start(){
		//Do something
	}
	

	/**
	 * Function to stop the sensor
	 */
	public void stop(){
		//Do something
	}
}
