# MERCHANT'S GUIDE TO THE GALAXY 

This is a JAVA challenge project using Eclipse as IDE, if you want to use another please remove the files/folders not supported. 

### Prerequisites
- [JDK 1.8]
- [Eclipse]
- [Maven]

### How to run 

  - Install Eclipse.
  - Import/Open the project on Eclipse. 
  - In order to verify project's compile please open command prompt in the root project's path and put mvn clean install
		(No test) mvn clean install -Dmaven.test.skip=true
  
###IMPORTANT!
  - There is a file "units.txt" in the project's resources  used to test the application, please, if you want to chose another please change the value for the properties in the Constants java file. 
  
  By default  Constant.java contains
  		- PATH_FILE:/home/marcelo/eclipse-workspace/merchant-java/src/main/resources/
  		- FILENAME:units.txt

  - If you want to change the content of units.txt with the next conditions
  
  	- INPUT STRUCTURE: This application has been developed ALWAYS with the next structure  "UNIT_NAME" IS "UNIT_VALUE"
  		- Do not put ?/CREDITS/Credits/credits  like the last word
  		- If we have the word "HOW/How/how" inside a "UNIT_NAME" the applications will take as an input line request and the value to convert will be since  "IS" word to the end.
  	
  		Examples: 
  		glob is I
		prok is V
		pish is X
		tegj is L
		glob glob Silver is 34
		glob prok Gold is 57800
		pish pish Iron is 3910
		how much is pish tegj glob glob
		how many Credits is glob prok Silver
		how many Credits is glob prok Gold
		how many Credits is glob prok Iron
		how much wood could a woodchuck chuck if a woodchuck could chuck wood