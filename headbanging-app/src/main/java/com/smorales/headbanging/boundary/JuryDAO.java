package com.smorales.headbanging.boundary;

import com.smorales.headbanging.entity.Participant;
import com.smorales.headbanging.entity.ScoreMatrix;
import com.smorales.headbanging.entity.Song;
import com.smorales.headbanging.entity.SongMatrix;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class JuryDAO {

    @PersistenceContext
    EntityManager em;

    public void votePerParticipant(Participant participant, Integer handPoints, Integer headPoints) {
        List<Participant> participants = em.createNamedQuery(Participant.FIND_BY_USERNAME, Participant.class)
                .setParameter("username", participant.getUsername())
                .getResultList();

        if (participants.isEmpty()) {
            throw new IllegalArgumentException("participant not found" + participant);
        }

        Participant participantToVote = participants.get(0);
        ScoreMatrix scoreMatrix = participantToVote.getScoreMatrix();
        if (scoreMatrix == null) {
            scoreMatrix = new ScoreMatrix();
            scoreMatrix.setParticipant(participantToVote);
        }

        scoreMatrix = addHandPointsToScoreMatrix(scoreMatrix, handPoints);
        scoreMatrix = addHeadPointsToScoreMatrix(scoreMatrix, headPoints);
        scoreMatrix = calculateTotalAverageScoreMatrix(scoreMatrix);
        scoreMatrix.setTotalScore(scoreMatrix.getTotalScore() + 1);
        participantToVote.setScoreMatrix(scoreMatrix);
        em.persist(participantToVote);
    }

    public void votePerSong(Song song, Integer compositionPoints, Integer musicalityPoints) {
        List<Song> songs = em.createNamedQuery(Song.FIND_BY_TITLE, Song.class)
                .setParameter("title", song.getTitle())
                .getResultList();

        if (songs.isEmpty()) {
            throw new IllegalArgumentException("song not found" + song);
        }

        Song theSongToVote = songs.get(0);
        SongMatrix songMatrix = theSongToVote.getSongMatrix();
        if (songMatrix == null) {
            songMatrix = new SongMatrix();
            songMatrix.setSong(theSongToVote);
        }

        songMatrix = addCompositionPointsToSongMatrix(songMatrix, compositionPoints);
        songMatrix = addMusicalityPoinstToSongMatrix(songMatrix, musicalityPoints);
        songMatrix = calculateTotalAverageSongScore(songMatrix);
        theSongToVote.setSongMatrix(songMatrix);
        em.persist(theSongToVote);
    }

    private ScoreMatrix calculateTotalAverageScoreMatrix(ScoreMatrix matrix) {

        Float totalHeadSum = (float) (matrix.getHead1() + matrix.getHead2() + matrix.getHead3() + matrix.getHead4()
                + matrix.getHead5() + matrix.getHead6() + matrix.getHead7() + matrix.getHead8() + matrix.getHead9() + matrix
                .getHead10());

        Float totalHeadAverage = (float) (totalHeadSum / 10.0);

        Float totalHandSum = (float) (matrix.getHand1() + matrix.getHand2() + matrix.getHand3() + matrix.getHand4()
                + matrix.getHand5() + matrix.getHand6() + matrix.getHand7() + matrix.getHand8() + matrix.getHand9() + matrix
                .getHand10());

        Float totalHandAverage = (float) (totalHandSum / 10.0);
        Float totalAverage = totalHeadAverage + totalHandAverage;
        matrix.setTotalScore(totalAverage);
        return matrix;
    }

    private SongMatrix calculateTotalAverageSongScore(SongMatrix matrix) {

        Float totalCompositionSum = (float) (matrix.getComposition1() + matrix.getComposition2()
                + matrix.getComposition3() + matrix.getComposition4() + matrix.getComposition5()
                + matrix.getComposition6() + matrix.getComposition7() + matrix.getComposition8()
                + matrix.getComposition9() + matrix.getComposition10());

        Float totalCompositionAverage = (float) (totalCompositionSum / 10.0);

        Float totalMusicalitySum = (float) (matrix.getMusicality1() + matrix.getMusicality2() + matrix.getMusicality3()
                + matrix.getMusicality4() + matrix.getMusicality5() + matrix.getMusicality6() + matrix.getMusicality7()
                + matrix.getMusicality8() + matrix.getMusicality9() + matrix.getMusicality10());

        Float totalMusicalityAverage = (float) (totalMusicalitySum / 10.0);

        Float totalAverage = totalCompositionAverage + totalMusicalityAverage;
        matrix.setTotalScore(totalAverage);
        return matrix;
    }

    private ScoreMatrix addHeadPointsToScoreMatrix(ScoreMatrix scoreMatrix, Integer points) {
        Integer totalPunctuation;

        switch (points) {
            case 1:
                totalPunctuation = (scoreMatrix.getHead1() + 1);
                scoreMatrix.setHead1(totalPunctuation);
                break;
            case 2:
                totalPunctuation = (scoreMatrix.getHead2() + 1);
                scoreMatrix.setHead2(totalPunctuation);
                break;
            case 3:
                totalPunctuation = (scoreMatrix.getHead3() + 1);
                scoreMatrix.setHead3(totalPunctuation);
                break;
            case 4:
                totalPunctuation = (scoreMatrix.getHead4() + 1);
                scoreMatrix.setHead4(totalPunctuation);
                break;
            case 5:
                totalPunctuation = (scoreMatrix.getHead5() + 1);
                scoreMatrix.setHead5(totalPunctuation);
                break;
            case 6:
                totalPunctuation = (scoreMatrix.getHead6() + 1);
                scoreMatrix.setHead6(totalPunctuation);
                break;
            case 7:
                totalPunctuation = (scoreMatrix.getHead7() + 1);
                scoreMatrix.setHead7(totalPunctuation);
                break;
            case 8:
                totalPunctuation = (scoreMatrix.getHead8() + 1);
                scoreMatrix.setHead8(totalPunctuation);
                break;
            case 9:
                totalPunctuation = (scoreMatrix.getHead9() + 1);
                scoreMatrix.setHead9(totalPunctuation);
                break;
            case 10:
                totalPunctuation = (scoreMatrix.getHead10() + 1);
                scoreMatrix.setHead10(totalPunctuation);
                break;

            default:
                break;
        }
        return scoreMatrix;
    }

    private ScoreMatrix addHandPointsToScoreMatrix(ScoreMatrix scoreMatrix, Integer points) {
        Integer totalPunctuation;

        switch (points) {
            case 1:
                totalPunctuation = (scoreMatrix.getHand1() + 1);
                scoreMatrix.setHand1(totalPunctuation);
                break;
            case 2:
                totalPunctuation = (scoreMatrix.getHand2() + 1);
                scoreMatrix.setHand2(totalPunctuation);
                break;
            case 3:
                totalPunctuation = (scoreMatrix.getHand3() + 1);
                scoreMatrix.setHand3(totalPunctuation);
                break;
            case 4:
                totalPunctuation = (scoreMatrix.getHand4() + 1);
                scoreMatrix.setHand4(totalPunctuation);
                break;
            case 5:
                totalPunctuation = (scoreMatrix.getHand5() + 1);
                scoreMatrix.setHand5(totalPunctuation);
                break;
            case 6:
                totalPunctuation = (scoreMatrix.getHand6() + 1);
                scoreMatrix.setHand6(totalPunctuation);
                break;
            case 7:
                totalPunctuation = (scoreMatrix.getHand7() + 1);
                scoreMatrix.setHand7(totalPunctuation);
                break;
            case 8:
                totalPunctuation = (scoreMatrix.getHand8() + 1);
                scoreMatrix.setHand8(totalPunctuation);
                break;
            case 9:
                totalPunctuation = (scoreMatrix.getHand9() + 1);
                scoreMatrix.setHand9(totalPunctuation);
                break;
            case 10:
                totalPunctuation = (scoreMatrix.getHand10() + 1);
                scoreMatrix.setHand10(totalPunctuation);
                break;

            default:
                break;
        }
        return scoreMatrix;
    }

    private SongMatrix addCompositionPointsToSongMatrix(SongMatrix songMatrix, Integer points) {

        Integer totalPunctuation;

        switch (points) {
            case 1:
                totalPunctuation = (songMatrix.getComposition1() + 1);
                songMatrix.setComposition1(totalPunctuation);
                break;
            case 2:
                totalPunctuation = (songMatrix.getComposition2() + 1);
                songMatrix.setComposition2(totalPunctuation);
                break;
            case 3:
                totalPunctuation = (songMatrix.getComposition3() + 1);
                songMatrix.setComposition3(totalPunctuation);
                break;
            case 4:
                totalPunctuation = (songMatrix.getComposition4() + 1);
                songMatrix.setComposition4(totalPunctuation);
                break;
            case 5:
                totalPunctuation = (songMatrix.getComposition5() + 1);
                songMatrix.setComposition5(totalPunctuation);
                break;
            case 6:
                totalPunctuation = (songMatrix.getComposition6() + 1);
                songMatrix.setComposition6(totalPunctuation);
                break;
            case 7:
                totalPunctuation = (songMatrix.getComposition7() + 1);
                songMatrix.setComposition7(totalPunctuation);
                break;
            case 8:
                totalPunctuation = (songMatrix.getComposition8() + 1);
                songMatrix.setComposition8(totalPunctuation);
                break;
            case 9:
                totalPunctuation = (songMatrix.getComposition9() + 1);
                songMatrix.setComposition9(totalPunctuation);
                break;
            case 10:
                totalPunctuation = (songMatrix.getComposition10() + 1);
                songMatrix.setComposition10(totalPunctuation);
                break;

            default:
                break;
        }
        return songMatrix;
    }

    private SongMatrix addMusicalityPoinstToSongMatrix(SongMatrix songMatrix, Integer points) {

        Integer totalPunctuation;
        switch (points) {
            case 1:
                totalPunctuation = (songMatrix.getMusicality1() + 1);
                songMatrix.setMusicality1(totalPunctuation);
                break;
            case 2:
                totalPunctuation = (songMatrix.getMusicality2() + 1);
                songMatrix.setMusicality2(totalPunctuation);
                break;
            case 3:
                totalPunctuation = (songMatrix.getMusicality3() + 1);
                songMatrix.setMusicality3(totalPunctuation);
                break;
            case 4:
                totalPunctuation = (songMatrix.getMusicality4() + 1);
                songMatrix.setMusicality4(totalPunctuation);
                break;
            case 5:
                totalPunctuation = (songMatrix.getMusicality5() + 1);
                songMatrix.setMusicality5(totalPunctuation);
                break;
            case 6:
                totalPunctuation = (songMatrix.getMusicality6() + 1);
                songMatrix.setMusicality6(totalPunctuation);
                break;
            case 7:
                totalPunctuation = (songMatrix.getMusicality7() + 1);
                songMatrix.setMusicality7(totalPunctuation);
                break;
            case 8:
                totalPunctuation = (songMatrix.getMusicality8() + 1);
                songMatrix.setMusicality8(totalPunctuation);
                break;
            case 9:
                totalPunctuation = (songMatrix.getMusicality9() + 1);
                songMatrix.setMusicality9(totalPunctuation);
                break;
            case 10:
                totalPunctuation = (songMatrix.getMusicality10() + 1);
                songMatrix.setMusicality10(totalPunctuation);
                break;

            default:
                break;
        }

        return songMatrix;
    }

}