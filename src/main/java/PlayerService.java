import com.example.player.Player;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

public class PlayerService {

    private EntityManager em;
    @Transactional
    public int registerPlayer(Player player){

        return em.createQuery("INSERT INTO Player p"
                        + " VALUES (id, name, gameId)"
                        + " WHERE p.id = :id", Player.class)
                .setParameter("id", player.getId())
                .executeUpdate();
    }

    @Transactional
    public Player getPlayerInfo(Long id){

        return em.createQuery("SELECT p FROM Player p"
                        + " WHERE p.id = :id", Player.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public boolean deletePlayer(Long id){

        em.createNativeQuery("DELETE FROM Player"
                        + " WHERE Player.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        return true;
    }
}
