package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.Employee;
import mapper.EmployeeMapper;

public class MyBatisTest {
	@Test
	public void Test() {

		// 1.ͨ通过读取配置文件获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2 通过sqlSessionFactory获取sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// Employee employee =
			// sqlSession.selectOne("com.bean.EmployeeMapper.selectById", 1);
			// System.out.println(employee.toString());

			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getById(1L);
			System.out.println(employee.toString());

		} finally {
			sqlSession.close();
		}

	}

}
