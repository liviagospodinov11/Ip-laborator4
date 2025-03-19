# IP - Laborator 4
 
## Studenți
Apostol Alexandru (E2), Benchea Diana (E2), Blendea Delia (A5), Buliga Sarah (E2), Gospodinov Livia (A5), Mărtinaș Dragoș (E2), Trofin Dragoș (E2)

# Person.java (Blendea Delia, Gospodinov Livia)

### Metode principale:
- `hashPassword(String password)`  
  Metodă statică ce criptează parola folosind algoritmul SHA-256 și returnează un șir hexazecimal. Se folosește atât la crearea contului, cât și la autentificare sau schimbarea parolei.

- `login(String username, String password)`  
  Verifică dacă username-ul și parola (după hash) sunt corecte.

- `setPassword(String oldPassword, String newPassword)`  
  Permite schimbarea parolei doar dacă parola veche este validă.

- Gettere și settere pentru accesarea și modificarea datelor personale (`getName()`, `setEmail()`, etc.).

## Observații
Funcția `hashPassword` este esențială pentru securizarea parolei, prevenind stocarea acesteia în clar; algoritmul utilizat este SHA-256.

# Customer.java (Blendea Delia, Gospodinov Livia)

### Metode principale:
- `getIBAN()`  
  Returnează IBAN-ul clientului.

- `checkBalances()`  
  Returnează soldul actual al contului.

- `viewAccountDetails()`  
  Afișează detaliile contului (nume, CNP, data nașterii, username, telefon, email, IBAN, sold). Utilizează metodele din clasa părinte `Person` pentru a accesa informațiile personale.

- `approveTransactions(double amount)`
  Simulează aprobarea unei tranzacții. Dacă fondurile sunt suficiente, utilizatorul este întrebat (prin consolă) dacă dorește să aprobe sau să refuze tranzacția. În funcție de răspuns, soldul este actualizat sau tranzacția este anulată.
  
# Admin.java (Buliga Sarah, Mărtinaș Dragoș)

### Metode principale:
- `createUser(String name, String personalIdentificationNumber, LocalDate birthDate, String username, String password, String phoneNumber, String email)`  
  Creează un nou utilizator (`Person`) cu detaliile furnizate și afișează un mesaj de confirmare.

- `deleteUser(Person user)`  
  Șterge un utilizator specificat și afișează un mesaj de confirmare.

- `modifyUser(Person user, String newUsername, String newPhoneNumber, String newEmail)`  
  Permite modificarea informațiilor unui utilizator, inclusiv username, număr de telefon și email.

- `performMaintenance()`  
  Efectuează o mentenanță de sistem și afișează un mesaj corespunzător.

- `checkLargeTransaction(double amount)`  
  Verifică dacă o tranzacție depășește pragul de 10.000 de lei și o marchează pentru revizuire dacă este cazul.

- `overseeAIResponses()`  
  Supraveghează răspunsurile generate de asistentul AI pentru a verifica acuratețea acestora.

- `updateAITrainingData()`  
  Actualizează datele de antrenament pentru asistentul AI cu ultimele reglementări și modelele de detectare a fraudelor.
  
# AIAssistant.java (Buliga Sarah, Mărtinaș Dragoș)

### Metode principale:
- `analyzeInquiry(String inquiry)`  
  Analizează întrebarea clientului și redirecționează către metode specializate (deschidere cont, solicitare card, informații despre credite). Dacă întrebarea nu este recunoscută, va marca mesajul pentru verificare.

- `handleAccountOpening()`  
  Gestionează procesul de colectare a datelor pentru deschiderea unui cont bancar (nume și tipul de cont).

- `handleCardInquiry()`  
  Gestionează cererile pentru emiterea unui card nou sau pentru suport în legătură cu un card existent.

- `requiresVerification()`  
  Returnează `true` dacă ultima întrebare necesită verificare manuală.

- `learnFromCorrection(String correctedResponse)`  
  Permite corectarea răspunsului de către un operator uman și resetează flag-ul de verificare.

- `getLastResponse()`  
  Returnează ultimul răspuns generat de asistent.

## C4 Model au fost realizate de Apostol Alexandru, Benchea Diana și Trofin Dragoș.
