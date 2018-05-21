package principal;

public class Project {

	private String name;
	private double value_needed;
	private double current_value;
	private String description;
	public  Person creator;

	public Project(String name, double value_needed, String description, Person creator) {
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

	public double getValue_needed() {
		return value_needed;
	}


	public void receive_donation(double value)
	{
		this.current_value += value;
	}

	public double getCurrent_value() {
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
