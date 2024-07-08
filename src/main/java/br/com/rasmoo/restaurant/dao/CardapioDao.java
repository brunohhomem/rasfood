package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada com sucesso! " + cardapio);
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
