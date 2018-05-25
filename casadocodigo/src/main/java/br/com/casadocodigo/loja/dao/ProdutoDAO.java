package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> listar() {
		TypedQuery<Produto> query = manager.createQuery("from Produto ", Produto.class);
		return query.getResultList();
	}

	public Produto find(Integer id) {
		return manager.createQuery(" Select distinct(p) from Produto p "
								+ "join fetch p.precos where p.id = :pId ", 
								Produto.class).setParameter("pId", id).getSingleResult();
	}

}
