STEP C1 - Account Activities

The project is separated so each activity can be evaluated independently.

Activity1
- Account.java
- TestAccount.java

Activity2
- Account.java
- TestAccount.java

Activity3
- AccountEnhanced.java
- TestAccountEnhanced.java

Activity4
- AccountEnhanced.java
- TestAccountEnhanced.java

Activity5
- Account.java
- AccountException.java
- InvalidAmountException.java
- InsufficientBalanceException.java
- MinimumBalanceViolationException.java
- InactiveAccountException.java
- InvalidPinException.java
- TestAccountExceptions.java

Each activity folder is self-contained.

Compile an activity from inside its folder. For example:

cd src/Activity1
javac *.java
java TestAccount

For Activity5:

cd src/Activity5
javac *.java
java TestAccountExceptions
