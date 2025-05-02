import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;



public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 

        System.out.println("Entre com os dados do aluguel:");
        System.out.println("Modelo do Carro: ");
        String carModel = scanner.nextLine();

        System.out.println("Retirada (dd/MM/yyyy hh:MM): ");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), fmt);

        System.out.println("Retorno (dd/MM/yyyy hh:MM): ");
        LocalDateTime finish = LocalDateTime.parse(scanner.nextLine(), fmt);

        CarRental car = new CarRental(start, finish, new Vehicle(carModel));

        System.out.println("Entre com o preço por hora: ");
        double pricePerhora = scanner.nextDouble();
        System.out.println("Entre com o preço por dia: ");
        double pricePerDay = scanner.nextDouble();

        RentalService rentalService = new RentalService(pricePerhora, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(car); 

        System.out.println("FATURA:");
        System.out.println("Pagamento Básico: " + String.format("%.2f", car.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f",car.getInvoice().getTax()));
        System.out.println("Pagamento Total: " + String.format("%.2f",car.getInvoice().getTotalPasyment()));

        scanner.close();
        /*
         * Saída:
         *  Entre com os dados do aluguel:
            Modelo do Carro: 
            Golf SportLine
            Retirada (dd/MM/yyyy hh:MM): 
            12/08/2024 10:00
            Retorno (dd/MM/yyyy hh:MM): 
            13/08/2024 18:00
            Entre com o preço por hora: 
            10.0
            Entre com o preço por dia: 
            130.0
            FATURA:
            Pagamento Básico: 50.00
            Imposto: 10.00
            Pagamento Total: 40.00
         */
    }
}
