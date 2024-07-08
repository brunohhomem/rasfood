package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Cardapio;
import br.com.rasmoo.restaurant.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
        System.out.println("Categoria cadastrada com sucesso! " + categoria);
    }

    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
