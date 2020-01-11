package top.hombio;

import java.sql.*;
import java.util.*;

public class Dao {

    private static Connection connection;

    private static Properties configuration = PropertiesFactory.getDbProperties();
    private static Properties dataTypeMapping = PropertiesFactory.getDataTypeMappingProperties();
    private static List<String> commonFields = Arrays.asList(PropertiesFactory.getDbProperties().getProperty("commonFields").split(","));

    static {
        try{
            Class.forName(configuration.getProperty("driver"));
            connection = DriverManager.getConnection(configuration.getProperty("url"),configuration.getProperty("username"),configuration.getProperty("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> getTables() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = metaData.getTables(configuration.getProperty("catalog"),null,"%",types);
        List<String> specifyTables = Arrays.asList(configuration.getProperty("tables").split(","));
        List<String> generatedTables = new ArrayList<>();
        if(specifyTables.size() == 1 && specifyTables.get(0).length() == 0){
            while(rs.next()){
                generatedTables.add(rs.getString(3));
            }
        }else{
            while (rs.next()){
                if(specifyTables.contains(rs.getString(3))){
                    generatedTables.add(rs.getString(3));
                }
            }
        }
        return generatedTables;
    }

    public static Map<String, List<Field>> getFields(String tableName) throws SQLException {
        Map<String, List<Field>> result = new HashMap<>(2);
        ResultSet rs = connection.getMetaData().getColumns(configuration.getProperty("catalog"),null,tableName,"%");
        List<Field> fields = new ArrayList<>();
        List<Field> cfs = new ArrayList<>();
        while (rs.next()){

            Field field = new Field();
            field.setName(NameUtil.underlineToHumpAndCapFirst(rs.getString(4)));
            String realType = dataTypeMapping.getProperty(rs.getString(6));
            if(realType.length() > 0){
                field.setType(realType);
            }else{
                System.out.println("unknown type : "+ rs.getString(6));
            }
            if(commonFields.contains(rs.getString(4))){
                cfs.add(field);
            }else{
                fields.add(field);
            }
        }
        result.put("fields",fields);
        result.put("commonFields",cfs);
        return result;
    }
}
