package principal;

public class Project {

	private String name;
	private int value_needed;
	private int current_value;
	private String description;
	public  Person creator;

	public Project(String name, int value_needed, String description, Person creator) {
		super();
		this.name = name;
		this.value_needed = value_needed;
		this.current_value = 0;
		this.description = description;
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public int getValue_needed() {
		return value_needed;
	}

	public void setValue_needed(int value_needed) {
		this.value_needed = value_needed;
	}

	public void receive_donation(int donation)
	{
		this.current_value += donation;
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

	public String toString() {
		return "nome do projeto: "+this.getName()+"\n descricao: "+this.getDescription()+"\nvalor necessario: "+this.getValue_needed()+ "\nvalor obtido :"+getCurrent_value() + "\n";
	}


}
