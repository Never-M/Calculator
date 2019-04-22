/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Parser;

import java.io.InputStream;

/**
 *
 * @author zjz20
 */
public interface ITokenFactory {
        public Token create(InputStream streamchar) throws Exception;
}
