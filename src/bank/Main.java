package bank;

import bank.DAO.AccountDAOImpl;
import bank.DTO.AccountDTO;
import bank.DTO.UserDTO;
import bank.service.AccountServiceImpl;
import bank.service.exceptions.*;

public class Main {
    public static void main(String[] args)  {
        AccountDAOImpl dao = new AccountDAOImpl();
        AccountServiceImpl demo = new AccountServiceImpl(dao);

        AccountDTO george1 = createDTO(51200,1L,"000000000","0001","Giorgos","Martzoukos",10L);
        AccountDTO eirini = createDTO(1000, 2L,"11111111" , "0002", "Eirini", "Tzanetou", 20L);
        AccountDTO nick = createDTO(2000, 3L,"2222222","0003","Nikos", "Lalos",30L);
        AccountDTO updatedNick = createDTO(20, 3L,"0","0009","Nikos", "Lalos",30L);


        try {

            demo.createAccount(george1);
            demo.createAccount(eirini);
            demo.createAccount(nick);
            demo.withdrawAccount("000000000",9,"0001");
            demo.depositAccount("11111111", 10);

            demo.updateAccount(3L,updatedNick);

            demo.LoanApplication("000000000",10000000);



        } catch ( AccountNotFoundException | InsufficientBalanceException | SsnNotValidException | InsufficientAmountException | IbanAlreadyExistsException | IdAlreadyExistsException e) {
            System.out.println("");
        } catch (LoanDeclinedException ex) {
            System.out.println();
        }

        System.out.println(demo.getAllAccounts());
    }


    /**
     * Create a user and his/her bank account calling this method and completing the values:
     *
     * @param balance
     * @param id
     * @param iban
     * @param ssn
     * @param firstname
     * @param lastname
     * @param uerId
     * @return
     */
    public static AccountDTO createDTO (double balance, Long id, String iban, String ssn, String firstname, String lastname,Long uerId) {
        AccountDTO accountDTO  = new AccountDTO();
        UserDTO userDTO = new UserDTO();

        accountDTO.setId(id);
        accountDTO.setIban(iban);
        accountDTO.setBalance(balance);
        accountDTO.setHolder(userDTO);

        userDTO.setId(uerId);
        userDTO.setFirstname(firstname);
        userDTO.setLastname(lastname);
        userDTO.setSsn(ssn);

        return accountDTO;
    }

}
