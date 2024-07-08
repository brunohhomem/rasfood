package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada com sucesso! " + cardapio);
    }

    public Cardapio consultarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public Cardapio consultarPorNome(final String filtro) {
        try {
            String jsql = "SELECT c FROM Cardapio c WHERE upper(c.nome) = upper(:nome)";
            return this.entityManager.createQuery(jsql, Cardapio.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro) {
        try {
            String jsql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jsql, Cardapio.class).setParameter("valor", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarTodos() {
        try {
            String jsql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jsql, Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
