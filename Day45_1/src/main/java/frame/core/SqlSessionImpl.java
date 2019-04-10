package frame.core;

import frame.pojo.Configuration;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-27 9:51
 */
public class SqlSessionImpl implements SqlSession {
    private Configuration configuration;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> List<T> selectList(String sqlId) throws Exception {
        List<T> list = new ArrayList<>();
        Class.forName(configuration.getDriver());
        Connection conn = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        String sql = configuration.getMapperMap().get(sqlId).getSql();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        ArrayList<String> columNames = new ArrayList<>();
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            columNames.add(metaData.getColumnName(i));
        }
        String resultType = configuration.getMapperMap().get(sqlId).getResultType();
        Class<?> aClass = Class.forName(resultType);
        Method[] methods = aClass.getMethods();

        Object obj = null;
        while (rs.next()) {
            obj = aClass.newInstance();
            for (String columName : columNames) {
                Object columnValue = rs.getObject(columName);
                for (Method method : methods) {
                    String methodName = method.getName();
                    if (methodName.equalsIgnoreCase("set" + columName)) ;
                    method.invoke(obj, columnValue);
                }
            }
            list.add((T) obj);
        }
        return list;
    }
}
