package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO {

	void insert(Article article) throws DALException;

	Article selectById(int idArticle) throws DALException;

	void update(Article article) throws DALException;

	void delete(int idArticle) throws DALException;

	List<Article> selectAll() throws DALException;
	
	List<Article> selectByMarque(String marque) throws DALException;
	
	List<Article> selectByMotCle(String motCle) throws DALException;

}