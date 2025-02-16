//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Data data = new Data(06,04,2006);
        System.out.println(data.toString());
        System.out.println("Month: "+data.getMonth());
        System.out.println("Day: "+data.getDay());
        System.out.println("Year: "+data.getYear());

    }
}