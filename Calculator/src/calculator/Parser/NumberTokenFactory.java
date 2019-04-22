/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Parser;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author zjz20
 */
public class NumberTokenFactory implements ITokenFactory {

        @Override
        public Token create(InputStream streamchar) throws IOException {
                int state = 0;
                streamchar.mark(30);
                char c;
                StringBuilder sb = new StringBuilder();
                while (streamchar.available() > 0) {
                        c = (char) streamchar.read();
                        sb.append(c);
                        switch (state) {
                                case 0: {
                                        if (Character.isDigit(c)) {
                                                state = 1;
                                        } else if (c == '.') {
                                                state = 3;
                                        }
                                        else {
                                                return null;
                                        }
                                        break;
                                }
                                case 1: {
                                        if (Character.isDigit(c)) {
                                                state = 1;
                                        } else if (c == '.') {
                                                state = 2;
                                        }else {
                                                state = 5;
                                        }
                                        break;
                                }
                                case 2: {
                                        if (Character.isDigit(c)) {
                                                state = 4;
                                        } else {
                                                state = 5;
                                        }
                                        break;
                                }
                                case 3: {
                                        if (Character.isDigit(c)){
                                                state = 4;
                                        }
                                        else{
                                                return null;
                                        }
                                        break;
                                }
                                case 4: {
                                        if (Character.isDigit(c)) {
                                                state = 4;
                                        } else if (c == '.') {
                                                return null;
                                        }else {
                                                state = 5;
                                        }
                                        break;
                                }
                                case 5: {
                                        return (new Token(Float.parseFloat(sb.toString()), Token.Type.number));
                                }
                        }
                }
                return (new Token(Float.parseFloat(sb.toString()), Token.Type.number));
        }

}
