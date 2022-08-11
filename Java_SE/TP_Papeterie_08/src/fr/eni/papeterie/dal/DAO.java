package fr.eni.papeterie.dal;

import java.util.List;

public interface DAO<T> {

	void insert(T valeur) throws DALException;

	T selectById(int id) throws DALException;

	void update(T valeur) throws DALException;

	void delete(int id) throws DALException;

	List<T> selectAll() throws DALException;
}
