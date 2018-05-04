package principal;

public class Main extends Kickstarter{
	
	

	public static void main(String[] args)
	{
		users.add(pessoa1);

		new Person("usuario padrao", "usuario@mail.com", "12345678").toString();
		boolean test = true;
		while(test)
		{
			System.out.println("\t\t------- KICKSTARTER--------");
			System.out.println(getDateTime()+"\t total de usuarios: " + users.size()+ "\t total de projetos :" + getTotalProjects());
			
			System.out.println("\n1 - comece um projeto\n2 - explorar\n3 - sair");
			int option = input_int();
			switch (option) {
            case 1:
                startProject();
                break;
            case 2:
                explore();
                break;
            case 3:
            	return;
            default:
                 System.out.println("valor invalido!");
                 break;
         }
			
		}
	}


}
