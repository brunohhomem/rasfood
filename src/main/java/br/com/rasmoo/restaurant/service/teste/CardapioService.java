package br.com.rasmoo.restaurant.service.teste;

import br.com.rasmoo.restaurant.dao.CardapioDao;
import br.com.rasmoo.restaurant.utils.CargaDeDadosUtil;
import br.com.rasmoo.restaurant.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de Produtos por valor: " + cardapioDao.consultarPorValor(BigDecimal.valueOf(15.00)));

        entityManager.close();
    }
}
