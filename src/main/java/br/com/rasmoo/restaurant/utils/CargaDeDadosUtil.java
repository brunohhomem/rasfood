package br.com.rasmoo.restaurant.utils;

import br.com.rasmoo.restaurant.dao.CardapioDao;
import br.com.rasmoo.restaurant.dao.CategoriaDao;
import br.com.rasmoo.restaurant.entity.Cardapio;
import br.com.rasmoo.restaurant.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    public CargaDeDadosUtil() {
    }

    public static void cadastrarCategoria(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Pratos Principais");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
    }

    public static void cadastrarProdutoCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio moqueca = new Cardapio("Moqueca",
                "Peixe branco, banana da terra, arroz e farofa.",
                true,
                BigDecimal.valueOf(99.90),
                categorias.get(2));
        Cardapio spaguetti = new Cardapio("Spaguetti",
                "Spaguetti ao molho de parmesão e cogumelos",
                true,
                BigDecimal.valueOf(50.90),
                categorias.get(2));
        Cardapio bife = new Cardapio("Bife",
                "Bife acebolado com arroz branco, farofa e batata frita.",
                true,
                BigDecimal.valueOf(40.90),
                categorias.get(2));
        Cardapio cordeiro = new Cardapio("Cordeiro",
                "Cordeiro com risoto de fungi",
                true,
                BigDecimal.valueOf(89.59),
                categorias.get(2));
        Cardapio burrata = new Cardapio("Burrata",
                "Tomates queimados, rucula e torradas",
                true,
                BigDecimal.valueOf(15.00),
                categorias.get(0));
        Cardapio bruschetta = new Cardapio("Bruschetta",
                "Tomates, mussarela e manjericão",
                true,
                BigDecimal.valueOf(15.00),
                categorias.get(0));
        Cardapio scapetta = new Cardapio("Scappeta",
                "Ragu de linguiça com torradas",
                true,
                BigDecimal.valueOf(25.00),
                categorias.get(0));
        Cardapio caprese = new Cardapio("Caprese",
                "Mini rúcula com mussarela",
                true,
                BigDecimal.valueOf(15.00),
                categorias.get(0));
        Cardapio ceasar = new Cardapio("Ceasar",
                "Salada de frango com molho ceasar",
                true,
                BigDecimal.valueOf(25.00),
                categorias.get(0));
        Cardapio chevre = new Cardapio("Chevre",
                "Mix de folhas, mostarda e mel",
                true,
                BigDecimal.valueOf(15.00),
                categorias.get(0));

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(spaguetti);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(cordeiro);
        cardapioDao.cadastrar(burrata);
        cardapioDao.cadastrar(bruschetta);
        cardapioDao.cadastrar(scapetta);
        cardapioDao.cadastrar(caprese);
        cardapioDao.cadastrar(ceasar);
        cardapioDao.cadastrar(chevre);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
}
