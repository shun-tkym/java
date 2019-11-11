public class SingletonTest{
public static void main(String[] args){

	Renban r1 = Renban.getInstance();
  r1.getNumber(1);
	Renban r2 = Renban.getInstance();
  r2.getNumber(2);

	system.out.println(r1.getNumber());
	system.out.println(r2.getNumber());
	system.out.println(r1.getNumber());
}
}

class Renban{
	private static Renban renban = new Renban();
  private int bangou;

	public  static Renban getInstance(){
		return renban;
	}
  public void getNumber(int sirusi) {
  bangou += sirusi;

	}
}

