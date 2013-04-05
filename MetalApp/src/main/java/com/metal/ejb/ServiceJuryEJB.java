package com.metal.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.metal.model.Participant;
import com.metal.model.ScoreMatrix;
import com.metal.model.Song;

/**
 * Vota por Concursante y Vota por Cancion
 */
@Stateless
@LocalBean
public class ServiceJuryEJB {

	@PersistenceContext(unitName = "MetalApp")
	private EntityManager em;

	/** Default constructor. */
	public ServiceJuryEJB() {
		super();
	}

	public Participant findParticipant(Long id) {
		return em.find(Participant.class, id);
	}

	public Song findSong(Long id) {
		return em.find(Song.class, id);
	}

	public void addVotePerParticipant(Participant participant) {
		TypedQuery<Participant> query = em.createNamedQuery("Participant.findByUsername", Participant.class)
				.setParameter("username", participant.getUsername());
		participant = query.getResultList().get(0);
		if (participant != null) {

			System.out.println("PARTICIPANT" + participant);//

			TypedQuery<ScoreMatrix> scoreQuery = em.createNamedQuery("ScoreMatrix.findByUsername",
					ScoreMatrix.class).setParameter("username", participant.getUsername());

			if (scoreQuery.getFirstResult() != 0) {
				ScoreMatrix score = scoreQuery.getResultList().get(0);
				System.out.println("SCORE" + score);

				score.setTotalScore(score.getTotalScore() + 1);
				participant.setScoreMatrix(score);
				em.persist(participant);

			} else {
				System.out.println("NO EXISTE SCORE PARA EL PARTICIPANTE");
			}

		} else {
			System.out.println("NO EXISTE EL PARTICIPANTE");
		}

	}

	public void addVotePerSong(Song song) {
		TypedQuery<Song> query = em.createNamedQuery("Song.findByTitle", Song.class).setParameter("title",
				song.getTitle());
		List<Song> songs = query.getResultList();
		if (songs.isEmpty()) {
			System.out.println("No songs");
		} else {
			System.out.println(songs.get(0));
		}
	}
}
