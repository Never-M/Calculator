/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculator.Parser.NumberTokenFactory;
import calculator.Parser.Token;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zjz20
 */
public class NumberTokenFactoryTest {
        
        private NumberTokenFactory numtokenfact;
        
        public NumberTokenFactoryTest() {
        }
        
        @BeforeClass
        public static void setUpClass() {
        }
        
        @AfterClass
        public static void tearDownClass() {
        }
        
        @Before
        public void setUp() {
                numtokenfact = new NumberTokenFactory();
        }
        
        @After
        public void tearDown() {
        }

        @Test
        public void NotNumber() throws IOException {
                String input = "0.0.1;";
                InputStream stream = new ByteArrayInputStream(input.getBytes());
                Token token = numtokenfact.create(stream);
                assertTrue(token == null);
        }
        

        @Test
        public void IsNumber() throws IOException {
                String input = "349";
                InputStream stream = new ByteArrayInputStream(input.getBytes());
                Token token = numtokenfact.create(stream);
                assertTrue(token.type == Token.Type.number);
                assertTrue(token.value == 349);
        }
        
        @Test
        public void IsDicimal() throws IOException {
                String input = "349.012";
                InputStream stream = new ByteArrayInputStream(input.getBytes());
                Token token = numtokenfact.create(stream);
                assertTrue(token.type == Token.Type.number);
                assertTrue(Math.abs(token.value - 349.012) < .0001);
        }
}
