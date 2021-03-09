package GETA2021.DSA.DSAAssignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Allocate programs to students
 * 
 * @since 08-03-2021
 * @author Hitesh Pareek
 */
public class ProgramAllocation {

	static File inputFile;
	Programs allProgram[];

	ProgramAllocation(File inputFile) {
		if (inputFile == null) {
			throw new NullPointerException();
		}
		this.inputFile = inputFile;
	}

	/**
	 * Store details of all the programs available in the file into an array
	 * 
	 * @param file
	 * @return true if all the data is stored successfully
	 * @throws IOException
	 */
	public boolean setProgram(File file) throws IOException {
		FileInputStream programInput = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(programInput);
		HSSFSheet programsSheet = workbook.getSheetAt(0);
		int size = programsSheet.getLastRowNum();
		allProgram = new Programs[size];

		int row = programsSheet.getLastRowNum();

		for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
			HSSFRow currentRow = programsSheet.getRow(rowIndex);
			String programName = currentRow.getCell(0).toString();
			int capacity = (int) Double.parseDouble((currentRow.getCell(1)
					.toString()));

			Programs p = new Programs(programName, capacity);
			allProgram[rowIndex - 1] = p;
		}
		workbook.close();
		return true;
	}

	/**
	 * Insert the names of student in a queue
	 * 
	 * @param file
	 * @return the queue in which names of the student is stored
	 * @throws IOException
	 */
	public QueueImplement setStudent(File file) throws IOException {
		FileInputStream studentInput = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(studentInput);
		HSSFSheet studentSheet = workbook.getSheetAt(1);
		int size = studentSheet.getLastRowNum();
		QueueImplement studentQueue = new QueueImplement(size + 1);
		int row = studentSheet.getLastRowNum();

		for (int rows = 0; rows <= row; rows++) {
			HSSFRow currentRow = studentSheet.getRow(rows);
			studentQueue.add(currentRow.getCell(0).toString());
		}
		workbook.close();
		return studentQueue;
	}

	/**
	 * Creates a new sheet where programs are allocated to respective student
	 * 
	 * @param allocatedPrograms
	 * @throws IOException
	 */
	public static boolean createSheet(Object allocatedPrograms[][])
			throws IOException {
		if (allocatedPrograms == null) {
			throw new NullPointerException();
		}

		FileOutputStream programsInput = new FileOutputStream(
				"C:\\Users\\hitesh.pareek_metacu\\Desktop\\Allocation.xls");
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet newSheet = workbook.createSheet("AllocatedPrograms");
		int rowCount = 0;

		for (Object allObject[] : allocatedPrograms) {

			HSSFRow currentRow = newSheet.createRow(rowCount++);
			int columnCount = 0;
			for (Object value : allObject) {
				HSSFCell cell = currentRow.createCell(columnCount++);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
			}
		}
		workbook.write(programsInput);
		workbook.close();
		return true;
	}

	/**
	 * Allocate program to students according to availability
	 * 
	 * @param file
	 * @throws IOException
	 */
	public boolean allocateProgram(File inputFile) throws IOException {
		FileInputStream studentInput = new FileInputStream(inputFile);
		HSSFWorkbook workbook = new HSSFWorkbook(studentInput);
		HSSFSheet studentSheet = workbook.getSheetAt(1);
		int rowSize = studentSheet.getLastRowNum();
		int columnSize = studentSheet.getRow(1).getLastCellNum();
		Object allocation[][] = new Object[rowSize + 2][2];
		// creating an Object array to store the final allocation
		QueueImplement studentQueue = setStudent(inputFile);

		/*
		 * Set the heading for the array
		 */
		allocation[0][0] = "Name";
		allocation[0][1] = "Program";

		/*
		 * Checking according to the preference of the student, if program
		 * according to their choice can be allocated or not
		 */
		for (int currentRow = 0; currentRow <= rowSize; currentRow++) {
			HSSFRow row = studentSheet.getRow(currentRow);
			allocation[currentRow + 1][0] = studentQueue.remove();

			loop: for (int currentColumn = 1; currentColumn < columnSize; currentColumn++) {
				HSSFCell cell = row.getCell(currentColumn);

				for (int index = 0; index < allProgram.length; index++) {
					String name = cell.toString();

					if (name.equals(allProgram[index].name)
							&& allProgram[index].capacity > 0) {
						allocation[currentRow + 1][1] = name;
						allProgram[index].capacity--;
						break loop;
					}
				}
			}
			/*
			 * If no program is allocated it , will put "NA" in the array
			 */
			if (allocation[currentRow + 1][1] == null) {
				allocation[currentRow + 1][1] = "NA";
			}
		}
		if (createSheet(allocation)) {
			workbook.close();
			return true;
		} else {
			workbook.close();
			return false;
		}
	}
}
