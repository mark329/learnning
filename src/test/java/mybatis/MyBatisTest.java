package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.nick.mapper.EmployeeMapper;
import com.nick.model.Employee;

public class MyBatisTest {
	@Test
	public void Test() {
		SqlSession sqlSession = getSqlSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getById(1L);
			System.out.println(employee.toString());

		} finally {
			sqlSession.close();
		}
	}
	@Test
	public void getByAttributes() {
		SqlSession sqlSession = getSqlSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getByAttributes(String.valueOf(0),"TOM@EMAIL.COM");
			
			System.out.println("getByAttributes----" + employee.toString());

		} finally {
			sqlSession.close();
		}

	}
	
	@Test
	public void insertTest() {
		SqlSession sqlSession = getSqlSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			Employee employee = new Employee();
			employee.setEmail("1@11.com");
			employee.setGender("1");
			employee.setLastName("aaa11");
			mapper.insert(employee);
			
			System.out.println("getByAttributes----" + employee.getId());

		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void deleteTest() {
		SqlSession sqlSession = getSqlSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			 mapper.deleteById(1L);
//			System.out.println("getByAttributes----" + result);

		} finally {
			sqlSession.close();
		}
	}

	private SqlSession getSqlSession() {

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
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		return sqlSession;
	}

}
