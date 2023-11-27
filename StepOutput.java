// Written by Matthew Mulderink

package application;

public class StepOutput {
	String Step, Output;
	
	public StepOutput(String step, String output) {
		setStep(step);
		setOutput(output);
	}
	
	
	public String getStep() {
		return Step;
	}

	public void setStep(String step) {
		Step = step;
	}

	public String getOutput() {
		return Output;
	}

	public void setOutput(String output) {
		Output = output;
	}


}
