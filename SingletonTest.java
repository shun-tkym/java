public class SingletonTest{
public static void main(String[] args){
	
	Renban r1 = Renban.getInstance();
	Renban r2 = Renban.getInstance();
	
	
	system.out.println(r1.getNumber());
	system.out.println(r2.getNumber());
	system.out.println(r1.getNumber());
}
class Renban{
	private static Renban renban = new Renban();
	private String number;
	
	public  static Renban getInstance(){
		return renban;
	}
	
	public int getNumber(int i){

	}
	} 
}
