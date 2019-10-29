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
        try {
            String[] lines = VSSL.split("\n");
            Boolean skipIfBlock = false;
            Boolean skipElseBlock = true;
            Integer blockCount = 0;

            for (int i = 0; i < lines.length; i++) {
                String VSSLLine = lines[i];
                String skipBlockLine;
                
                // Line state
                System.out.println("line " + i + " " + state.toString());
                
                if (skipIfBlock) {
                    skipBlockLine = VSSLLine.replace(" ", "");
                    if (skipBlockLine.endsWith("}")) {
                        blockCount--;
                        if (blockCount == 0) {
                            skipIfBlock = false;
                            skipElseBlock = true;
                        }
                    } else if (skipBlockLine.startsWith("{")) {
                        blockCount++;
                    }
                    continue;
                }
                if (VSSLLine.startsWith("DEF")) {
                    this.definitionStatement(VSSLLine);
                } else if (VSSLLine.contains("LET")) {
                    this.assignmentStatement(VSSLLine);
                } else if (VSSLLine.startsWith("IF")) {
                    Boolean truly = IfStatement.analyze(VSSLLine, state);
                    if (!truly) {
                        skipIfBlock = true;
                        skipElseBlock = false;
                        blockCount++;
                    }

                } else if (VSSLLine.startsWith("ELSE") && !skipElseBlock && blockCount == 0) {
                    System.out.println("ELSE");

                } else if (VSSLLine.isEmpty() || "}".equals(VSSLLine)) {
                    continue;
                } else {
                    System.out.println("SYNTAX INCORRECT!!!");
                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("FINAL STATE: " + state.toString());
    }

    private void statement(String nextVSSLLine, String assigningToVar) throws Exception {
        String[] statementParts = nextVSSLLine.split(" ");

        // If first part of statement is a variable
        if (statementParts[0].matches("[A-Z]*")) {
            String variableName = statementParts[0];
            // if the variable matches the one being assigned
            if (variableName.equals(assigningToVar)) {
                // check if already exists as bool
                if (state.booleans.get(variableName) != null) {
                    Boolean firstOprand = state.getValueOfBoolVariable(variableName);
                    String operator = statementParts[1];
                    Boolean secondOprand = statementParts[2].equals("true");
                    Boolean newVarValue = IfStatement.booleanCalculator(firstOprand, secondOprand, operator);
                    state.putBoolean(variableName, newVarValue);

                    // check if already exists as int
                } else if (state.integers.get(variableName) != null) {
                    // get values and calculate new var value for state
                    int firstOprand = state.getValueOfIntVariable(variableName) != null ? state.getValueOfIntVariable(variableName) : 0;
                    String operator = statementParts[1];
                    int secondOprand = Integer.parseInt(statementParts[2]);
                    int newVarValue = IntegerCalculator.calculateInteger(firstOprand, operator, secondOprand);
                    state.putInteger(variableName, newVarValue);
                }

            } else if ("TRUE".equals(variableName) || "FALSE".equals(variableName)) {
                state.putBoolean(assigningToVar, "TRUE".equals(variableName));
            } else {
                // check if already exists as bool
                if (state.booleans.get(variableName) != null) {
                    Boolean firstOprand = state.getValueOfBoolVariable(variableName);
                    String operator = statementParts[1];
                    Boolean secondOprand = statementParts[2].equals("true");
                    Boolean newVarValue = IfStatement.booleanCalculator(firstOprand, secondOprand, operator);
                    state.putBoolean(assigningToVar, newVarValue);

                    // check if already exists as int
                } else if (state.integers.get(variableName) != null) {
                    // get values and calculate new var value for state
                    int firstOprand = state.getValueOfIntVariable(variableName) != null ? state.getValueOfIntVariable(variableName) : 0;
                    String operator = statementParts[1];
                    int secondOprand = Integer.parseInt(statementParts[2]);
                    int newVarValue = IntegerCalculator.calculateInteger(firstOprand, operator, secondOprand);
                    // assign to the LET value
                    state.putInteger(assigningToVar, newVarValue);
                }

            }
            // if first part of statement is a number / constant
        } else if (statementParts[0].matches("[0-9]*")) {
            // assign value to int
            state.putInteger(assigningToVar, Integer.parseInt(statementParts[0]));
        } else if ("true".equals(statementParts[0]) || "false".equals(statementParts[0])) {
            // assign value to boolean if none other criteria matches
            state.putBoolean(assigningToVar, "true".equals(statementParts[0]));
        } else {
            throw new Exception("Something does not match statement syntax");
        }

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
        String regex = ".*(LET) ([A-Z])* = .*";

        if (nextVSSLLine.matches(regex)) {
            nextVSSLLine = nextVSSLLine.substring(nextVSSLLine.indexOf("LET") + 3);
            String variableName = nextVSSLLine.split("=")[0].replace(" ", "");
            String statement = nextVSSLLine.split("=")[1].substring(1); // remove space between = and statement
            // Evaluate statement and process variables
            statement(statement, variableName);
        } else {
            throw new Exception("The LET syntax is invalid");
        }
    }

}
