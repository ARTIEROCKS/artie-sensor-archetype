package ${package};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineSensorRunner implements CommandLineRunner {

	@Autowired
	private SampleSensor sampleSensor;
	
	@Override
	public void run(String... args) throws Exception {
		sampleSensor.start();
	}

}