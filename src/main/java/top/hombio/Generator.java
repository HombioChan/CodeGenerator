package top.hombio;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.*;

public class Generator {

    /*
    1. 获取所有模板文件File对象
    2. 转化绝对路径，获得实际输出流
    3. 获取模板对象
    4. 实例化模板对象
    5. 实例化数据模型
    6. 数据模型+模板 = 输出
     */

    public static void start() throws SQLException, IOException, TemplateException {
        String outputDirPath = PropertiesFactory.getApplicationProperties().getProperty("output");
        if(outputDirPath.equals("")){
            throw new RuntimeException("未配置application/output");
        }
        File outputDir = new File(outputDirPath);
        if(!outputDir.exists()){
            outputDir.mkdirs();
        }
        String templateDirPath = PropertiesFactory.getApplicationProperties().getProperty("template");
        if(templateDirPath.length() == 0){
            throw new RuntimeException("未配置application/template");
        }
        Path templatePath = Paths.get(templateDirPath);
        final List<Path> paths = new ArrayList<>();
        Files.walkFileTree(templatePath, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                paths.add(file);
                return FileVisitResult.CONTINUE;
            }
        });

        List<String> tables = Dao.getTables();
        Map<String,Object> root = getCommonModel();

        for (String tableName : tables) {
            String humpTableName = NameUtil.underlineToHump(tableName);
            Map<String,List<Field>> result = Dao.getFields(tableName);
            root.put("fields",result.get("fields"));
            root.put("commonFields",result.get("commonFields"));
            root.put("tableName",tableName);
            root.put("humpTableName",humpTableName);
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setDirectoryForTemplateLoading(new File(templateDirPath));
            for (Path p : paths) {
                String pp = p.toFile().getAbsolutePath().substring(templatePath.toFile().getAbsolutePath().length()+1);
                String rp = pp.replaceFirst("\\$\\{artifact\\}",PropertiesFactory.getApplicationProperties().getProperty("artifact"))
                                .replaceFirst("\\$\\{package\\}",PropertiesFactory.getApplicationProperties().getProperty("package").replace(".","/"))
                                .replaceFirst("\\$\\{humpTableName\\}",humpTableName);
                Template template = cfg.getTemplate(pp);
                File savedFile = new File(outputDir,rp);
                File dir = savedFile.getParentFile();
                if(!dir.exists()){
                    dir.mkdirs();
                }
                if(!savedFile.exists()){
                    savedFile.createNewFile();
                }
                Writer out = new OutputStreamWriter(new FileOutputStream(savedFile));
                template.process(root,out);
            }
        }


    }

    private static Map<String,Object> getCommonModel(){
        Map<String,Object> root = new HashMap<>();
        root.put("group",PropertiesFactory.getApplicationProperties().getProperty("group"));
        root.put("artifact",PropertiesFactory.getApplicationProperties().getProperty("artifact"));
        root.put("package",PropertiesFactory.getApplicationProperties().getProperty("package"));
        root.put("packaging",PropertiesFactory.getApplicationProperties().getProperty("type"));
        root.put("version",PropertiesFactory.getApplicationProperties().getProperty("type"));
        root.put("type",PropertiesFactory.getApplicationProperties().getProperty("type"));
        root.put("name",PropertiesFactory.getApplicationProperties().getProperty("name"));
        root.put("description",PropertiesFactory.getApplicationProperties().getProperty("description"));
        root.put("driver",PropertiesFactory.getDbProperties().getProperty("driver"));
        root.put("url",PropertiesFactory.getDbProperties().getProperty("url"));
        root.put("username",PropertiesFactory.getDbProperties().getProperty("username"));
        root.put("password",PropertiesFactory.getDbProperties().getProperty("password"));
        return root;
    }

}
