package io.jee.alaska.data.jpa;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.jee.alaska.data.jpa.condition.Count;
import io.jee.alaska.data.jpa.condition.Delete;
import io.jee.alaska.data.jpa.condition.Select;
import io.jee.alaska.data.jpa.condition.Update;

public class SimpleAlaskaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements AlaskaRepository<T, ID> {
	
	private final EntityManager entityManager;
	private final Class<T> domainClass;
	
	public SimpleAlaskaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
		domainClass = entityInformation.getJavaType();
	}
	
	@Override
	public T findOne(ID id) {
		return this.findById(id).orElse(null);
	}
	
	@Override
	public T findOne(ID id, LockModeType lockMode) {
		return entityManager.find(domainClass, id, lockMode);
	}
	
	@Override
	@Transactional
	public T update(ID id, String key, Object value) {
		T t = findById(id).get();
		if(t==null) {
			return null;
		}
		try {
			PropertyDescriptor descriptor = new PropertyDescriptor(key, domainClass);
			Method set = descriptor.getWriteMethod();
			set.invoke(t, value);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return save(t);
	}
	
	@Override
	@Transactional
	public T update(ID id, Map<String, Object> keyVal) {
		T t = findById(id).get();
		if(t==null) {
			return null;
		}
		Set<Entry<String, Object>> entrys = keyVal.entrySet();
		for (Entry<String, Object> entry : entrys) {
			try {
				PropertyDescriptor descriptor = new PropertyDescriptor(entry.getKey(), domainClass);
				Method set = descriptor.getWriteMethod();
				set.invoke(t, entry.getValue());
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return save(t);
	}

	@Override
	public Select<T> select(){
		return new Select<>(false, entityManager, domainClass);
	}
	
	@Override
	public Select<T> select(boolean cacheable){
		return new Select<>(cacheable, entityManager, domainClass);
	}
	
	@Override
	public Count<T> selectCount(){
		return new Count<>(entityManager, domainClass);
	}
	
	@Override
	public Update<T> update(){
		return new Update<>(entityManager, domainClass);
	}
	
	@Override
	public Delete<T> delete(){
		return new Delete<>(entityManager, domainClass);
	}

}
