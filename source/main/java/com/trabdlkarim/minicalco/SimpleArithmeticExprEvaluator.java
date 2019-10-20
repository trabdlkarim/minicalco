package com.trabdlkarim.minicalco;

public class SimpleArithmeticExprEvaluator {
    public static double evaluate(final String expr) {
        return new ExpressionParser(expr).parse();
  }
}
