package com.tjekuaitong.base;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Jeff
 */
public class BaseDaoImpl<T> implements IBaseDao<T>{
	@Resource
	protected SqlSessionTemplate sqlSession;
	private Class<T> t = null;
	private static final String INSERT = "insert";   
	private static final String UPDATE = "update";   
	private static final String DELETE = "deleteByPrimaryKey";   
	private static final String SEARCHBYID = "selectByPrimaryKey"; 
	private static final String SEARCHLIST = "selectList";
	private static final String SEARCHONE = "selectOne";
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		//获取当前类的父类
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();		
		t = (Class<T>)pt.getActualTypeArguments()[0];
	}

	//获取实体映射文件的空间名称
	public String getStatementId(String suffix) { 
	   return "com.tjekuaitong.mapping."+t.getSimpleName() + "Mapper." + suffix;
    }
    
	/**
	 * 根据ID删除记录
	 */
	public int delete(String id) throws Exception {
		String sql = this.getStatementId(DELETE);   
		return sqlSession.delete(sql,id);
	}
    
	/**
	 * 新增记录
	 */
	public int insert(T t) throws Exception {
		String sql = this.getStatementId(INSERT); 
		return sqlSession.insert(sql, t);
	}
   
	/**
	 * 根据Id检索记录
	 */
	public T searchById(String id) throws Exception {
		String sql = this.getStatementId(SEARCHBYID); 
		return sqlSession.selectOne(sql, id);
	}
    
	/**
	 * 更新记录
	 */
	public int update(T t) throws Exception {
		String sql = this.getStatementId(UPDATE); 
		return sqlSession.update(sql,t);
	}
    
	/**
	 * 根据实体检索记录
	 */
	public List<T> searchList(T t) throws Exception {
		String sql = this.getStatementId(SEARCHLIST); 
		return sqlSession.selectList(sql,t);
	}
	/**
	 * 根据实体检索记录
	 */
	public List<T> searchOne(T t) throws Exception {
		String sql = this.getStatementId(SEARCHONE); 
		return sqlSession.selectList(sql,t);
	}
}
