public class Main {

    public static void main(String[] args) {
        Todos todos = new Todos()
                .addPrimary("Поработать")
                .addSecondary("Побегать")
                .addPrimary("Попроверять дз")
                .addPrimary("Провести вебинар");

        for (String todo: todos) {
            System.out.println("- " + todo);
        }
    }
}
