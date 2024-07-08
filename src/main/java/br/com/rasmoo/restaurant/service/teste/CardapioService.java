package br.com.rasmoo.restaurant.service.teste;

import br.com.rasmoo.restaurant.utils.CargaDeDadosUtil;
import br.com.rasmoo.restaurant.utils.JPAUtil;

import javax.persistence.EntityManager;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);
        entityManager.close();
    }
}
