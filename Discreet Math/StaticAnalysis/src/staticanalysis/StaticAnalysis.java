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
                case "}": {

                }
                case "DEF": {
                    this.definitionStatement();
                }
                case "LET": {

                }
                case "IF": {

                }
                case "ELSE": {

                }
            }
        }

    }

    private void definitionStatement() {
        VSSL = VSSL.substring(VSSL.indexOf("DEF") + 4);
        String variableName = VSSL.split(":")[0];
        String variableType = VSSL.split(" ")[1];
        // Add this to state.

    }

    private void assignmentStatement() {
        VSSL = VSSL.substring(VSSL.indexOf("LET") + 4);
        String variableName = VSSL.split(":")[0];
        String variableType = VSSL.split(" ")[1];

    }

    private void ifStatement() {

    }

    private void elseStatement() {

    }

}