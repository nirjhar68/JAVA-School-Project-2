
import java.util.*;

public class BankB {
    //Define the static variables
    static final int bankID = 0;
    static final int loanAmount = 1;
    //three dimentional array
    static double[][][] banks;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Number of banks: ");
        int n = input.nextInt();
        System.out.print("Enter minimum limit: ");
        int limit = input.nextInt();
        banks = new double[n][][];
        System.out.print("Enter the banking information according to the fields below: \n");
        System.out.print("NOTE: You should hit space after entering a field until the end of the required fields.\n");
        System.out.println("Bank #  -> Balance: -> Number of banks Loaned: -> Bank ID: -> Amount: -> Bank ID: -> Amount: -> ...");

        for (int i = 0; i < banks.length; i++) {
            System.out.print("Bank #" + i + " -> ");
            double balance = input.nextDouble();
            int numBanks = input.nextInt();
            banks[i] = new double[++numBanks][2];
            banks[i][0][0] = balance;
            for (int bank = 1; bank < banks[i].length; bank++) {
                banks[i][bank][bankID] = input.nextInt();
                banks[i][bank][loanAmount] = input.nextDouble();
            }
        }
        System.out.println("");
        displayMatrix(banks);
        boolean[] unsafeIndex = scanBanks(banks, limit);
        //Define list of integer type
        List<Integer> unsafeList = new ArrayList<Integer>();
        for (int i = 0; i < unsafeIndex.length; i++) {
            if (unsafeIndex[i] == true) {
                unsafeList.add(i);
                System.out.println("Bank# " + i + ": unsafe");
            } else {
                System.out.println("Bank# " + i + ": safe");
            }
        }

        if (unsafeList.size() == 0) {
            System.out.println("All banks are safe");
        } else if (unsafeList.size() == 1) {
            System.out.print("The only unsafe bank is Bank " + unsafeList.get(0));
        }
        else {
            System.out.print("***** Unsafe banks are");
            for (int j = 0; j < unsafeList.size(); j++) {
                System.out.print(" Bank " + unsafeList.get(j));
                if (j < unsafeList.size()-1) {
                    System.out.print(" and");
                }
            }
            System.out.print(" *****");
        }

        input.close();
    }

    public static boolean[] scanBanks(double[][][] m, int limit) {

        boolean[] indexUnsafeBanks = new boolean[m.length];
        double total;
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int banks = 0; banks < m.length; banks++) {
                total = m[banks][0][0];
                for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
                    int index = (int)m[banks][LoanedBanks][bankID];
                    if (!indexUnsafeBanks[index])
                        total += m[banks][LoanedBanks][loanAmount];
                }
                if (total < limit && !indexUnsafeBanks[banks]) {
                    indexUnsafeBanks[banks] = true;
                    flag = false;
                }
            }
        }
        return indexUnsafeBanks;
    }

    public static void displayMatrix(double[][][] m) {

        System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n",
                "Bank #|", "Balance $|", "Loaned #|", "Bank ID|", "Amount $|", "Bank ID|", "Amount $|");
        for (int banks = 0; banks < m.length; banks++) {
            System.out.printf("%-6d|%9.2f|%8d|", banks, m[banks][0][0], m[banks].length -1);

            for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
                System.out.printf("%7.0f|%8.2f|", m[banks][LoanedBanks][bankID], m[banks][LoanedBanks][loanAmount]);
            }
            System.out.println("");
        }
    }
}