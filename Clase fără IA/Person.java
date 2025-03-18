import java.time.LocalDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Person {
    private String name;
    private String personalIdentificationNumber;
    private LocalDate birthDate;
    private String username;
    private String mappedPassword;
    private String phoneNumber;
    private String email;

    public Person(String name,
                  String personalIdentificationNumber,
                  LocalDate birthDate,
                  String username,
                  String password,
                  String phoneNumber,
                  String email) {
        this.name = name;
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.birthDate = birthDate;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mappedPassword = hashPassword(password);
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest MD = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = MD.digest(password.getBytes());

            // Convert bytes to hex string
            StringBuilder mappedString = new StringBuilder();
            for (byte b : hashBytes)
                mappedString.append(String.format("%02x", b));

            return mappedString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 algorithm not found.", e);
        }
    }

    public String getName() {
        return name;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public void setBirthDate() {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        if (hashPassword(oldPassword).equals(mappedPassword)) {
            this.mappedPassword = hashPassword(newPassword);
            return true;
        }
        else return false;
    }

    public boolean login(String username, String password) {
        return (this.username.equals(username) && hashPassword(password).equals(mappedPassword));
    }
}