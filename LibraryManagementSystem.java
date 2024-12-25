package com.projects; // The package where the whole project is present.

import java.io.File; // to import build-in "File" class which is present in "io" package.
import java.io.FileNotFoundException; // to import build-in "FileNotFoundException" class which is present in "io" package.
import java.util.Scanner; // to import build-in "Scanner" class which is present in "util" package.
import java.io.IOException; // to import build-in "IOException" class which is present in "io" package.
import java.io.FileWriter; // to import build-in "FileWriter" class which is present in "io" package.
import java.util.Arrays; // to import build-in "Arrays" class which is present in "util" package.
import java.time.LocalDate;  // to import build-in "LocalDate" class which is present in "time" package.

abstract class BookWormLibrary{ // Abstract Class "BookWormLibrary".
    public abstract void introDetails(); // Method-1. Welcome Message of "Bookworm Library".
    public abstract void outroDetails(); // Method-2. Outro Message of "Bookworm Library".
    public abstract void historyOfThisLibrary(); // Method-3. To know the history of this library.
    public abstract int logIn(); // Method-4. To log-in in "Bookworm Library" app.
    public abstract void applyForMembership(); // Method-5. Apply for membership.
    public abstract void listOfBooks(); // Method-6. Books which are present currently in library.
    public abstract void add(); // Method-7. To add books.
    public abstract void receiptOfIssuance(String name , String fatherName , String mobileNumber , String cnicNumber , String username , String memberIs , String[] issuedBooks , String[] issuedBooksGenre , LocalDate newDate); // Method-8. Invoice/Receipt of issued book.
    public abstract void issueBooks(); // Method-9. To issue a books.
    public abstract void borrowedBooks(); // Method-10. Which books are borrowed/issued to whom with due dates.
}

class ImplicationsOfBookWormLibraryFunctions extends BookWormLibrary{ // Class "ImplicationsOfBookWormLibraryFunctions" Which Extends Abstract "BookWormLibrary" Class.
    // Pre-requisites & Additional Methods/Functions
    String[][] booksList1 = {{"Introduction To Java", "Data Structures & Algorithm", "Introduction To CS", "Basics Of SQL"} , {"Jannat Ka Patta", "Fifty Shades Of Grey", "Peer-e-Kamil", "Harry Potter"} , {"Stranger Things", "To Kill a Mockingbird", "The Catcher in the Rye", "The Alchemist"}};
    String[] booksListHeading = {"Technology Books", "Novel Books", "Fiction Books"};
    String[] existAccounts = {"sherwani.hassan@bookworm.lib", "123654", "john.wick@bookworm.lib", "1234@", "dani.paul@bookworm.lib", "69@69", "devillers.ab@bookworm.lib", "@360@"};

    public int accountVerification(String[] array) { // Method For Verification Of Accounts.
        Scanner scan1 = new Scanner(System.in);

        for (int i = 0 ; i < array.length ; i++){
            System.out.print("\nEnter Your Username: ");
            String username = scan1.nextLine();


            System.out.print("Enter Your Password: ");
            String password = scan1.nextLine();

            for (int j = 0 ; j < array.length ; j++){
                if (username.equals(array[j]) && password.equals(array[j+1])){
                    int dotIndex = username.indexOf(".");
                    String directUsername = username.substring(0 , dotIndex);
                    String capitalizeUsername = directUsername.substring(0, 1).toUpperCase() + directUsername.substring(1).toLowerCase();
                    System.out.println("\nWelcome " + capitalizeUsername + "!");
                    return 1;
                }

            }
            int left = 3-i;
            if (left == 0){
                System.out.println("\nSorry, Any Account With Username: \"" + username + "\" Doesn't Exist!\n");
                return 0;
            }
            System.out.println("\nPlease Enter Valid Username And Password You Have Only " + left + " Attempts Left!\n");
        }
        return -1;
    }

