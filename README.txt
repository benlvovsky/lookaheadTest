To run from copmmand prompt issue a command like below:
java -classpath lookahead-0.0.1-SNAPSHOT.jar au.com.lookahead.RobotRun
NOTE: make sure jar file is in your classpath

The program uses standard in and can use redirected file testdata.txt I supplied.
Please note that testdata.txt is a limited way of testing as it expects one session of robot running and doesn't cover all code.
Please see more coverage in unit tests (see corbetura reports).

You can use it this way also from project directory:
java -classpath target/lookahead-0.0.1-SNAPSHOT.jar au.com.lookahead.RobotRun < testdata.txt

The output should be like below:

Invalid Positioning in command "PLACE 5,6,NORTH"
Wrong FACING. Allowed FACING are: "[Ljava.lang.String;@696e59da"
Wrong command format "SHMACE 0,0,NORTH"
Wrong command format "PLACE 0 0,NORTH"
Wrong PLACE format. Has to be comadelimited 3 parameters "PLACE 0,0,0,NORTH"
Wrong PLACE Integer format. First 2 arguments have to be integers "PLACE l,0,NORTH"
Robot not placed or directed
Wrong command format "GO"
Wrong command format "REPORT ALL"
Output: 0,1,NORTH
Output: 3,3,NORTH
Output: 0,0,EAST
Output: 1,1,NORTH
Output: 0,1,WEST
Invalid Positioning in command "MOVE"
Output: 0,0,SOUTH

For corbertura site reporting use "mvn clean cobertura:clean cobertura:cobertura", then open in Web browser target/site/cobertura/index.html
To package jar file with tests use "mvn clean compile test package"
