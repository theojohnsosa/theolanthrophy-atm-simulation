import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TBC {

    static String boldFont = "\u001B[1m";
    static String italicFont = "\u001B[3m";
    static String resetFont = "\u001B[0m";

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Integer> userAccounts = new ArrayList<Integer>();
    static ArrayList<String> transactionHistory = new ArrayList<String>();
    static int pinInput;
    static int currentPin;
    static double accountBalance = 1000.0;
    static double withdrawAmount;
    static double change;
    static double depositAmount;
    static double loanBalance = 0.0;
    static double loanRequestAmount;
    static double loanPaymentAmount;

    public static void main(String[] args) {
        System.out.println("\n===================================================" + boldFont + "\n          THEOLANTHROPHY BANK CORPORATION" + resetFont + "\n===================================================");
        entry();
    }

    static void entry() {
        do {
            System.out.print("[1] - Login [2] - Create an Account [3] - Cancel \nSelect here: ");
            int entryInput = getIntInput();
            switch (entryInput) {
                case 1 -> login();
                case 2 -> createAccount();
                case 3 -> cancel();
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again.\n" + resetFont);
            }
        } while (true);
    }

    static void login() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                      LOGIN" + resetFont + "\n---------------------------------------------------");
        int loginAttempts = 3;
        while (loginAttempts > 0) {
            System.out.print("Enter PIN: ");
            pinInput = getIntInput();
            if (userAccounts.isEmpty()) {
                System.out.println(italicFont + "\nAccount Not Found. Create an Account.\n" + resetFont);
                entry();
            } else {
                for (int pin : userAccounts) {
                    if (pinInput == pin) {
                        System.out.println(boldFont + "\nAccess Granted" + resetFont);
                        currentPin = pinInput;
                        showMenu();
                    } else {
                        System.out.println(italicFont + "\nIncorrect PIN. Try Again.\n" + resetFont);
                        loginAttempts--;
                    }
                }            
            }
        }
        
        if (loginAttempts == 0) {
            System.out.println(italicFont + "Maximum Attempts Reached." + resetFont);
            System.exit(0);
        }
    }

    static void createAccount() {
        while (true) {
            System.out.println("\n---------------------------------------------------" + boldFont + "\n                  CREATE ACCOUNT" + resetFont + "\n---------------------------------------------------");
            int createAccountAttempts = 3;
            while (createAccountAttempts > 0) {
                System.out.print("Create PIN: ");
                int pinInput = getIntInput();
                System.out.print("Confirm PIN: ");
                int confirmPin = getIntInput();
                if (confirmPin == pinInput) {
                    userAccounts.add(pinInput);
                    System.out.println(boldFont + "\nAccount Created.\n" + resetFont);
                    entry();
                } else {
                    System.out.println(italicFont + "\nEntered PIN Does Not Match. Try Again.\n" + resetFont);
                    createAccountAttempts--;
                }
            }
            
            if (createAccountAttempts == 0) {
                System.out.println(italicFont + "\nMaximum Attempts Reached." + resetFont);
                System.exit(0);
            }
        }
    }

    static void showMenu() {
        System.out.println("\n--------------------------------------------------- \n                 TRANSACTION MENU \n---------------------------------------------------");
        System.out.print("[1] - Check Balance \n[2] - Withdraw \n[3] - Deposit \n[4] - Loan \n[5] - History \n[6] - Cancel \nSelect Transaction: ");
        int transactionInput = getIntInput();
        switch (transactionInput) {
            case 1 -> viewBalance();
            case 2 -> withdraw();
            case 3 -> deposit();
            case 4 -> loan();
            case 5 -> viewTransactionHistory();
            case 6 -> cancel();
            default -> {
                System.out.println(italicFont + "\nInvalid Trnsaction." + resetFont);
                System.exit(0);
            }
        }
    }

    static void viewBalance() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                  ACCOUNT BALANCE" +  resetFont + "\n---------------------------------------------------");
        System.out.println(boldFont + "Current Account Balance: " + accountBalance + resetFont);
        anotherTransaction();
    }

    static void withdraw() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                     WITHDRAW" + resetFont + "\n---------------------------------------------------");
        System.out.println(boldFont + "Current Account Balance: " + accountBalance + resetFont);
        while (true) {
            System.out.println("\nSelect Withdraw Amount: \n-----------------------");
            System.out.print("[1] - 20000.0 \n[2] - 15000.0 \n[3] - 10000.0 \n[4] - 8000.0 \n[5] - 5000.0 \n[6] - 2000.0 \n[7] - 1000.0 \n[8] - Custom Amount \n[9] - Cancel \nSelect here: ");
            int withdrawTransactInput = getIntInput();
            switch (withdrawTransactInput) {
                case 1 -> {
                    withdrawAmount = 20000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 2 -> {
                    withdrawAmount = 15000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 3 -> {
                    withdrawAmount = 10000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 4 -> {
                    withdrawAmount = 8000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 5 -> {
                    withdrawAmount = 5000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 6 -> {
                    withdrawAmount = 2000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 7 -> {
                    withdrawAmount = 1000.0;
                    System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                    performWithdraw();
                }
                case 8 -> {
                    System.out.print("\nEnter Withdraw Amount: ");
                    withdrawAmount = getDoubleInput();
                    if (withdrawAmount <= 50000) {
                        if (withdrawAmount % 100 == 0) {
                            System.out.println("\nWithdrawal Amount of " + withdrawAmount);
                            performWithdraw();
                        } else {
                            System.out.println(italicFont + "\nWe are ONLY accepting multiples of 100." + resetFont);
                        }
                    } else {
                        System.out.println(italicFont + "\nMaximum Withdrawal Amount is ONLY up to 50000.0" + resetFont);
                        System.exit(0);
                    }
                }
                case 9 -> cancel();
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again." + resetFont);
            }
        }
    }

    static void performWithdraw() {
        System.out.print("\nEnter PIN to Confirm: ");
        pinInput = getIntInput();
        if (pinInput == currentPin) {
            if (withdrawAmount > accountBalance) {
                System.out.println(italicFont + "\nInsufficient Funds" + resetFont);
                System.exit(0);
            } else if (withdrawAmount <= accountBalance) {
                accountBalance -= withdrawAmount;
                System.out.println(boldFont + "\nTRANSACTION SUCCESSFUL" + resetFont);
            } else {
                accountBalance -= withdrawAmount;
                System.out.println(boldFont + "\nTRANSACTION SUCCESSFUL" + resetFont);
            }
            System.out.println(boldFont + "Updated Account Balance: " + accountBalance + resetFont);
            recordTransaction("Withdraw: " + withdrawAmount);
        } else {
            System.out.println(italicFont + "\nIncorrect PIN. Transaction Unsuccesful" + resetFont);
            System.exit(0);
        }
        anotherTransaction();
    }

    static void deposit() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                     DEPOSIT" + resetFont + "\n---------------------------------------------------");
        System.out.println(boldFont + "Current Account Balance: " + accountBalance + resetFont);
        while (true) {
            System.out.println("\nSelect Deposit Amount: \n-----------------------");
            System.out.print("[1] - 20000.0 \n[2] - 15000.0 \n[3] - 10000.0 \n[4] - 8000.0 \n[5] - 5000.0 \n[6] - 2000.0 \n[7] - 1000.0 \n[8] - Custom Amount \n[9] - Cancel \nSelect here: ");
            int depositTransactInput = getIntInput();
            switch (depositTransactInput) {
                case 1 -> {
                    depositAmount = 20000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();
                }
                case 2 -> {
                    depositAmount = 15000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();
                }
                case 3 -> {
                    depositAmount = 10000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();;
                }
                case 4 -> {
                    depositAmount = 8000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();
                }
                case 5 -> {
                    depositAmount = 5000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();
                }
                case 6 -> {
                    depositAmount = 2000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();
                }
                case 7 -> {
                    depositAmount = 1000.0;
                    System.out.println("\nDeposit Amount of " + depositAmount);
                    performDeposit();
                }
                case 8 -> {
                    System.out.print("\nEnter Deposit Amount: ");
                    depositAmount = getDoubleInput();
                    if (depositAmount <= 50000) {
                        if (depositAmount % 100 == 0) {
                            System.out.println("\nDeposit Amount of " + depositAmount);
                            performDeposit();
                        } else {
                            System.out.println(italicFont + "\nWe are ONLY accepting multiples of 100." + resetFont);
                        }
                    } else {
                        System.out.println(italicFont + "\nMaximum Deposit Amount is ONLY up to 50000.0" + resetFont);
                        System.exit(0);
                    }
                }
                case 9 -> cancel();
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again." + resetFont);
            }
        }
    }

    static void performDeposit() {
        System.out.print("\nEnter PIN to Confirm: ");
        pinInput = getIntInput();
        if (pinInput == currentPin) {
            accountBalance += depositAmount;
            System.out.println(boldFont + "\nTRANSACTION SUCCESSFUL" + resetFont);
            System.out.println(boldFont + "Updated Account Balance: " + accountBalance + resetFont);
            recordTransaction("Deposit: " + depositAmount);
        } else {
            System.out.println(italicFont + "\nIncorrect PIN. Transaction Unsuccesful" + resetFont);
            System.exit(0);
        }
        anotherTransaction();
    }

    static void loan() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                       LOAN" + resetFont + "\n---------------------------------------------------");
        while (true) {
            System.out.print("Select Loan Transaction: \n[1] - Check Loan Balance \n[2] - Request Loan \n[3] - Pay Loan \n[4] - Cancel \nSelect here: ");
            int loanOption = getIntInput();
            switch (loanOption) {
                case 1 -> viewLoanBalance();
                case 2 -> requestLoan();
                case 3 -> payLoan();
                case 4 -> cancel();
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again." + resetFont);
            }
        }
    }

    static void viewLoanBalance() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                       LOAN" + resetFont + "\n---------------------------------------------------");
        System.out.println(boldFont + "Current Loan Balance: " + loanBalance + resetFont);
        anotherTransaction();
    }

    static void requestLoan() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                  REQUEST LOAN" + resetFont + "\n---------------------------------------------------");
        System.out.print("Request Loan Amount: ");
        loanRequestAmount = getDoubleInput();
        System.out.print("\nEnter PIN to Confirm: ");
        pinInput = getIntInput();
        if (pinInput == currentPin) {
            if (loanRequestAmount <= 50000) {
                loanBalance += loanRequestAmount;
                System.out.println(boldFont + "\nTRANSACTION SUCCESSFUL" + resetFont);
                accountBalance += loanRequestAmount;
                System.out.println(boldFont + "Updated Loan Balance: " + loanBalance + resetFont);
                System.out.println(boldFont + "Updated Account Balance: " + accountBalance + resetFont);
                recordTransaction("Loan Request: " + loanRequestAmount);
            } else {
                System.out.println(italicFont + "\nMaximum Loan Request of 50000" + resetFont);
                System.exit(0);
            }
        } else {
            System.out.println(italicFont + "\nIncorrent PIN. Transaction Unsuccessful" + resetFont);
            System.exit(0);
        }
        anotherTransaction();
    }

    static void payLoan() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                     PAY LOAN" + resetFont + "\n---------------------------------------------------");
        System.out.println(boldFont + "Current Loan Balance: " + loanBalance + resetFont);
        System.out.println(boldFont + "Current Account Balance: " + accountBalance + resetFont);
        System.out.print("\nLoan Payment Amount: ");
        loanPaymentAmount = getDoubleInput();
        System.out.print("\nEnter PIN to Confirm: ");
        pinInput = getIntInput();
        if (pinInput == currentPin) {
            if (loanPaymentAmount >= loanBalance) {
                accountBalance -= loanPaymentAmount;
                change = loanPaymentAmount - loanBalance;
                accountBalance += change;
                loanBalance = 0.0;
            } else {
                loanBalance -= loanPaymentAmount;
                accountBalance -= loanPaymentAmount;
            }
            System.out.println(boldFont + "\nTRANSACTION SUCCESSFUL" + resetFont);
            System.out.println("Change: " + change);
            System.out.println(boldFont + "Updated Loan Balance: " + loanBalance + resetFont);
            System.out.println(boldFont + "Updated Account Balance: " + accountBalance + resetFont);
            recordTransaction("Loan Payment: " + loanPaymentAmount);
        } else {
            System.out.println(boldFont + "\nIncorrect PIN. Transaction Unsuccessful" + resetFont);
            System.exit(0);
        }
    }

    static void viewTransactionHistory() {
        System.out.println("\n---------------------------------------------------" + boldFont + "\n                 TRANSACTION HISTORY" + resetFont + "\n---------------------------------------------------");
        if (transactionHistory.isEmpty()) {
            System.out.println("No Transactions Recorded.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        anotherTransaction();
    }

    static void recordTransaction(String transact) {
        transactionHistory.add(transact);
    }

    static void anotherTransaction() {
        while (true) {
            System.out.print("\nDo you want another transaction? \n[1] - Yes [2] - No \nSelect here: ");
            int anotherTransactionInput = getIntInput();
            switch (anotherTransactionInput) {
                case 1 -> showMenu();
                case 2 -> exit();
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again." + resetFont);
            }
        }
    }

    static void cancel() {
        while (true) {
            System.out.print("\nAre you sure you want to cancel? \n[1] - Yes [2] - No \nSelect here: ");
            int cancelInput = getIntInput();
            switch (cancelInput) {
                case 1 -> exit();
                case 2 -> {
                    System.out.println("\n");
                    entry();
                }
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again.\n" + resetFont);
            }
        }
    }

    static void exit() {
        while (true) {
            System.out.print(boldFont + "\nHow was your experience?" + resetFont + "\n------------------------ \n[1] - Very Good \n[2] - Good \n[3] - Satsifactory \n[4] - Poor \n[5] - Very Poor \n[6] - No Thanks \nSelect here: ");
            int rating = getIntInput();
            switch (rating) {
                case 1, 2, 3, 4, 5, 6 -> {
                    System.out.println("\n======================================================" + boldFont + "\nTHANK YOU FOR CHOOSING THEOLANTHROPHY BANK CORPORATION" + resetFont + "\n======================================================");
                    System.exit(0);
                }
                default -> System.out.println(italicFont + "\nInvalid Option. Try Again." + resetFont);
            }
        }
    }

    static int getIntInput() {
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(italicFont + boldFont + "\nERROR: Incompatible Data Types." + resetFont);
            System.exit(0);
            return getIntInput();
        }
    }

    static double getDoubleInput() {
        try {
            return scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(italicFont + boldFont + "\nERROR: Incompatible Data Types." + resetFont);
            System.exit(0);
            return getDoubleInput();
        }

    }
}