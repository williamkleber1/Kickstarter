package principal;

import java.util.ArrayList;

public class Person {

	private String name;
	private String email;
	private String Senha;
	public ArrayList<Project> projects = new ArrayList<Project>();

	public Person(String name, String email, String senha) {
		super();
		this.name = name;
		this.email = email;
		this.Senha = senha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String toString() {
		return "name : " + this.getName() + "\nemail : " + this.getEmail() + "\nnumero de projetos : " + this.projects.size() + "\n";

	}

	public void insertProject( Project proj) {
		this.projects.add(proj);
		proj.creator = this;

	}

	public void remove_project(Project proj) {
		for(int i = 0; i < this.projects.size(); i++)
		{
			if(this.projects.get(i).getDescription().equals(proj.getDescription())  )
			{
				this.projects.remove(proj);
				break;
			}
		}

	}



}
