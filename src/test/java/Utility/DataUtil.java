package Utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DataUtil {

    public void setData(Scenario sc) {
        String scenarioNumber = sc.getName().split("-", 2)[0];
        Map<String, Object> map = jsonToMap(new JSONObject(getJsonValue("filepath.json", scenarioNumber)));
//        new ReflectionAPI().getCommon().overrideClassFields(map);
    }

    public String getJsonValue(String filePath, String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(new File(filePath)).path(key).toString();
        } catch (IOException e) {
            return null;
        }
    }

    public Map<String, Object> jsonToMap(JSONObject object) {
        return toMap(object);
    }

    public Map<String, Object> toMap(JSONObject object) {
        Map<String, Object> results = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : this.toMap(object).entrySet()) {
            Object value;
            if (entry.getValue() == null) {
                value = null;
            } else if (entry.getValue() instanceof JSONObject) {
                value = ((JSONObject) entry.getValue()).toMap();
            } else if (entry.getValue() instanceof JSONArray) {
                value = ((JSONArray) entry.getValue()).toList();
            } else {
                value = entry.getValue();
            }
            results.put(entry.getKey(), value);
        }
        return results;
    }

    private Workbook workbook;
    private String filePath = "src/test/resources/TestData/TestData.xlsx";
    private String sheetName = "Sheet1";

    public DataUtil() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + filePath, e);
        }
    }

    public String getCellData(int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null)
            return null;

        Row row = sheet.getRow(rowNum);
        if (row == null)
            return null;

        Cell cell = row.getCell(colNum);
        if (cell == null)
            return null;

        return getFormattedValue(cell);
    }

    private String getFormattedValue(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell); // handles string, numeric, date, boolean
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return 0;
        return sheet.getLastRowNum() + 1; // row count
    }

    public int getColCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return 0;

        Row row = sheet.getRow(0);
        if (row == null) return 0;

        return row.getLastCellNum(); // column count
    }

    public void dataTableList() {
        List<List<String>> list = new ArrayList<>();
        List<String> arrayList = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        for (Row row : sheet) {
            arrayList = new ArrayList<>();
            for (Cell cell : row) {
                arrayList.add(getFormattedValue(cell));
            }
            list.add(arrayList);
        }
        System.out.println(list);
    }

    public void dataTableMap() {
        List<Map<String, String>> list = new ArrayList<>();
        List<String> columnList = new ArrayList<>();
        Map<String, String> hashMap = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < getColCount(sheetName); i++) {
            columnList.add(String.valueOf(sheet.getRow(0).getCell(i)));
        }
        for (int i = 1; i < getRowCount(sheetName); i++) {
            hashMap = new HashMap<>();
            for (int j = 0; j < getColCount(sheetName); j++) {
                hashMap.put(columnList.get(j), getFormattedValue(sheet.getRow(i).getCell(j)));
            }
            list.add(hashMap);
        }
        System.out.println(list);
    }

    public static Map<String, Map<String, String>> getJsonMap() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<String, String>> header;

        try {
            header = mapper.readValue(new File("src/test/resources/TestData/Header.json"),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return header;
    }

    public static Properties getPropValue(String filePath) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public static void updatePropValue(String filePath, String key, String value) {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        props.setProperty(key, value);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            props.store(fos, "Updated key: " + key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeNewPropertyFile(String filePath, Map<String, String> data) {
        Properties props = new Properties();

        data.forEach(props::setProperty);
        for (String key : data.keySet()) {
            props.setProperty(key, data.get(key));
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            props.store(fos, "Generated file");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DataUtil dataUtil = new DataUtil();
//        System.out.println(getJsonMap().get("1.1"));
        Map<String, String> map = new HashMap<>();
        map.put("user", "userId");
        map.put("pass", "password");
        writeNewPropertyFile("src/test/resources/config.properties", map);

    }
}
