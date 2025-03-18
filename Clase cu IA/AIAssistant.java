import java.util.Scanner;

public class AIAssistant {
    private String lastResponse;
    private boolean needsVerification;
    private Scanner scanner;

    public AIAssistant() {
        this.lastResponse = "";
        this.needsVerification = false;
        this.scanner = new Scanner(System.in);
    }

    // Method to analyze customer inquiries
    public String analyzeInquiry(String inquiry) {
        if (inquiry.toLowerCase().contains("open account")) {
            return handleAccountOpening();
        } else if (inquiry.toLowerCase().contains("card")) {
            return handleCardInquiry();
        } else if (inquiry.toLowerCase().contains("loan")) {
            lastResponse = "You can apply for a loan via our website or mobile app. Do you need help with the process?";
        } else {
            lastResponse = "I will forward your question to a bank assistant for verification.";
            needsVerification = true;
        }
        return lastResponse;
    }

    // Handle account opening inquiry
    private String handleAccountOpening() {
        System.out.print("Please enter your full name: ");
        String name = scanner.nextLine();
        System.out.print("What type of account would you like to open (Savings/Checking)? ");
        String accountType = scanner.nextLine();

        lastResponse = "Thank you, " + name + ". A " + accountType + " account request has been submitted.";
        return lastResponse;
    }

    // Handle card inquiry
    private String handleCardInquiry() {
        System.out.print("Do you need a new card or do you have an existing one? (new/existing): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("new")) {
            System.out.print("Please enter your full name: ");
            String name = scanner.nextLine();
            System.out.print("Please enter your phone number: ");
            String phoneNumber = scanner.nextLine();
            lastResponse = "Thank you, " + name + ". Your new card request has been submitted. We will contact you at " + phoneNumber + ".";
        } else if (choice.equals("existing")) {
            System.out.print("Please enter your card number: ");
            String cardNumber = scanner.nextLine();
            lastResponse = "Your existing card ending in " + cardNumber.substring(cardNumber.length() - 4) + " is being processed. How can we assist you further?";
        } else {
            lastResponse = "Invalid choice. Please type 'new' or 'existing'.";
        }
        return lastResponse;
    }

    // Method to send response for verification if needed
    public boolean requiresVerification() {
        return needsVerification;
    }

    // Method to receive and apply corrections from the bank assistant
    public void learnFromCorrection(String correctedResponse) {
        this.lastResponse = correctedResponse;
        this.needsVerification = false;
    }

    // Method to retrieve the last response
    public String getLastResponse() {
        return lastResponse;
    }
}