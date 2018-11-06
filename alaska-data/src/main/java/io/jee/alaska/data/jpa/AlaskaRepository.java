package io.jee.alaska.data.jpa;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import io.jee.alaska.data.jpa.condition.Count;
import io.jee.alaska.data.jpa.condition.Delete;
import io.jee.alaska.data.jpa.condition.Select;
import io.jee.alaska.data.jpa.condition.Update;

@NoRepositoryBean
public interface AlaskaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>{

	T findOne(ID id);
	
	T findOne(ID id, LockModeType lockMode);
	
	T update(ID id, String key, Object value);
	
	T update(ID id, Map<String, Object> keyVal);
	
	Select<T> select();
	
	Select<T> select(boolean cacheable);
	
	Count<T> selectCount();
	
	Update<T> update();
	
	Delete<T> delete();
}
