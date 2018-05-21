package principal;

import java.nio.channels.ShutdownChannelGroupException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Kickstarter extends Exception
{
	static //the arraylist contains the all users
	Map<String,Person> users = new HashMap<String,Person>();
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
	
	//returns actual date
	public static String getDateTime() {
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
		return formatarDate.format(data);
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
		
		System.out.println("\ndigite o valor que o projeto precisa");
		double value_needed = inputDouble();
		
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
		while( users.containsKey(email)){
			System.out.println("\nemail existente\n, por favor digite outro email ");
			email = input.nextLine();
		}
		
		System.out.println("\ndigite sua senha");
		String senha = input.nextLine();
		
		Person newPerson = new Person(name,email,senha);
		

		users.put(email,newPerson);
		add_project(newPerson);
		
		
		
	}
	
	//log in to existing account
	private static void login() {
		
		System.out.println("digite seu email");
		input.next();
		String email = input.nextLine();
		while( !users.containsKey(email)){
			System.out.println("\nemail inexistente\n, por favor digite um email valido ");
			email = input.nextLine();
		}
		
		System.out.println("\ndigite sua senha");
		String senha = input.nextLine();
		while( !users.get(email).getSenha().equals(senha)) {
			System.out.println("\nsenha incorreta, tente novamente");
			email = input.nextLine();
		}
		
		add_project(users.get(email));		
	}

	private static void donate(Project project) {
		System.out.println("digite o valor a ser doado");
		double value = inputDouble();
		if(value <= 0)
			System.out.println("valor invalido");
		
		else {
			project.receive_donation(value);
			System.out.println("obrigado!!!!!!!");
		}
	}

	
	private static void showProject(Project project) {
		System.out.println("NOME: "+project.getName());
		System.out.println("CRIADOR: "+project.creator.getName());
		System.out.println("VALOR NECESSARIO: "+project.getValue_needed());
		System.out.println("VALOR OBTIDO: "+project.getCurrent_value());
		System.out.println("1 ======> doar");
		System.out.println("2 ======> ver perfil do criador");
		
		int option = inputInt();
		switch (option) {
        case 2:
        	System.out.println(project.creator.toString());
            break;
        case 1:
            donate(project);
            break;
		}
		
		
	}

	

	//start a project
	public static void startProject() {
		System.out.println("1 - criar uma conta\n2 - ja tenho uma conta\n3 - retornar");
		int option = inputInt();
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
	
	public static void showMovies() {
		if( movies.size()==0)
			return;
		
		for(int i = 0; i < movies.size(); i++ )
			System.out.println(i + "->"+movies.get(i).toString());
		
		int option = inputInt();
		if(option >= movies.size() ||option < 0)
			System.out.println("projeto invalido");
		else
			showProject(movies.get(option));
		

	}
	
	public static  void showDesignTech() {
		if( designTech.size()==0)
			return;
		
		for(int i = 0; i < designTech.size(); i++ )
			System.out.println(i + "->"+designTech.get(i).toString());
		
		int option = inputInt();
		if(option >= designTech.size() ||option < 0)
			System.out.println("projeto invalido");
		else
			showProject(designTech.get(option));
		
	}
	
	public static void showgames() {
		if( games.size()==0)
			return;
		
		for(int i = 0; i < games.size(); i++ )
			System.out.println(i + "->"+games.get(i).toString());
		
		int option = inputInt();
		if(option >= games.size() ||option < 0)
			System.out.println("projeto invalido");
		else
			showProject(games.get(option));
		
	}
	
	public static void showMusic() {
		if(  music.size()==0)
			return;
		
		for(int i = 0; i < music.size(); i++ )
			System.out.println(i + "->"+music.get(i).toString());
		
		int option = inputInt();
		if(option >= music.size() ||option < 0)
			System.out.println("projeto invalido");
		else
			showProject(music.get(option));
	}
	
	public static void showFood() {
		if(  food.size()==0)
			return;
		
		for(int i = 0; i < food.size(); i++ )
			System.out.println(i + "->"+food.get(i).toString());
		
		int option = inputInt();
		if(option >= food.size() ||option < 0)
			System.out.println("projeto invalido");
		else
			showProject(food.get(option));
		
	}
	

	public static void explore() {
		System.out.println("PROJETOS DISPONIVEIS");
		
		System.out.println("1 PARA ACESSAR :"+movies.size()+":PROJETOS SOBRE FILMES");
		System.out.println("2 PARA ACESSAR :"+designTech.size()+":PROJETOS SOBRE DESIgN E TECNOLOgIA");
		System.out.println("3 PARA ACESSAR :"+games.size()+":PROJETOS SOBRE gAMES");
		System.out.println("4 PARA ACESSAR :"+music.size()+":PROJETOS SOBRE MUSICA");
		System.out.println("5 PARA ACESSAR :"+food.size()+":PROJETOS SOBRE comida");
		
		System.out.println("digite uma opcao");
		int option = inputInt();
		switch (option) {
        case 1:
           showMovies();
            break;
        case 2:
        	showDesignTech();
            break;
        case 3:
        	showgames();
        	break;
        case 4:
        	showMusic();
        	break;
        case 5:
        	showFood();
        	break;
        default:
             System.out.println("valor invalido!");
             break;
		}
		
		
		
	}

	
	
	
	
	//show profile and projects 
	public void show_profile(Person user) {

		System.out.println(user.toString());
			for(int i = 0; i < user.projects.size(); i++ ){
				System.out.println(user.projects.get(i).toString());
		}

	}
	
	

}
