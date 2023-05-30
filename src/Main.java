import java.util.Stack;

public class Main implements ITextFile {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String openBrackets = "([{<";
        String closeBrackets = ")]}>";

        String brackets = ITextFile.getDataFromFile("src/data.txt");

        boolean result = true;
        for (int i = 0; i < brackets.length(); i++) {
            boolean isOpenBracket = openBrackets.contains(String.valueOf(brackets.charAt(i)));

            if (isOpenBracket) {
                stack.push(String.valueOf(brackets.charAt(i)));
            } else {
                String top = stack.pop();
                int indexOfTop = openBrackets.indexOf(top);
                int indexOfCurrent = closeBrackets.indexOf(brackets.charAt(i));
                if (indexOfTop != indexOfCurrent) {
                    result = false;
                    break;
                }
            }
        }

        System.out.println(result ? "YES": "NO");
    }
}


// "YES" CASES:
// ((()))
// (){}[]
// {[()]}
// (()(()))
// {()}([])

// "NO" CASES:
// ((())
// ({[}])
// ((())]
// {[()]}}
// {[(])}


