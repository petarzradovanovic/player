package com.example.player;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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

        if(dbPlayer == null) {
            em.persist(player);
            return player.getId();
        }
        return dbPlayer.getId();
    }

    @Transactional
    public Player getPlayerInfo(Long id)throws Exception {
        try {

        return em.createQuery("SELECT p FROM Player p"
                        + " WHERE p.id = :id", Player.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @Transactional
    public boolean deletePlayer(Long id)throws Exception{
        try {
            Query q = em.createNativeQuery("DELETE FROM Player"
                            + " WHERE Player.id = :id")
                    .setParameter("id", id);

            if(q.executeUpdate()!=-1) return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        return false;
    }

}
