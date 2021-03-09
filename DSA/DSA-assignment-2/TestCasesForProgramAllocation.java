package GETA2021.DSA.DSAAssignment2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class TestCasesForProgramAllocation {

	@Test
	public void test_When_FilePassedIsNull_Expected_NullPointerException() {
		try {
			ProgramAllocation testInput = new ProgramAllocation(null);
		} catch (NullPointerException e) {

		}
	}

	@Test
	public void test_When_ValidFilePassed_Expected_True() throws IOException {
		File inputFile = new File("Programs.xls");
		ProgramAllocation testProgram = new ProgramAllocation(inputFile);
		testProgram.setProgram(inputFile);
		boolean result = testProgram.allocateProgram(inputFile);
		assertTrue(result);
	}

	@Test
	public void test_When_FileNotExists_Expedcted_FileNotFoundException() throws FileNotFoundException{
		File inputFile = new File(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\Prog.xls");
		ProgramAllocation testProgram = new ProgramAllocation(inputFile);
	}
}
