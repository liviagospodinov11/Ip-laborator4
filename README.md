# IP - Laborator 4
 
## Studenți
Apostol Alexandru (E2), Benchea Diana (E2), Blendea Delia (A5), Buliga Sarah (E2), Gospodinov Livia (A5), Mărtinaș Dragoș (E2), Trofin Dragoș (E2)

# Person.java

## Scurtă descriere
Această clasă Java hestionează informațiile personale ale unui utilizator. Clasa oferă funcționalități de autentificare și actualizare a parolei, folosind hashing SHA-256 pentru securizarea parolei.

### Atribute:
- `name`: numele persoanei
- `personalIdentificationNumber`: cod numeric personal (CNP)
- `birthDate`: data nașterii
- `username`: nume de utilizator
- `mappedPassword`: parola stocată în format hash (SHA-256)
- `phoneNumber`: număr de telefon
- `email`: adresa de email

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

# Customer.java

## Scurtă descriere
Această clasă Java extinde funcționalitățile clasei `Person`, adăugând atribute și metode specifice pentru gestionarea contului bancar al unui client. Oferă posibilitatea de a vizualiza detalii despre cont, soldul și de a aproba tranzacții bancare.

### Atribute:
- `IBAN`: codul internațional al contului bancar
- `balance`: soldul curent al clientului

### Metode principale:
- `getIBAN()`  
  Returnează IBAN-ul clientului.

- `checkBalances()`  
  Returnează soldul actual al contului.

- `viewAccountDetails()`  
  Afișează detaliile contului (nume, CNP, data nașterii, username, telefon, email, IBAN, sold). Utilizează metodele din clasa părinte `Person` pentru a accesa informațiile personale.

- `approveTransactions(double amount)`
  Simulează aprobarea unei tranzacții. Dacă fondurile sunt suficiente, utilizatorul este întrebat (prin consolă) dacă dorește să aprobe sau să refuze tranzacția. În funcție de răspuns, soldul este actualizat sau tranzacția este anulată.

## Observații
- Clasa `Customer` moștenește toate metodele și atributele de la `Person`, inclusiv mecanismul de autentificare și criptare a parolei (`hashPassword()`).
- Interacțiunea cu utilizatorul pentru aprobarea tranzacțiilor se realizează prin `Scanner` din consola Java.