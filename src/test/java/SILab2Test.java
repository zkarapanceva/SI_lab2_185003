import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class SILab2Test {

    private SILab2 zadaca;
    private ArrayList<String> allUsers;
    private User user;

    @Test
    void TestEveryPath(){

        allUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

        // 1. 1,2,12 -> user == null -> false -> done
        user = null;
        assertFalse(zadaca.function(user, allUsers));

        // 2. 1,3,2,12 -> user.getUsername()==null || user.getEmail()==null || allUsers.contains(user.getUsername()) -> false -> done
        user = new User("user1", "password", null);
        assertFalse(zadaca.function(user, allUsers));

        // 3. 1,3,4,5.1,(5.2,6,8,5.3),10,2,12 -> email doesn't contain "@" -> false -> done
        user = new User("user2", "password", "user2gmail.com");
        assertFalse(zadaca.function(user, allUsers));

        // 4. 1,3,4,5.1,(5.2,6,7,8,5.3),10,2,12 -> email doesn't contain "." -> false -> done
        user = new User("user3", "password", "user3@gmailcom");
        assertFalse(zadaca.function(user, allUsers));

        // 5. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,11,12 -> everything is fine -> true -> done
        user = new User("user1", "password", "user1@gmail.com");
        assertTrue(zadaca.function(user, allUsers));

        //невозможни патеки:
        // 6. 1,3,4,5.1,(5.2,6,8,9,5.3),10,2,12 -> email doesn't contain "@", contains "." -> false -> done //доколку јазел 6 не е исполнет, односно не влезе во јазел 7, тогаш јазел 8 не е исполнет и не може да влезе во јазел 9
        // 7. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,2,12 -> everything is fine -> false -> done //доколку се е во ред(извршени се јазел 7 и 9), по јазел 10 мора да се влезе во јазел 11
        // 8. 1,3,4,5.1,(5.2,6,8,5.3),10,11,12 -> email doesn't contain "@" -> true -> done //доколку јазел 7 не е исполнет, не може да се изврши јазел 11
        // 9. 1,3,4,5.1,(5.2,6,7,8,5.3),10,11,12 -> email doesn't contain "." -> true -> done //доколку јазел 9 не е исполнет, не може да се изврши јазел 11
        // 10. 1,3,4,5.1,(5.2,6,8,5.3),10,11,12 -> email doesn't contain "@" neither "." -> true -> done //доколку јазли 7 и 9 не се исполнети, не може да се изврши јазел 11

    }

    @Test
    void TestMultipleCondition(){

        allUsers = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

        //condition 1 = TTT, condition 2 = T, condition 3 = TT

        // 1. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,11,12 -> everything is fine -> true -> done //condition 4 = TT
        user = new User("user1", "password", "user1@gmail.com");
        assertTrue(zadaca.function(user, allUsers));

        // 2. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,2,12 -> impossible condition 4 under condition 3 //condition 4 = TF
        // 3. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,2,12 -> impossible condition 4 under condition 2 //condition 4 = FX

        //condition 1 = TTT, condition 2 = T, condition 3 = TF

        // 4. 1,3,4,5.1(5.2,6,7,8,5.3),10,11,12 -> impossible condition 4 under condition 3 //condition 4 = TT
        // 5. 1,3,4,5.1(5.2,6,7,8,5.3),10,2,12 -> email doesn't contain "." -> false -> done //condition 4 = TF
        user = new User("user2", "password", "user2@gmailcom");
        assertFalse(zadaca.function(user, allUsers));
        // 6. 1,3,4,5.1(5.2,6,7,8,5.3),10,2,12 -> impossible condition 4 under condition 2 //condition 4 = FX

        //condition 1 = TTT, condition 2 = F, condition 3 = FX

        // 7. 1,3,4,5.1,(5.2,6,8,5.3),10,11,12 -> impossible condition 4 under condition 2 //condition 4 = TT
        // 8. 1,3,4,5.1,(5.2,6,8,5.3),10,2,12 -> impossible condition 4 under condition 2 //condition 4 = TF
        // 9. 1,3,4,5.1,(5.2,6,8,5.3),10,2,12 -> email doesn't contain "@" -> false -> done //condition 4 = FX
        user = new User("user3", "password", "user3gmail.com");
        assertFalse(zadaca.function(user, allUsers));

        //condition 1 = TTF || condition 2 = TFX || condition 2 = FXX
        //сите случаи би биле невозможни односно во сите три случаи за condition 2 (во кои барем едно е false) само едно сценарио е возможно и тоа:

        // 10. 1,3,2,12 -> false -> done
        user = new User(null, "password", null);
        assertFalse(zadaca.function(user, allUsers));
    }
}