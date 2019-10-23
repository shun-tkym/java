public class IteratorSample1 {
  public static void main(String[] args) {
    GameListAggregate gameListAggregate = new GameListAggregate();
    Iterator iterator = gameListAggregate.createIterator();
    gameListAggregate.add(new Game("○本", 3700));
    gameListAggregate.add(new Game("○○本", 7300));
    gameListAggregate.add(new Game("○○○本", 5400));
    gameListAggregate.add(new Game("○○○○本", 5200));
    iterator.first(); // まず探す場所を先頭位置にしてもらう
    while ( ! iterator.isDone() ) { // まだある？ まだあるよ！
      Game game = (Game)iterator.getItem(); // はいどうぞ (と受取る)
      System.out.println(game.getName());
      iterator.next(); // 次を頂戴
    }
  }
}

interface Iterator {
  public void first(); // 取り出し位置を最初の要素へ変える
  public void next(); // 取り出し位置を次の要素へ変える
  public boolean isDone(); // 取り出し位置が最後を超えたか？
  public Object getItem(); // 現在の取り出し位置から取り出す
}

class GameListIterator implements Iterator {
  private GameListAggregate aggregate;
  private int current;
  public GameListIterator(GameListAggregate aggregate) {
    this.aggregate = aggregate;
  }
  @Override
  public void first() {
    current = 0;
  }
  @Override
  デザインパターン入門
  7 / 9
  public void next() {
    current += 1;
  }
  @Override
  public boolean isDone() {
    if (current >= aggregate.getNumberOfStock()) {
      return true;
    }
    else {
      return false;
    }
  }
  @Override
  public Object getItem() {
    return aggregate.getAt(current);
  }
}

interface Aggregate {
  public Iterator createIterator();
}

class GameListAggregate implements Aggregate {
  private Game[] list; // ゲームソフトを格納する配列
  private int numberOfStock; // 現在の在庫数
  public GameList(int number) { // コンストラクタ
  list = new Game[number]; // 配列の大きさを確定
  numberOfStock = 0;
  }
  public void add(Game game) {
  list[numberOfStock] = game; // 格納
  numberOfStock += 1; // 在庫数を1 つ増加
  }
  public Game getGame(int number) { // 指定番号のゲームソフト取出し
  return list[number];
  }
  public int getNumberOfStock() { // 現在の在庫数を取得
  return numberOfStock;
  }
}

class Game {
  private String name; // 名称
  private int price; // 価格
  public Game(String name, int price) { // コンストラクタ
    this.name= name;
    this.price = price;
  }
  public String getName() { // 名称を取得
    return name;
  }
  public int getPrice() { // 価格を取得
    return price;
  }
}
