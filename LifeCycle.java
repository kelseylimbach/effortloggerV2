package application;

public class LifeCycle {
	String Step, LifeCycle, EffortCategory, Default;
	
	public LifeCycle(String step1, String lC1, String effortCategory1, String Default1) {
		Step = step1;
		LifeCycle = lC1;
		EffortCategory = effortCategory1;
		Default = Default1;
	}
	
	public String getEffortCategory() {
		return EffortCategory;
	}

	public void setEffortCategory(String effortCategory) {
		EffortCategory = effortCategory;
	}

	public String getDefault() {
		return Default;
	}

	public void setDefault(String default1) {
		Default = default1;
	}
	
	public String getStep() {
		return Step;
	}

	public void setStep(String step) {
		Step = step;
	}

	public String getLifeCycle() {
		return LifeCycle;
	}

	public void setLifeCycle(String lifeCycle) {
		LifeCycle = lifeCycle;
	}

}
