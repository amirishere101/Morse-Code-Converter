import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterSTUDENTTest {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .--. .-. --- ..-. . ... ... --- .-. / -.- ..- .--- .. -");
		assertEquals("hello professor kujit",converter1);
	}

	@Test
	public void testPrintTree() {	
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	@Test
	public void testConvertMorseFileToEnglishString() {	
		File file = new File("src/DaisyDaisy.txt"); 
		try {
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
}