    public void introDetails(){ // Method-1. Intro Message of "Bookworm Library".
        System.out.println("\n\t********** Welcome To Bookworm Library **********\n");

        int methodCall = logIn(); // Calling Method-4 To Login.
        if (methodCall == 0){
            outroDetails();
        }
        else if (methodCall == 1){
            int option = -1;

            while (option != 7){
                File introFile = new File("introMessage.txt");
                try {
                    Scanner scan = new Scanner(introFile);
                    while (scan.hasNextLine()){
                        String message = scan.nextLine();
                        System.out.println(message);
                    }
                    scan.close();
                }
                catch (FileNotFoundException exception){
                    System.out.println(exception.getMessage());
                }

                Scanner scan = new Scanner(System.in);
                System.out.print("\nPlease Enter The Respective Number Of Your Desired Option: ");
                option = scan.nextInt();

                if (option == 1){
                    // Method-3. To know the history of this library
                    historyOfThisLibrary();
                }
                else if (option == 2) {
                    // Method-5. Apply for membership.
                    applyForMembership();
                }
                else if (option == 3){
                    // Method-6. Books which are present currently in library.
                    listOfBooks();
                }
                else if (option == 4){
                    // Method-7. To add books.
                    add();
                }
                else if (option == 5){
                    // Method-9. To issue a book.
                    issueBooks();
                }
                else if (option == 6){
                    // Method-10. Which books are borrowed/issued to whom with due dates.
                    borrowedBooks();
                }
                else if (option == 7) {
                    // Method-2. Outro Message of "Bookworm Library".
                    outroDetails();
                }
            }
        }
    }

