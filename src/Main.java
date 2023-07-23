public class Main {
    public static void main(String[] args)  {
        try {

            Validator.check("abc_", "rty", "rty");
            System.out.println("Логин завершен!");
        } catch (WrongLoginException e) {
           throw new RuntimeException(e);
        }
    }
}