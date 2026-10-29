package service; 
public class ConsoleUtils {
    
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}