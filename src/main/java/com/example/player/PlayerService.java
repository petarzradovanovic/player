package com.example.player;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PlayerService {

    @PersistenceContext
    private EntityManager em;
    @Transactional
    public Long registerPlayer(Player player){
        Player dbPlayer = null;
        try{
            dbPlayer = em.createQuery( "SELECT p FROM Player p"
                            + " WHERE p.gameId = :game_id", Player.class)
                    .setParameter("game_id", player.getGameId())
                    .getSingleResult();
        } catch(Exception e){e.printStackTrace();}
        System.out.println(player.getGameId());
        if(dbPlayer == null) {
            em.persist(player);
            return player.getId();
        }
        return dbPlayer.getId();

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
