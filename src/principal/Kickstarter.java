package principal;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Kickstarter extends Exception
{
	//the arraylist contains the all users
	public static ArrayList<Person> users = new ArrayList<Person>();
	public static Person pessoa1 = new Person("usuario padrao", "usuario@mail.com", "12345678");
	
	//the arraylist contains the movies category
	public static ArrayList<Project> movies = new ArrayList<Project>();
	
	//the arraylist contains the design technology category
	public static ArrayList<Project> designTech = new ArrayList<Project>();

	//the arraylist contains the games category
	public static ArrayList<Project> games = new ArrayList<Project>();	
		
	//the arraylist contains the music category
	public static ArrayList<Project> music = new ArrayList<Project>();
		
	//the arraylist contains the food category
	public static ArrayList<Project> food = new ArrayList<Project>();
	
	//returns atual date
	public static String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date(0); 
		return dateFormat.format(date); 
	}
	
	//returns total projects
	public static int getTotalProjects() {
		return movies.size() + designTech.size() + games.size() + music.size() + food.size();
		
	}
	
	public static void add_project(Person person) {
		System.out.println("digite o nome do projeto");
		String project_name = input.nextLine();
		
		System.out.println("\ndigite a descricao do projeto");
		String project_description = input.nextLine();
		
		System.out.println("\ndigite um numero inteiro correspondente ao valor que o projeto precisa");
		int value_needed = input.nextInt();
		
		Project new_project = new Project(project_name,value_needed,project_description,person);
		person.insertProject(new_project);
		
		System.out.println("digite a categoria do projeto");
		System.out.println("1 - FILMES\n2 - DESIGN E TECNOLOGIA\n3 - JOGOS\n4 - ALIMENTOS ");
		int option = input.nextInt();
		switch (option) {
        case 1:
            movies.add(new_project);
            break;
        case 2:
           designTech.add(new_project);
            break;
        case 3:
        	games.add(new_project);
        	break;
        default:
             food.add(new_project);
     }
		
		
	}
	
	//create a new account and insert in the arraylist users
	public static void createAccount() {
		System.out.println("digite seu nome");
		input.next();
		String name = input.nextLine();
		
		System.out.println("\ndigite seu email");
		String email = input.nextLine();
		
		System.out.println("\ndigite sua senha");
		String senha = input.nextLine();
		
		Person newPerson = new Person(name,email,senha);
		
		users.add(newPerson);
		add_project(newPerson);
		
		
		
	}
	
	//log in to existing account
	private static void login() {
		
		System.out.println("digite seu email");
		input.next();
		String email = input.nextLine();
		
		System.out.println("\ndigite sua senha");
		String senha = input.nextLine();
		
		for(int i = 0; i < users.size(); i++){
			
			if(users.get(i).getEmail().equals(email))
			{
				System.out.println(users.get(i).toString());
				if(users.get(i).getSenha().equals(senha))
				{
					add_project(users.get(i));
				}
					
				else
				{
					System.out.println("senha incorreta");
				}
					
				break;
			}
		}
		
	}

	
	//start a project
	public static void startProject() {
		System.out.println("1 - criar uma conta\n2 - ja tenho uma conta\n3 - retornar");
		int option = input_int();
		switch (option) {
        case 1:
        	createAccount();
            break;
        case 2:
            login();
            break;
        case 3:
        	return;
        default:
             System.out.println("valor invalido!");
     }

		
	}
	
	
	public static void explore() {
		
	}

	
	
	
	
	//show profile and projects 
	public void show_profile(Person user) {

		System.out.println(user.toString());
		if(user.projects.size() > 0)
		{
			for(int i = 0; i < user.projects.size(); i++ )
			{
				System.out.println(user.projects.get(i).toString());
			}
		}

	}
	
	

}
