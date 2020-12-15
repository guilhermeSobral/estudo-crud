package com.crudcompleto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcompleto.controllers.exceptions.ObjetoNaoEncontradoException;

public abstract class GenericService<R extends JpaRepository<T, ID>, T, ID> {
	
	private R repository;
	private Class<T> entity;

	public GenericService(R repository, Class<T> entity) {
		this.repository = repository;
		this.entity = entity;
	}
	
	public T save(T obj) {
		Function<R, T> function = repository -> repository.save(obj);
		return function.apply(repository);
	}
	
	public T searchById(ID id) {	
		Function<R, T> function = repository -> repository.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontradoException(String.format("O %s de id: %d não foi encontrado", entity.getSimpleName(), id)));
		return function.apply(repository);
	}
	
	public List<T> search() {
		Function<R, List<T>> function = repository -> repository.findAll();
		return function.apply(repository);
	}
	
	protected List<T> filter(Predicate<T> predicate) {
		var filteredList = new ArrayList<T>();
		for (T element : search()) {
			if (predicate.test(element)) 
				filteredList.add(element);
		}
		return filteredList;
	}
	
	public void delete(ID id) {
		Consumer<R> consumer = repository -> repository.deleteById(id);
		consumer.accept(repository);
	}

}
