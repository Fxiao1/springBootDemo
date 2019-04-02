package com.fx.modules.poi;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Excel文件的处理功能类
 *
 * @author fxiao
 * @date 2019/4/1 10:42
 */

public class ExcelUtils {
    private Logger log= LoggerFactory.getLogger(ExcelUtils.class);
    private Map<String,String> excelData=new HashMap<>();
    private ExcelUtils(){
        super();
    }
    public ExcelUtils(String StringPath) throws FileNotFoundException {
        this.excelData=analysis(StringPath);
    }
    /**
     * TODO: 解析excel文件到map,仅解析第一个sheet页，忽略后面的
     * @Author Fxiao
     * @Description
     * @Date 13:13 2019/4/2
     * @param filePath
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    private Map<String,String> analysis(String filePath) throws FileNotFoundException {
        InputStream is=new FileInputStream(filePath);
        Workbook wb=null;
        try {
            wb= WorkbookFactory.create(is);
        } catch (IOException e) {
            log.error("文件流发生异常",e);
            e.printStackTrace();
        }finally {

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Sheet sheet0=wb.getSheetAt(0);
        sheet0.getFirstRowNum();
        sheet0.getLastRowNum();
        int physicalNumberOfRows=sheet0.getPhysicalNumberOfRows();
        Map<String,String>result = new HashMap<>();
        StringBuffer sb=new StringBuffer();
        for (Integer i = 0; i < physicalNumberOfRows; i++) {
            Row currentRow=sheet0.getRow(i);
            int physicalNumberOfCells=currentRow.getPhysicalNumberOfCells();
            for (Integer j = 0; j < physicalNumberOfCells; j++) {
                Cell cell=currentRow.getCell(j);
                sb.append(i.toString()).append("-").append(j.toString());
                result.put(sb.toString(),cell.getStringCellValue());
                sb.setLength(0);
            }
        }

        return result;
    }


    public Map<String, String> getExcelData() {
        return excelData;
    }

    /*@Test
    public void demo1() throws FileNotFoundException {
        Map<String,String> result=analysis("E:\\temp\\test.xlsx");
        System.out.println(JSON.toJSONString(result));
    }*/

}
