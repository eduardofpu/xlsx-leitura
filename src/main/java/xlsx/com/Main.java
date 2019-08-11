package xlsx.com;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Main {

    private static final String DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String CAMINHO = DIR + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + "xlsx" + SEPARATOR + "planilha2.xlsx";

    public static void main(String[] args) {
        FileInputStream fisPlanilha = null;

        try {
            File file = new File(CAMINHO);


            fisPlanilha = new FileInputStream(file);


            //todas as planilhas com todas abas
            XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);

            //recuperando apenas a primeira aba ou a primeira planilha
            XSSFSheet sheet = workbook.getSheetAt(0);

            //retorna todas a linhas da planilha aba1
            Iterator<Row> rowIterator = sheet.rowIterator();


            //varre todas a linhas da planilha
            while (rowIterator.hasNext()) {


                //Recebe cada linha da planilha
                Row row = rowIterator.next();

                //pegamos todas as celulas desta linha
                Iterator<Cell> cellIterator = row.iterator();

                //varremos todas as celulas da linha atual
                while (cellIterator.hasNext()) {
                    //criando uma celula
                    Cell cell = cellIterator.next();


                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            if(!cell.getStringCellValue().equals("NOME") && !cell.getStringCellValue().equals("IDADE") && !cell.getStringCellValue().equals("PESO")){
                                System.out.println("TIPO STRING: " + cell.getStringCellValue());
                            }

                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                                System.out.println("TIPO NUMERIC: " + cell.getNumericCellValue());

                            break;

                        case Cell.CELL_TYPE_FORMULA:
                                System.out.println("TIPO FORMULA: " + cell.getCellFormula());
                            break;
                        default:
                            System.out.println("Error");
                    }
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
