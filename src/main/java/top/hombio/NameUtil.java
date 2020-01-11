package top.hombio;

public class NameUtil {
    public static String underlineToHump(String name){
        name = name.replaceFirst(PropertiesFactory.getDbProperties().getProperty("tablePrefix"),"");
        String[] ss = name.split("_");
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            if(s.length() > 1){
                sb.append(capFirst(s));
            }
        }
        return sb.toString();
    }

    public static String underlineToHumpAndCapFirst(String name){
        String[] ss = name.split("_");
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            if(s.length() > 1){
                sb.append(capFirst(s));
            }
        }
        return sb.toString().substring(0,1).toLowerCase()+sb.toString().substring(1);
    }

    private static String capFirst(String name){
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
