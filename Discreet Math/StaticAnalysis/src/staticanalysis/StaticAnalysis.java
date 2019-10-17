package staticanalysis;

import jdk.nashorn.internal.runtime.regexp.RegExp;

public class StaticAnalysis {

    State state;
    String VSSL;

    public StaticAnalysis(String VSSL) {
        this.state = new State();
        this.VSSL = VSSL;
    }

// DEF X : INTEGER
// IF Y < 10 THEN {
//     LET X = 100
//     }
// LET Y = Y + 10
// IF Y >= 20 THEN {
//     LET X = 4711
//     }
    public void analyseProgram() {
        
        String[] lines = VSSL.split("\n");
        // Ved ikke omd det her giver mening, men så kan man også henvise til linjer før og efter hinanden
        // ved hjælp af i. fx når } er på en linje for sig, så kan man tjekke nogle linjer oppe om der er en linje
        // der slutter med {, så de to linjer ligesom danner et par :-D 
        for (int i = 0; i < lines.length; i++) {
            String VSSLLine = lines[i];
            
            if (VSSLLine.startsWith("DEF")) {
                
            }
            else if (VSSLLine.startsWith("LET")) {
                
            }
            else if (VSSLLine.startsWith("IF")) {
                
            }
            else if ((VSSLLine.startsWith("ELSE"))) {
                
            }
            else if (VSSLLine.startsWith("}")) {
                
            }
            else {
                System.out.println("SYNTAX INCORRECT PUTA!!!");
            }
        }
    }

    private void definitionStatement(String nextVSSLLine) {
        String regex = "(DEF) ([A-Z])* : ((BOOLEAN)|(INTEGER))";
        if (nextVSSLLine.matches(regex)) {
            
            nextVSSLLine = nextVSSLLine.substring(4);
            
            String variableName = nextVSSLLine.split(":")[0];
            variableName = variableName.substring(0, variableName.length() - 1); // remove space between variable and :
            String variableType = nextVSSLLine.split(":")[1];
            variableType = variableType.substring(1); // remove space between : and type
            
            if (variableType.equals("INTEGER"))
                state.defineInteger(variableName, null);
            else
                state.defineBoolean(variableName, null);
        }
    }

    private void assignmentStatement() {

        VSSL = VSSL.substring(VSSL.indexOf("LET") + 4);
        String variableName = VSSL.split("=")[0];
        String variableType = VSSL.split(" ")[1];

    }

    private void ifStatement() {

    }

    private void elseStatement() {

    }

}
