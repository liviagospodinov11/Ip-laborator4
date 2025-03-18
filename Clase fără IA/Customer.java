import java.util.Scanner;
import java.time.LocalDate;

public class Customer extends Person {
    private String IBAN;
    private double balance;

    public Customer(String name,
                  String personalIdentificationNumber,
                  LocalDate birthDate,
                  String username,
                  String password,
                  String phoneNumber,
                  String email,
                  String IBAN,
                  double balance) {
        super(name, personalIdentificationNumber, birthDate, username, password, phoneNumber, email);
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double checkBalances() {
        return balance;
    }

    public String viewAccountDetails() {
        StringBuilder accountDetails = new StringBuilder();
        accountDetails.append("Name: " + getName() + "\n");
        accountDetails.append("CNP: " + getPersonalIdentificationNumber() + "\n");
        accountDetails.append("BirthDate " + getBirthDate() + "\n");
        accountDetails.append("Username " + getUsername() + "\n");
        accountDetails.append("Phone Number: " + getPhoneNumber() + "\n");
        accountDetails.append("Email Address: " + getEmail() + "\n");
        accountDetails.append("IBAN: " + getIBAN() + "\n");
        accountDetails.append("Balance: " + String.format("%.2f", balance) + " lei\n");
        return accountDetails.toString();
    }

    public void approveTransactions(double amount) {
        if (checkBalances() >= amount) {
            Scanner in = new Scanner(System.in);
            System.out.printf("Aprobi tranzactia in valoare de %.2f [DA/NU]: ", amount);

            String response = in.nextLine().trim().toLowerCase();

            if (response.equals("da")) {
                System.out.printf("Tranzactia dumneavoastra de %.2f lei a fost aprobata.\n", amount);
                balance = balance - amount;
            }
            else if (response.equals("nu"))
                System.out.printf("Tranzactia dumneavoastra de %.2f lei a fost respinsa. Motiv: Tranzactie refuzata.\n", amount);
            else
                System.out.printf("Raspuns invalid.");
        }
        else
            System.out.printf("Tranzactia dumneavoastra de %.2f lei a fost respinsa. Motiv: Fonduri insuficiente.\n", amount);
    }
}