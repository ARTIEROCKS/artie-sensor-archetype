package ${package}.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.interfaces.ArtieClientSensor;
import ${package}.services.SampleService;

@Controller
public class SampleController implements ArtieClientSensor {

	@Autowired
	private SampleService sampleService;
	

	@GetMapping("/artie/sensor/${artifactId}/getName")
	@ResponseBody
	public String getName(){
		return this.sampleService.getName();
	}
	
	@GetMapping("/artie/sensor/${artifactId}/getVersion")
	@ResponseBody
	public String getVersion(){
		return this.sampleService.getVersion();
	}
	
	@GetMapping("/artie/sensor/${artifactId}/getAuthor")
	@ResponseBody
	public String getAuthor(){
		return this.sampleService.getAuthor();
	}
	
	@GetMapping("/artie/sensor/${artifactId}/isAlive")
	@ResponseBody
	public boolean getIsAlive() {
		return this.sampleService.getIsAlive();
	}
	
	@GetMapping("/artie/sensor/${artifactId}/getConfiguration")
	@ResponseBody
	public Map<String, String> getConfiguration(){
		return this.sampleService.getConfiguration();
	}
	
	@PostMapping(path = "/artie/sensor/screen/configuration")
	@ResponseBody
	public void setConfiguration(@RequestBody String configuration){
		this.sampleService.setConfiguration(configuration);
	}
	
	@Override
	public void setConfiguration(Map<String, String> configuration) {
		this.sampleService.setConfiguration(configuration);	
	}

	@GetMapping("/artie/sensor/${artifactId}/start")
	@ResponseBody
	public void start(){
		this.sampleService.start();
	}
	
	@GetMapping("/artie/sensor/${artifactId}/stop")
	@ResponseBody
	public void stop(){
		this.sampleService.stop();
	}
	
	@GetMapping("/artie/sensor/${artifactId}/getSensorData")
	@ResponseBody
	public List<SensorObject> getSensorData(){
		return this.sampleService.getSensorData();
	}
	
	@GetMapping("/artie/sensor/screen/sendSensorData")
	@ResponseBody
	public void sendSensorData() {
		this.sampleService.sendSensorData();		
	}
	
}
