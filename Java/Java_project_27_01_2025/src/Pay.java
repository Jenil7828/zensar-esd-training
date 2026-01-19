
public class Pay {
	public static void main(String[] args) {
		Payments cc = new Credit();
		cc.implementation();
		cc.thanks();
		
		System.out.println();
		
		Payments net = new NetBanking();
		net.implementation();
		net.thanks();
		
		System.out.println();
		
		Payments gpay = new GPay();
		gpay.implementation();
		gpay.thanks();
	}
}
