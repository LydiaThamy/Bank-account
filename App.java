package sg.edu.nus.iss;

import java.util.Random;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BankAccount lydAccount = new BankAccount("Lydia Tham", "001-001-0001", (float)300);
        // casting an integer as a float

        System.out.println(lydAccount.toString());

        lydAccount.deposit((float)100);
        System.out.println(lydAccount.toString());

        lydAccount.withdraw((float)200);
        System.out.println(lydAccount.toString());
        
        // get transaction details
        for(String details: lydAccount.getTransactions()) {
            System.out.println(details);
        }

        //to generate 5 bank accounts with different balances
        int n = 5;
        BankAccount[] account = new BankAccount[n];

        for (int i = 0; i < account.length; i++) {
            String uuid = UUID.randomUUID().toString();

            float min = (float)1000;
            float max = (float)100000;

            Random randomNum = new Random();
            float initialBalance = min + randomNum.nextFloat();

            account[i] = new BankAccount("Employee " + String.valueOf(i), uuid, initialBalance);
        }

        //close account
        lydAccount.setClosed(true);
    }
}
