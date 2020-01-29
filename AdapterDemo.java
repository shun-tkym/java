class Bank {
    private int deposit;
    private int debt;

    public Bank(int deposit, int debt) {
        this.deposit = deposit;
        this.debt = debt;
    }
    public int getDeposit() {
        return this.deposit;
    }
    public int getDebt() {
        return this.debt;
    }
}
interface Print {
    //貯金を表示
    public abstract void printDeposit();
    //借金を表示
    public abstract void printDebt();
}
class PrintBank extends Bank implements Print {
    public PrintBank(int deposit, int debt) {
        super(deposit, debt);
    }
    public void printDeposit() {
        System.out.println("貯金:" + this.getDeposit() + "円");
    }
    public void printDebt() {
        System.out.println("借金:" + this.getDebt() + "円");
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        Print p = new PrintBank(300,100);
        //貯金額を表示
        p.printDeposit();
        //借金額を表示
        p.printDebt();

    }
  }
