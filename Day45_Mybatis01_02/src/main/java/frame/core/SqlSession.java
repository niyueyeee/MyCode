package frame.core;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-27 9:50
 */
public interface SqlSession {
    <T> List<T> selectList(String sqlId) throws Exception;
}
