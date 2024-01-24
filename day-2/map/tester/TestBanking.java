package tester;

import static utils.BankUtils.populateMap;
import static utils.BankValidations.validateAllInputs;

import java.util.Map;
import java.util.Scanner;

import com.banking.AcctType;
import com.banking.BankAccount;

import custom_exceptions.BankingException;

public class TestBanking {

	public static void main(String[] args) throws BankingException {
		try (Scanner sc = new Scanner(System.in)) {
			// get populated map from utils
			Map<Integer, BankAccount> acctMap = populateMap();

			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Create A/C 2. Display all accounts 3. Transfer Funds "
						+ "4.Close A/c 5. Fetch A/c Summary 6.Freeze A/cs  0.Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter acct details :  acctNo,  customerName,  type,  balance,  createdOn(yr-mon-day)");
						BankAccount account = validateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), acctMap);
						acctMap.put(account.getAcctNo(), account);
						System.out.println("new a/c created....");
						break;

					case 2:// display acct details (admin)
						System.out.println("Accts in the bank : ");
						for (BankAccount a : acctMap.values())
							System.out.println(a);
						break;
					case 3: // fund transfer (customer)
						System.out.println("Enter src a/c no , dest a/c no n transfer amount");
						// get src a/c
						BankAccount src = acctMap.get(sc.nextInt());
						if (src == null)
							throw new BankingException("Invalid src acct no!!!!!!!!!!!");
						BankAccount dest = acctMap.get(sc.nextInt());
						if (dest == null)
							throw new BankingException("Invalid dest acct no!!!!!!!!!!!");
						// transfer the funds
						src.transferFunds(dest, sc.nextDouble());
						System.out.println("funds transferred.....");
						break;
					case 4:
						System.out.println("Enter a/c no , to close the a/c");
						account = acctMap.remove(sc.nextInt());
						if (account == null)
							throw new BankingException("Invalid  acct no, Can't close A/c !!!!!!");
						System.out.println("Closed " + account);
						break;
					case 5:
						System.out.println("Enter your Account number");
						account = acctMap.get(sc.nextInt());
						if (account != null)
							if (account.isActive())
								System.out.println("acount summary" + account);
							else
								throw new BankingException(
										account.getAcctNo() + "inactive Account!!! Active your account");
						else
							System.out.println("Account no is Invalid");
						break;
					case 6:
						System.out.println("Enter account type");
						AcctType type = AcctType.valueOf(sc.next().toUpperCase());
						for (BankAccount a:acctMap.values())
							if(a.getType()==type)
								System.out.println(a);
						break;
					case 7:
						System.out.println("Enter rate n time period");
//						System.out.println(simpleinterest(sc.nextInt(),sc.nextInt()));
//						AcctType[] type1 = AcctType.values();
						for (BankAccount a: acctMap.values()) {
//							if(AcctType.values().equals("SAVING"))
//								a.simpleinterest(10,2);
						for(AcctType i:AcctType.values())
							if(i.equals("SAVING"))
								a.simpleinterest(10,2);
						}
						
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
