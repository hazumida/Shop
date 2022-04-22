ПРИМЕРЫ РЕАЛИЗАЦИИ СВОЙСТВ ХОРОШЕГО КОДА

1. Магические числа:

   Объявление и их использование:
```java
        private final int min = 1;
        private final int max = 5;
```
```java
       if (rating <= max && rating >= min) {}
```
2. DRY:
```java
        switch (choiceType) {
          case "1":
              if (transaction.pay(myUser.getMoney(), 950, myUser)) {
                  shop.getGameZoneVR().status();
              }
              break;
          case "2":
              if (transaction.pay(myUser.getMoney(), 500, myUser)) {
                  shop.getGameZonePhoto().status();
              }
              break;
          case "3":
             if (transaction.pay(myUser.getMoney(), 370, myUser)) {
                 shop.getGameZonePCGaming().status();
             }
             break;
          default:
             return;
        }        
```
3. SOLID:
   1. Single responsibility
   - Product - товар как единица каталога магазина
   - Products - список товаров
   - User - как клиент
   - Users - как список клиентов
   2. Liskov substitution
   - Нет в коде не логических наследников
   3. Interface segregation
   - Интерфейс (GameZone) имеет 2 функции, при которых могут существовать отдельно, не нагружая один интерфейс
   4. Dependency inversion
   - благодаря интерфейсу MyUser, пользователь может оплачивать и поплнять кошелек не обращаясь напрямую к классам 