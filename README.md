# Втора лабораториска вежба по Софтверско инженерство

## Зорица Карапанчева, бр. на индекс 185003

### Група на код: 1

Ја добив групата на код 1

###  Control Flow Graph

![alt text](185003%20-%20Control%20Flow%20Graph.pdf)

### Цикломатска комплексност

Цикломатската комплексност на овој код е 7, истата ја добив преку формулата E-N+2, каде што N е бројот на јазли, E претставува бројот на ребра. Во случајoв Е = 19, N = 14, па цикломатската комплексност изнесува 7.

### Тест случаи според критериумот  Every path

1. 1,2,12 -> user == null -> false -> done

2. 1,3,2,12 -> user.getUsername()==null || user.getEmail()==null || allUsers.contains(user.getUsername()) -> false -> done

3. 1,3,4,5.1,(5.2,6,8,5.3),10,2,12 -> email doesn't contain "@" -> false -> done

//доколку нема "@", не проверува дали има "."

4. 1,3,4,5.1,(5.2,6,7,8,5.3),10,2,12 -> email doesn't contain "." -> false -> done

5. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,11,12 -> everything is fine -> true -> done

//невозможни патеки:

6. 1,3,4,5.1,(5.2,6,8,9,5.3),10,2,12 -> email doesn't contain "@", contains "." -> false -> done //доколку јазел 6 не е исполнет, односно не влезе во јазел 7, тогаш јазел 8 не е исполнет и не може да влезе во јазел 9

7. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,2,12 -> everything is fine -> false -> done //доколку се е во ред(извршени се јазел 7 и 9), по јазел 10 мора да се влезе во јазел 11

8. 1,3,4,5.1,(5.2,6,8,5.3),10,11,12 -> email doesn't contain "@" -> true -> done //доколку јазел 7 не е исполнет, не може да се изврши јазел 11

9. 1,3,4,5.1,(5.2,6,7,8,5.3),10,11,12 -> email doesn't contain "." -> true -> done //доколку јазел 9 не е исполнет, не може да се изврши јазел 11

10. 1,3,4,5.1,(5.2,6,8,5.3),10,11,12 -> email doesn't contain "@" neither "." -> true -> done //доколку јазли 7 и 9 не се исполнети, не може да се изврши јазел 11

### Тест случаи според критериумот Multiple Conditions

//condition 1 = TTT, condition 2 = T, condition 3 = TT

1. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,11,12 -> everything is fine -> true -> done //condition 4 = TT

2. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,2,12 -> impossible condition 4 under condition 3 //condition 4 = TF

3. 1,3,4,5.1,(5.2,6,7,8,9,5.3),10,2,12 -> impossible condition 4 under condition 2 //condition 4 = FX



//condition 1 = TTT, condition 2 = T, condition 3 = TF

4. 1,3,4,5.1(5.2,6,7,8,5.3),10,11,12 -> impossible condition 4 under condition 3 //condition 4 = TT

5. 1,3,4,5.1(5.2,6,7,8,5.3),10,2,12 -> email doesn't contain "." -> false -> done //condition 4 = TF

6. 1,3,4,5.1(5.2,6,7,8,5.3),10,2,12 -> impossible condition 4 under condition 2 //condition 4 = FX



//condition 1 = TTT, condition 2 = F, condition 3 = FX

7. 1,3,4,5.1,(5.2,6,8,5.3),10,11,12 -> impossible condition 4 under condition 2 //condition 4 = TT

8. 1,3,4,5.1,(5.2,6,8,5.3),10,2,12 -> impossible condition 4 under condition 2 //condition 4 = TF

9. 1,3,4,5.1,(5.2,6,8,5.3),10,2,12 -> email doesn't contain "@" -> false -> done //condition 4 = FX



//condition 1 = TTF || condition 2 = TFX || condition 2 = FXX

//сите случаи би биле невозможни односно во сите три случаи за condition 2 (во кои барем едно е false) само едно сценарио е возможно и тоа:

10. 1,3,2,12 -> false -> done

### Објаснување на напишаните unit tests

Во мојата вежба, јас имав да одредувам случаи според Every Path и Multiple Conditions. Unit тестовите за мојата класа ги напишав според наведените тест случаи во соодветните горенаведени сегменти. При дефинирање на unit тестовите, најпрво се декларира листа од корисници и потоа за секој наведен тест случај се определува user според потребните барања за дадениот тест и потоа со помош на assert се одредува дали функцијата од зададениот user ја задоволува вредноста која е предефинирана со системот по извршување на таков случај. Сите случаи кои треба да се исполнат со користење на системот се наведени заедно со соодветната крајна вредност која очекуваме да ја добиеме, односно со овие unit тестови и предефинирани вредности таргетираме специфичен дел од кодот кој сакаме да го тестираме. 
