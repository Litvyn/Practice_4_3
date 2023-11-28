package Exercise2;

public class ConsolePrinter implements  Printable{
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
