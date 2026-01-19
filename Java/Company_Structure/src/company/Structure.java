package company;

public class Structure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n\nProvide Manager Details");
		Manager manage = new Manager();
		manage.manageTeam();
		manage.displayinfo();
		
		System.out.println("\n\nProvide Manager Details");
		Manager manager = new Manager();
		manager.manageTeam();
		manager.displayinfo();
		
		System.out.println("\n\nProvide Developer Details");
		Developer develop = new Developer();
		develop.code();
		develop.displayinfo();
		
		System.out.println("\n\nProvide Sales Person Details");
		SalesPerson sales = new SalesPerson();
		sales.achieveTarget();
		sales.displayinfo();
		
		System.out.println("\n\nTotal Employees in the system are: "+Employee.count);
		System.out.println("\n\nTotal Manager in the system are: "+Manager.man_count);
		System.out.println("\n\nTotal Employees in the system are: "+Developer.dev_count);
		System.out.println("\n\nTotal Employees in the system are: "+SalesPerson.sale_count);
	}

}
