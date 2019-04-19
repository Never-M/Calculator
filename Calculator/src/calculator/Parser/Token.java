package calculator.Parser;

/**
 *
 * @author zjz20
 */
public class Token {

        public enum Type {
                leftParenthesis,
                rightParenthesis,
                add,
                minus,
                multiple,
                divide,
                power,
                number
        }
        
        public float value;
        public Type  type;
}
