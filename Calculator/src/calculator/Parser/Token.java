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
        public boolean hasvalue;
        
        public Token(Type type){
                this.type = type;
                this.hasvalue = false;
        }
        
        public Token(float value,
                     Type type){
                this.value = value;
                this.type = type;
                this.hasvalue = true;
        }
}
