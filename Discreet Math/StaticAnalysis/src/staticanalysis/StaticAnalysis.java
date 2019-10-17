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

        while (VSSL.length() > 0) {

            String nextVSSLStatement = VSSL.split(" ")[0];

            switch (nextVSSLStatement) {
                case "{": {

                }
                break;
                case "}": {

                }
                break;
                case "DEF": {
                    this.definitionStatement(nextVSSLStatement);
                }
                break;
                case "LET": {

                }
                break;
                case "IF": {

                }
                break;
                case "ELSE": {

                }
            }
        }

    }

    private void definitionStatement(String nextVSSLLine) {
        String regex = "(DEF) ([A-Z])* : ((BOOLEAN)|(INTEGER))";
        if (nextVSSLLine.matches(regex)) {

            VSSL = VSSL.substring(VSSL.indexOf("DEF") + 4);
            String variableName = VSSL.split(":")[0];
            String variableType = VSSL.split(":")[1];
            // Add this to state.
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