    public void outroDetails(){ // Method-2. Outro Message of "Bookworm Library".
        File outroFile = new File("outroMessage.txt");
        try {
            Scanner scan = new Scanner(outroFile);
            while (scan.hasNextLine()){
                String message = scan.nextLine();
                System.out.println(message);
            }
            scan.close();
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void historyOfThisLibrary(){ // Method-3. To know the history of this library.
        File historyFile = new File("historyMessage.txt");
        try {
            Scanner scan = new Scanner(historyFile);
            while (scan.hasNextLine()){
                String message = scan.nextLine();
                System.out.println(message);
            }
            scan.close();
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public int logIn(){ // Method-4. To sign up in "Bookworm Library" app.
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Create Account.");
        System.out.println("2. Account Already Exist.");

        System.out.print("\nPlease Enter The Respective Number Of Your Desired Option: ");
        int option = scan.nextInt();

        if (option == 1){ // Create New Account.
            int confirmation = 0;
            String username = null;
            String password = null;
            while (confirmation == 0){
                Scanner scan2 = new Scanner(System.in);

                int goOn = 0;
                while (goOn != 1){
                    Scanner scan3 = new Scanner(System.in);
                    for (int index = 0 ; index < existAccounts.length ; index++){
                        System.out.print("\nEnter Username (e.g: paul.heyman@bookworm.lib): ");
                        username = scan3.nextLine();
                        if (existAccounts[index].equals(username)){
                            System.out.println("This Username Is Already Exists In Our Data, Please Try Something Unique.");
                            goOn = 1;
                        }
                        else {
                            break;
                        }
                    }
                    goOn = 1;
                }

                System.out.print("Enter Password: ");
                password = scan2.nextLine();

                System.out.println("\nConfirm The Following Username & Password: ");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                System.out.print("\nTo Confirm Enter (1) OR To Make Some Changes Enter (0): ");
                confirmation = scan2.nextInt();
            }
            if (confirmation == 1){
                int lengthOfAccounts = existAccounts.length + 2;

                String[] newPlusExistAccounts = new String[lengthOfAccounts];

                for (int i = 0 ; i < existAccounts.length ; i++){
                    newPlusExistAccounts[i] = existAccounts[i];
                }

                newPlusExistAccounts[lengthOfAccounts-2] = username;
                newPlusExistAccounts[lengthOfAccounts-1] = password;

                System.out.println("\nCongrats!, You've Created Your Account.\n");
                System.out.println("Now Enter Your Username And Password Again To Login!");

                return accountVerification(newPlusExistAccounts);
            }
            else if (confirmation != 1){
                System.out.println("\nSorry, You Didn't Obey The Given Guidelines!\n");
                outroDetails();
            }
        }
        else if (option == 2) { // Account Already Exist.
            return accountVerification(existAccounts);
        }
        return -1;
    }

    public void applyForMembership() { // Method-5. Apply for membership.
        int confirmation = 0;
        String name = null;
        String fatherName = null;
        String mobileNumber = null;
        String cnicNumber = null;
        String username = null;
        while (confirmation == 0){
            Scanner scan = new Scanner(System.in);

            System.out.print("\nEnter Your Full Name: ");
            name = scan.nextLine();

            System.out.print("Enter Your Father Name: ");
            fatherName = scan.nextLine();

            System.out.print("Enter Your Registered Mobile Number (Without Zero '0'): +92");
            mobileNumber = scan.nextLine();

            System.out.print("Enter Your CNIC Number (Without Hyphen '-'): ");
            cnicNumber = scan.nextLine();

            System.out.print("Enter Your Username Which You've Created When You Logged-In: ");
            username = scan.nextLine();

            System.out.println("\nConfirm The Following Entities: ");
            System.out.println("Applicant's Name: " + name);
            System.out.println("Applicant's Father Name: " + fatherName);
            System.out.println("Applicant's Mobile Number: +92" + mobileNumber);
            System.out.println("Applicant's CNIC Number: " + cnicNumber);
            System.out.println("Applicant's Username: " + username);

            System.out.print("\nTo Confirm Enter (1) OR To Make Some Changes Enter (0): ");
            confirmation = scan.nextInt();
        }

        File writeMembersInfo = new File("MembersInfo.txt");
        try {
            FileWriter writeInFile = new FileWriter("MembersInfo.txt");
            writeInFile.write("Applicant's Informations\n");
            writeInFile.write("-------------------------------------------------------------------------------------");
            writeInFile.write("\n");
            writeInFile.write("1. Applicant's Name: " + name + "\n");
            writeInFile.write("2. Applicant's Father Name: " + fatherName + "\n");
            writeInFile.write("3. Applicant's Mobile Number: +92" + mobileNumber + "\n");
            writeInFile.write("4. Applicant's CNIC Number: " + cnicNumber + "\n");
            writeInFile.write("5. Applicant's Username: " + username + "\n");
            writeInFile.write("-------------------------------------------------------------------------------------");
            writeInFile.write("\n");
            writeInFile.close();
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println("\nCongrats " + name + " You're Now Member Of Bookworm Library!");
    }

    public void listOfBooks() { // Method-6. Books which are present currently in library.
        // Showing Library's Books From "booksList1" Array With Their Genre From "booksListHeading" Array.
        System.out.println("\nShowing Books-1: \n");
        for (int i = 0; i < booksList1.length; i++) {
            System.out.print(i + " -> " + booksListHeading[i] + " -> ");
            for (int j = 0; j < booksList1[i].length; j++) {
                if (j == booksList1[i].length - 1) {
                    System.out.print(booksList1[i][j]);
                } else {
                    System.out.print(booksList1[i][j] + " - ");
                }
            }
            System.out.println();
        }

        // Showing Library's Books From "BooksList.txt" File With Information Of Addition & Issuing Books.
        System.out.println("\nShowing Books-2:");
        File booksList = new File("booksList.txt");
        try {
            Scanner scan = new Scanner(booksList);
            while (scan.hasNextLine()){
                String list = scan.nextLine();
                System.out.println(list);
            }
            scan.close();
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void add() { // Method-7. To add books.
        // Display the current list of books
        System.out.println("\nCurrent Books List: ");
        displayBooks(booksList1, booksListHeading);

        Scanner scan = new Scanner(System.in);

        System.out.print("\nHow Many Books You Want to Add: ");
        int howManyBooks = scan.nextInt();

        for (int i = 0; i < howManyBooks; i++) {
            Scanner scan1 = new Scanner(System.in);

            System.out.print("\nEnter The Full Name Of Book-" + (i + 1) + " Which You Wanna Add: ");
            String addBook = scan1.nextLine();

            System.out.print("Enter The Genre Number (e.g: 0,1,2) To Add Book In That Genre: ");
            int currentGenreNumber = scan1.nextInt();

            // Validate genre number
            if (currentGenreNumber < 0 || currentGenreNumber >= booksList1.length) {
                System.out.println("Invalid Genre Number, Skipping This Book.");
                continue;
            }

            // Add book dynamically by resizing the array
            booksList1[currentGenreNumber] = addBookToGenre(booksList1[currentGenreNumber], addBook);

            // Write the new book to the file
            String genreInFileName = booksListHeading[currentGenreNumber];
            try {
                FileWriter writeInFile = new FileWriter("booksList.txt", true);
                if (i == 0) {
                    writeInFile.write("\n");
                    writeInFile.write("\n-----------------------------------------------------------------------------");
                    writeInFile.write("\n");
                    writeInFile.write("Addition Of New Books In Bookworm Library:\n");
                }

                writeInFile.write("\n");
                writeInFile.write("-> " + genreInFileName + " -> " + addBook + ".");

                writeInFile.close();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("\n********** Thank You For Adding Books! **********");

        // Display the updated list of books
        System.out.println("\nUpdated Books List: ");
        displayBooks(booksList1, booksListHeading);
    }

    // Method to display all books
    private void displayBooks(String[][] booksList, String[] booksListHeading) {
        for (int i = 0; i < booksList.length; i++) {
            System.out.print(i + " -> " + booksListHeading[i] + " -> ");
            for (int j = 0; j < booksList[i].length; j++) {
                if (j == booksList[i].length - 1) {
                    System.out.print(booksList[i][j]);
                } else {
                    System.out.print(booksList[i][j] + " - ");
                }
            }
            System.out.println();
        }
    }

    // Method to dynamically add a book to a genre
    private String[] addBookToGenre(String[] genreBooks, String newBook) {
        // Create a new array with one extra slot
        String[] updatedGenre = new String[genreBooks.length + 1];
        // Copy existing books to the new array
        System.arraycopy(genreBooks, 0, updatedGenre, 0, genreBooks.length);
        // Add the new book to the last position
        updatedGenre[genreBooks.length] = newBook;
        return updatedGenre;
    }

    public void receiptOfIssuance(String name , String fatherName , String mobileNumber , String cnicNumber , String username , String memberIs , String[] issuedBooks , String[] issuedBooksGenre , LocalDate newDate) { // Method-8. Invoice/Receipt of issued book.
        System.out.println("\n**********************************************************************************************");
        System.out.println("\t\t\t\t\t\t********** Invoice Of Bookworm Library **********");
        System.out.println("\n -> Name: " + name);
        System.out.println(" -> Father's Name: " + fatherName);
        System.out.println(" -> Mobile Number: +92" + mobileNumber);
        System.out.println(" -> CNIC Number: " + cnicNumber);
        System.out.println(" -> Username: " + username);
        System.out.println(" -> Member: " + memberIs);
        System.out.println(" -> Books Which Is Issued: " + Arrays.toString(issuedBooks));
        System.out.println(" -> Genre Of Books Which Is Issued: " + Arrays.toString(issuedBooksGenre));
        System.out.println(" -> Return Date: " + newDate);
        System.out.println(" -> Librarian: Qurat-ul-Ain\n");
        System.out.println("\t\t\t\t********** Thank You For Issuing Book From Bookworm Library **********");
        System.out.println("**********************************************************************************************\n");

        // Write In File
        File writeInfoOfIssuedBookInvoice = new File("issuedBookInvoices.txt");
        try {
            FileWriter writeInFile = new FileWriter("issuedBookInvoices.txt",true);
            writeInFile.write("\n**********************************************************************************************");
            writeInFile.write("\n\t\t\t\t\t\t********** Invoice Of Bookworm Library **********");
            writeInFile.write("\n -> Name: " + name);
            writeInFile.write("\n -> Father's Name: " + fatherName);
            writeInFile.write("\n -> Mobile Number: +92" + mobileNumber);
            writeInFile.write("\n -> CNIC Number: " + cnicNumber);
            writeInFile.write("\n -> Username: " + username);
            writeInFile.write("\n -> Member: " + memberIs);
            writeInFile.write("\n -> Books Which Is Issued: " + Arrays.toString(issuedBooks));
            writeInFile.write("\n -> Genre Of Books Which Is Issued: " + Arrays.toString(issuedBooksGenre));
            writeInFile.write("\n -> Return Date: " + newDate);
            writeInFile.write("\n -> Librarian: Qurat-ul-Ain\n");
            writeInFile.write("\n\t\t\t\t********** Thank You For Issuing Book From Bookworm Library **********");
            writeInFile.write("\n**********************************************************************************************\n");
            writeInFile.close();
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void issueBooks() { // Method-9. To issue a books.
        System.out.println("\n");
        for (int i = 0 ; i < booksList1.length ; i++){
            System.out.print(i + " -> " + booksListHeading[i] + " -> ");
            for (int j = 0 ; j < booksList1[i].length ; j++){
                if (j == (booksList1[i].length-1)){
                    System.out.print(booksList1[i][j]);
                }
                else {
                    System.out.print(booksList1[i][j] + " - ");
                }
            }
            System.out.println();
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("\n********** Before Issuing Books, You Need To Know That The Books Will Be Issued Only For 7 Days! **********\n");

        System.out.print("\nHow Many Books You Wanna Issue: ");
        int howManyBooks = scan.nextInt();

        int confirmation = 0;
        String name = null;
        String fatherName = null;
        String mobileNumber = null;
        String cnicNumber = null;
        String username = null;
        int currentGenreNumber = 0;
        String issuingBook = null;
        int member = -1;
        String genreInFileName = null;
        String[] issuedBooks = new String[howManyBooks];
        String[] issuedBooksGenre = new String[howManyBooks];
        String memberIs = null;
        LocalDate newDate = null;

        while (confirmation == 0){
            Scanner scan1 = new Scanner(System.in);

            for (int i = 0 ; i < howManyBooks ; i++){
                Scanner scan0 = new Scanner(System.in);

                System.out.print("\nEnter The Full Name Of Book-" + (i+1) + " Which You Wanna Take: ");
                issuingBook = scan0.nextLine();

                System.out.print("Enter The Genre Number (e.g: 0,1,2) To Issue Book From That Genre: ");
                currentGenreNumber = scan0.nextInt();

                if (currentGenreNumber == 0){
                    genreInFileName = "Technology Book";
                }
                else if (currentGenreNumber == 1){
                    genreInFileName = "Novel Book";
                }
                else if (currentGenreNumber == 2){
                    genreInFileName = "Fiction Book";
                }

                issuedBooks[i] = issuingBook;
                issuedBooksGenre[i] = genreInFileName;
            }

            System.out.print("\nEnter Your Full Name: ");
            name = scan1.nextLine();

            System.out.print("Enter Your Father Name: ");
            fatherName = scan1.nextLine();

            System.out.print("Enter Your Registered Mobile Number (Without Zero '0'): +92");
            mobileNumber = scan1.nextLine();

            System.out.print("Enter Your CNIC Number (Without Hyphen '-'): ");
            cnicNumber = scan1.nextLine();

            System.out.print("Enter Your Username Which You've Created When You Logged-In: ");
            username = scan1.nextLine();

            System.out.print("Are You A Member Of Bookworm Library If Yes Enter One-(1) OR If No Then Enter Zero-(0): ");
            member = scan1.nextInt();

            if (member == 0){
                memberIs = "NO";
            }
            else if (member == 1){
                memberIs = "YES";
            }


            System.out.println("\nConfirm The Following Entities: ");
            System.out.println("Issuing Book: " + Arrays.toString(issuedBooks));
            System.out.println("Issuing Book Genre: " + Arrays.toString(issuedBooksGenre));
            System.out.println("Name: " + name);
            System.out.println("Father Name: " + fatherName);
            System.out.println("Mobile Number: +92" + mobileNumber);
            System.out.println("CNIC Number: " + cnicNumber);
            System.out.println("Username: " + username);
            System.out.println("Member: " + memberIs);

            // To Import Current Date Also Adding 7 Days More In That Current Date.
            LocalDate currentDate = LocalDate.now(); // For Current Date.
            if (memberIs.equals("YES")){
                newDate = currentDate.plusDays(12); // For New Date.
                System.out.println("Since You're A Member Of \"Bookworm Library\" You Have To Return Back The Books To Library Till: " + newDate);
            }
            else if (memberIs.equals("NO")){
                newDate = currentDate.plusDays(7); // For New Date.
                System.out.println("Since You're Not A Member Of \"Bookworm Library\" You Have To Return Back The Books To Library Till: " + newDate);
            }


            System.out.print("\nTo Confirm Enter (1) OR To Make Some Changes Enter (0): ");
            confirmation = scan1.nextInt();

            for (int times = 0 ; times < howManyBooks ; times++){
                try {
                    FileWriter writeInFile = new FileWriter("booksList.txt" , true);
                    writeInFile.write("\n");
                    writeInFile.write("\n-----------------------------------------------------------------------------\n");
                    writeInFile.write("-> " + issuedBooksGenre[times] + " -> " + issuedBooks[times] + " -> (Issued)");
                    writeInFile.write("\n-----------------------------------------------------------------------------");

                    writeInFile.close();
                }
                catch (IOException exception){
                    System.out.println(exception.getMessage());
                }
            }
        }

        // Deletion Of Issued Books From "booksList1" Array.
        for (int del1 = 0; del1 < booksList1.length; del1++) {
            for (int del2 = 0; del2 < booksList1[del1].length; del2++) {
                for (int i = 0; i < howManyBooks; i++) {
                    if (issuedBooks[i].equals(booksList1[del1][del2])) {
                        booksList1[del1][del2] = "(Book Is Issued)";
                    }
                }
            }
        }

        System.out.println(Arrays.toString(issuedBooks));

        File writeInfoOfIssuedBook = new File("issuedBookInfo.txt");
        try {
            FileWriter writeInFile = new FileWriter("issuedBookInfo.txt",true);
            writeInFile.write("\nInformation Of Issued Books\n");
            writeInFile.write("\n");
            writeInFile.write("1. Issuing Book: " + Arrays.toString(issuedBooks) + "\n");
            writeInFile.write("2. Issuing Book Genre: " + Arrays.toString(issuedBooksGenre) + "\n");
            writeInFile.write("3. Name: " + name + "\n");
            writeInFile.write("4. Father Name: " + fatherName + "\n");
            writeInFile.write("5. Mobile Number: +92" + mobileNumber + "\n");
            writeInFile.write("6. CNIC Number: " + cnicNumber + "\n");
            writeInFile.write("7. Username: " + username + "\n");
            writeInFile.write("8. Member: " + memberIs + "\n");

            LocalDate currentDate = LocalDate.now(); // For Current Date.
            writeInFile.write("9. Date Of Issuing: " + currentDate + "\n");

            if (memberIs.equals("YES")){
                newDate = currentDate.plusDays(12); // For New Date.
                System.out.println("10. Since You're A Member Of \"Bookworm Library\" You Have To Return Back The Books To Library Till: " + newDate);
            }
            else if (memberIs.equals("NO")){
                newDate = currentDate.plusDays(7); // For New Date.
                System.out.println("10. Since You're Not A Member Of \"Bookworm Library\" You Have To Return Back The Books To Library Till: " + newDate);
            }

            writeInFile.write("\n-------------------------------------------------------------------------------------");
            writeInFile.write("\n");
            writeInFile.close();
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }

        receiptOfIssuance(name , fatherName , mobileNumber , cnicNumber , username , memberIs , issuedBooks , issuedBooksGenre , newDate);
    }

    public void borrowedBooks() { // Method-10. Which books are borrowed/issued to whom with due dates.
        File outroFile = new File("issuedBookInvoices.txt");
        try {
            Scanner scan = new Scanner(outroFile);
            if (!scan.hasNextLine()){
                System.out.print("\nNo Book Is Issued Right Now!!\n");
            }
            else {
                while (scan.hasNextLine()){
                    String message = scan.nextLine();
                    System.out.println(message);
                }
            }
            scan.close();
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ImplicationsOfBookWormLibraryFunctions obj = new ImplicationsOfBookWormLibraryFunctions(); // Creating Object Of "ImplicationsOfBookWormLibraryFunctions" Class Which Implicates Abstract "BookWormLibrary" Class's Functions.

          /* Tested Method While Developing These Methods: */
//        obj.introDetails(); // Tested.
//        obj.outroDetails(); // Tested.
//        obj.historyOfThisLibrary(); // Tested.
//        obj.logIn(); // Tested.
//        obj.listOfBooks(); // Tested.
//        obj.applyForMembership(); // Tested.
//        obj.add(); // Tested.
//        obj.issueBooks(); // Tested.
//        obj.receiptOfIssuance(); // Tested In "issueBooks()" Method.
//        obj.borrowedBooks(); // Tested.

          /* Calling The "introDetails()" Method Here To Run Whole Code */
        obj.introDetails();
    }
}
