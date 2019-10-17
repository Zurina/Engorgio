package staticanalysis;

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

            } else if (VSSLLine.startsWith("LET")) {

            } else if (VSSLLine.startsWith("IF")) {

            } else if ((VSSLLine.startsWith("ELSE"))) {

            } else if (VSSLLine.startsWith("}")) {

            } else {
                System.out.println("SYNTAX INCORRECT PUTA!!!");
            }
        }
    }

    private void statement(String nextVSSLLine, String assigningToVar) {
        // Y + 10
        String[] statementParts = nextVSSLLine.split(" ");

        // If first part of statement is a variable
        if (statementParts[0].matches("[A-Z]*")) {
            String variableName = statementParts[0];
            // if the variable matches the one being assigned
            if (variableName.equalsIgnoreCase(assigningToVar)) {
                // check if already exists as bool
                if (state.booleans.get(variableName) != null) {

                    // check if already exists as int
                } else if (state.integers.get(variableName) != null) {
                    // get values and calculate new var value for state
                    int firstOprand = state.getValueOfIntVariable(variableName) != null ? state.getValueOfIntVariable(variableName) : 0;
                    String operator = statementParts[1];
                    int secondOprand = Integer.parseInt(statementParts[2]);
                    int newVarValue = this.calculateInteger(firstOprand, operator, secondOprand);
                    state.putInteger(variableName, newVarValue);
                }

            } else {

            }
        } // if first part of statement is a number / constant
        else if (statementParts[0].matches("[0-9]*")) {

        } else {

        }

    }

    private int calculateInteger(int firstOprand, String operator, int secondOprand) {
        int result = 0;
        switch (operator) {
            case "+": {
                result = firstOprand + secondOprand;
            }
            break;
            case "-": {
                result = firstOprand - secondOprand;
            }
            break;
            case "/": {
                result = firstOprand / secondOprand;
            }
            break;
            case "*": {
                result = firstOprand * secondOprand;
            }
            break;
            default:
                result = 0;

        }
        return result;
    }

    private void definitionStatement(String nextVSSLLine) throws Exception {
        String regex = "(DEF) ([A-Z])* : ((BOOLEAN)|(INTEGER))";
        if (nextVSSLLine.matches(regex)) {

            nextVSSLLine = nextVSSLLine.substring(4);

            String variableName = nextVSSLLine.split(":")[0];
            variableName = variableName.substring(0, variableName.length() - 1); // remove space between variable and :
            String variableType = nextVSSLLine.split(":")[1];
            variableType = variableType.substring(1); // remove space between : and type

            if (variableType.equals("INTEGER")) {
                state.defineInteger(variableName, null);
            } else {
                state.defineBoolean(variableName, null);
            }
        } else {
            throw new Exception("The DEF syntax is invalid");
        }
    }

    private void assignmentStatement(String nextVSSLLine) throws Exception {
        String regex = "(LET) ([A-Z])* = ";

        if (nextVSSLLine.matches(regex)) {

            VSSL = VSSL.substring(VSSL.indexOf("LET") + 4);
            String variableName = VSSL.split("=")[0];
            String variableType = VSSL.split(" ")[1].substring(1); // remove space between = and statement

        } else {
            throw new Exception("The LET syntax is invalid");
        }
    }

    private void ifStatement() {

    }

    private void elseStatement() {

    }

}
