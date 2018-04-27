package principal;

public class Project {

	private int value_needed;
	private int current_value;
	private String description;
	public  Person creator;
	
	public Project(int value_needed, int current_value, String description, Person creator) {
		super();
		this.value_needed = value_needed;
		this.current_value = current_value;
		this.description = description;
		this.creator = creator;
	}

	public int getValue_needed() {
		return value_needed;
	}

	public void setValue_needed(int value_needed) {
		this.value_needed = value_needed;
	}

	public int getCurrent_value() {
		return current_value;
	}

	public void setCurrent_value(int current_value) {
		this.current_value = current_value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
