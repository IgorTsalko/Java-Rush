package com.javarush.task.task34.task3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        solution.recurse("tan(45)", 0);  // 1 1 - expected output
        solution.recurse("tan(-45)", 0); // -1 2 - expected output
        solution.recurse("0.305", 0);  // 0.3 0 - expected output
        solution.recurse("0.3051", 0);  // 0.31 0 - expected output
        solution.recurse("(0.3051)", 0);  // 0.31 0- expected output
        solution.recurse("(-0.3051)", 0);  // 0.31 1- expected output
        solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);  // 12 8 - expected output
        solution.recurse("1+5.0*2.0+1", 0);  // 12 3 - expected output
        solution.recurse("tan(44+sin(89-cos(180)^2))", 0);  // 1 6 - expected output
        solution.recurse("-2+(-2+(-2)-2*(2+2))", 0);  // -14 8 - expected output
        solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);  // 1 7 - expected output
        solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);  // 6 11 - expected output
        solution.recurse("10-2^(2-1+1)", 0);  // 6 4 - expected output
        solution.recurse("2^10+2^(5+5)", 0);  // 2048 4 - expected output
        solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);  // 72.96 8 - expected output
        solution.recurse("0.000025+0.000012", 0);  // 0 1 - expected output
        solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);  // -3 16 - expected output
        solution.recurse("cos(3 + 19*3)", 0);  // 0.5 3 - expected output
    }

    public void recurse(final String expression, int countOperation) {
        String parsExpression = expression.replaceAll("\\s", "");
        if (countOperation == 0) {
            countOperation = counterOperations(expression);
        }
        parsExpression = sinCosTanCalculator(parsExpression);

        if (parsExpression.contains("(") || parsExpression.contains(")")) {
            Pattern parenthesesPattern = Pattern.compile("\\(([^()]+)\\)");
            Matcher parenthesesMainMatcher = parenthesesPattern.matcher(parsExpression);

            while (parenthesesMainMatcher.find()) {
                String parenthesizedExpression = parenthesesMainMatcher.group();

                if (parenthesizedExpression.matches("^\\(*\\-*\\d+\\.*\\d*\\)*$")) {
                    String expressionWithoutParentheses = parenthesizedExpression.replaceAll("[\\(\\)]", "");
                    parsExpression = parsExpression.replace(parenthesizedExpression, expressionWithoutParentheses);
                } else {
                    String calculationResultInParentheses = calculateExpression(parenthesizedExpression);
                    parsExpression =
                            parsExpression
                                    .replace(parenthesizedExpression, "(" + calculationResultInParentheses + ")");
                }
            }
        } else {
            parsExpression = calculateExpression(parsExpression);
        }

        if (!parsExpression.matches("^\\-*\\d+(\\.|\\,)*\\d*")) {
            recurse(parsExpression, countOperation);
        } else {
            double doubleResult = Double.parseDouble(parsExpression);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
            System.out.println(decimalFormat.format(doubleResult).replaceAll("\\,", ".") + " " + countOperation);
        }

    }

    public static String calculateExpression(String parenthesizedExpression) {
        String result = parenthesizedExpression.replaceAll("[\\(\\)]", "");

        Pattern degreePattern = Pattern.compile("\\d+\\.*\\d*\\^\\d+\\.*\\d*");
        Pattern multiplyAndDividePattern = Pattern.compile("(\\d+\\.*\\d*\\*\\-*\\d+\\.*\\d*|\\d+\\.*\\d*\\/\\-*\\d+\\.*\\d*)");
        Pattern plusAndMinusPattern = Pattern.compile("(^\\-*\\d+\\.*\\d*\\+\\-*\\d+\\.*\\d*|^\\-*\\d+\\.*\\d*\\-\\-*\\d+\\.*\\d*)");

        Matcher degreeMatcher = degreePattern.matcher(result);
        while (degreeMatcher.find()) {
            String someExpression = degreeMatcher.group();
            String degreeResult = degreeCalculate(someExpression);
            result = replaceFirstMatch(result, someExpression, degreeResult);
        }

        Matcher multiplyAndDivideMatcher = multiplyAndDividePattern.matcher(result);
        while (multiplyAndDivideMatcher.find()) {
            String exResult = "";
            String someExpression = multiplyAndDivideMatcher.group();

            if (someExpression.contains("*")) {
                exResult = multiplyCalculate(multiplyAndDivideMatcher.group());
            } else if (someExpression.contains("/")) {
                exResult = divideCalculate(multiplyAndDivideMatcher.group());
            }
            result = replaceFirstMatch(result, someExpression, exResult);
            multiplyAndDivideMatcher = multiplyAndDividePattern.matcher(result);
        }

        Matcher plusAndMinusMatcher = plusAndMinusPattern.matcher(result);
        while (plusAndMinusMatcher.find()) {
            String exResult = "";
            String someExpression = plusAndMinusMatcher.group();

            if (someExpression.contains("+")) {
                exResult = plusCalculate(plusAndMinusMatcher.group());
            } else if (someExpression.contains("-")) {
                exResult = minusCalculate(plusAndMinusMatcher.group());
            }
            result = replaceFirstMatch(result, someExpression, exResult);
            plusAndMinusMatcher = plusAndMinusPattern.matcher(result);
        }

        return result;
    }

    public static String sinCosTanCalculator(String expression) {
        String result = expression;

        Pattern sinPattern = Pattern.compile("sin\\(\\-*\\d+\\.*\\d*\\)");
        Pattern cosPattern = Pattern.compile("cos\\(\\-*\\d+\\.*\\d*\\)");
        Pattern tanPattern = Pattern.compile("tan\\(\\-*\\d+\\.*\\d*\\)");

        Matcher sinMatcher = sinPattern.matcher(expression);
        while (sinMatcher.find()) {
            String sinString = sinMatcher.group();
            if (sinString.matches("^sin\\(\\-*\\d+\\.*\\d*\\)*$")) {
                result = result.replace(sinString, sinCalculate(sinString));
            }
        }

        Matcher cosMatcher = cosPattern.matcher(expression);
        while (cosMatcher.find()) {
            String cosString = cosMatcher.group();
            if (cosString.matches("^cos\\(\\-*\\d+\\.*\\d*\\)*$")) {
                result = result.replace(cosString, cosCalculate(cosString));
            }
        }

        Matcher tanMatcher = tanPattern.matcher(expression);
        while (tanMatcher.find()) {
            String tanString = tanMatcher.group();
            if (tanString.matches("^tan\\(\\-*\\d+\\.*\\d*\\)*$")) {
                result = result.replace(tanString, tanCalculate(tanString));
            }
        }

        return result;
    }

    public static String sinCalculate(String sinExpression) {
        double degree = Double.parseDouble(sinExpression.replaceAll("[sin\\(\\)]", ""));
        return roundDouble(Math.sin(Math.toRadians(degree)));
    }

    public static String cosCalculate(String cosExpression) {
        double degree = Double.parseDouble(cosExpression.replaceAll("[cos\\(\\)]", ""));
        return roundDouble(Math.cos(Math.toRadians(degree)));
    }

    public static String tanCalculate(String tanExpression) {
        double degree = Double.parseDouble(tanExpression.replaceAll("[tan\\(\\)]", ""));
        return roundDouble(Math.tan(Math.toRadians(degree)));
    }

    public static String degreeCalculate(String minExpression) {
        double[] pair = numberPair(minExpression);
        return roundDouble(Math.pow(pair[0], pair[1]));
    }

    public static String multiplyCalculate(String minExpression) {
        double[] pair = numberPair(minExpression);
        return roundDouble(pair[0] * pair[1]);
    }

    public static String divideCalculate(String minExpression) {
        double[] pair = numberPair(minExpression);
        return roundDouble(pair[0] / pair[1]);
    }

    public static String plusCalculate(String minExpression) {
        double[] pair = numberPair(minExpression);
        return roundDouble(pair[0] + pair[1]);
    }

    public static String minusCalculate(String minExpression) {
        double[] pair = numberPair(minExpression);
        return roundDouble(pair[0] - pair[1]);
    }

    public static double[] numberPair(String minExpression) {
        Pattern numberPattern = Pattern.compile("\\d+\\.*\\d*");
        Matcher numberMatcher = numberPattern.matcher(minExpression);
        double[] pair = new double[2];

        int i = 0;
        while (numberMatcher.find()) {
            pair[i++] = Double.parseDouble(numberMatcher.group());
        }

        if (minExpression.startsWith("-")) {
            pair[0] = pair[0] * -1.0;
        }
        if (minExpression.contains("*-") || minExpression.contains("/-")
                || minExpression.contains("+-") || minExpression.contains("--")) {
            pair[1] = pair[1] * -1.0;
        }

        return pair;
    }

    public static int counterOperations(String expression) {
        int count = 0;

        Pattern pattern = Pattern.compile("[t\\+i\\-c\\/\\*\\^]");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static String replaceFirstMatch(String changedString, String target, String request) {
        String result = changedString;

        for (int i = 0; i < changedString.length() - target.length() + 1; i++) {
            String subString = changedString.substring(i, i + target.length());
            if (subString.equals(target)) {
                StringBuilder builder = new StringBuilder(changedString);
                result = builder.replace(i, i + target.length(), request).toString();
                break;
            }
        }

        return result;
    }

    public static String roundDouble(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("#.############");
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        return decimalFormat.format(d).replaceAll("\\,", ".");
    }

    public Solution() {
        //don't delete
    }
}
