Main.class: Main.java User.class HomeMenu.class LoginMenu.class CreateAcctMenu.class ProfileScreen.class StatScreen.class SeventhsQuiz.class SuspendedQuiz.class MajorMinorQuiz.class
	 javac -g Main.java
User.class: User.java MajorMinorQuiz.class SuspendedQuiz.class SeventhsQuiz.class
	 javac -g User.java
HomeMenu.class: HomeMenu.java
	 javac -g HomeMenu.java
LoginMenu.class: LoginMenu.java
	 javac -g LoginMenu.java
CreateAcctMenu.class: CreateAcctMenu.java
	 javac -g CreateAcctMenu.java
ProfileScreen.class: ProfileScreen.java SeventhsQuiz.class SuspendedQuiz.class MajorMinorQuiz.class
	 javac -g ProfileScreen.java
StatScreen.class: StatScreen.java
	 javac -g StatScreen.java
SeventhsQuiz.class: SeventhsQuiz.java MajorMinorQuiz.class
	 javac -g SeventhsQuiz.java
SuspendedQuiz.class: SuspendedQuiz.java MajorMinorQuiz.class
	 javac -g SuspendedQuiz.java
MajorMinorQuiz.class: MajorMinorQuiz.java
	 javac -g MajorMinorQuiz.java
clean:
	 rm *.class
run: Main.class
	 java Main
debug: Main.class
	 jdb Main
