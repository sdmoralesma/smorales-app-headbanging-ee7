package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the song_matrix database table.
 * 
 */
@Entity
@Table(name="song_matrix")
public class SongMatrix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_song")
	private int idSong;

	@Column(name="composition_score")
	private float compositionScore;

	private int composition1;

	private int composition10;

	private int composition2;

	private int composition3;

	private int composition4;

	private int composition5;

	private int composition6;

	private int composition7;

	private int composition8;

	private int composition9;

	@Column(name="musicality_score")
	private float musicalityScore;

	private int musicality1;

	private int musicality10;

	private int musicality2;

	private int musicality3;

	private int musicality4;

	private int musicality5;

	private int musicality6;

	private int musicality7;

	private int musicality8;

	private int musicality9;

	@Column(name="total_score")
	private float totalScore;

	//bi-directional many-to-one association to Song
	@ManyToOne
	@JoinColumn(name="id_song1")
	private Song song;

	public SongMatrix() {
	}

	public int getIdSong() {
		return this.idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public float getCompositionScore() {
		return this.compositionScore;
	}

	public void setCompositionScore(float compositionScore) {
		this.compositionScore = compositionScore;
	}

	public int getComposition1() {
		return this.composition1;
	}

	public void setComposition1(int composition1) {
		this.composition1 = composition1;
	}

	public int getComposition10() {
		return this.composition10;
	}

	public void setComposition10(int composition10) {
		this.composition10 = composition10;
	}

	public int getComposition2() {
		return this.composition2;
	}

	public void setComposition2(int composition2) {
		this.composition2 = composition2;
	}

	public int getComposition3() {
		return this.composition3;
	}

	public void setComposition3(int composition3) {
		this.composition3 = composition3;
	}

	public int getComposition4() {
		return this.composition4;
	}

	public void setComposition4(int composition4) {
		this.composition4 = composition4;
	}

	public int getComposition5() {
		return this.composition5;
	}

	public void setComposition5(int composition5) {
		this.composition5 = composition5;
	}

	public int getComposition6() {
		return this.composition6;
	}

	public void setComposition6(int composition6) {
		this.composition6 = composition6;
	}

	public int getComposition7() {
		return this.composition7;
	}

	public void setComposition7(int composition7) {
		this.composition7 = composition7;
	}

	public int getComposition8() {
		return this.composition8;
	}

	public void setComposition8(int composition8) {
		this.composition8 = composition8;
	}

	public int getComposition9() {
		return this.composition9;
	}

	public void setComposition9(int composition9) {
		this.composition9 = composition9;
	}

	public float getMusicalityScore() {
		return this.musicalityScore;
	}

	public void setMusicalityScore(float musicalityScore) {
		this.musicalityScore = musicalityScore;
	}

	public int getMusicality1() {
		return this.musicality1;
	}

	public void setMusicality1(int musicality1) {
		this.musicality1 = musicality1;
	}

	public int getMusicality10() {
		return this.musicality10;
	}

	public void setMusicality10(int musicality10) {
		this.musicality10 = musicality10;
	}

	public int getMusicality2() {
		return this.musicality2;
	}

	public void setMusicality2(int musicality2) {
		this.musicality2 = musicality2;
	}

	public int getMusicality3() {
		return this.musicality3;
	}

	public void setMusicality3(int musicality3) {
		this.musicality3 = musicality3;
	}

	public int getMusicality4() {
		return this.musicality4;
	}

	public void setMusicality4(int musicality4) {
		this.musicality4 = musicality4;
	}

	public int getMusicality5() {
		return this.musicality5;
	}

	public void setMusicality5(int musicality5) {
		this.musicality5 = musicality5;
	}

	public int getMusicality6() {
		return this.musicality6;
	}

	public void setMusicality6(int musicality6) {
		this.musicality6 = musicality6;
	}

	public int getMusicality7() {
		return this.musicality7;
	}

	public void setMusicality7(int musicality7) {
		this.musicality7 = musicality7;
	}

	public int getMusicality8() {
		return this.musicality8;
	}

	public void setMusicality8(int musicality8) {
		this.musicality8 = musicality8;
	}

	public int getMusicality9() {
		return this.musicality9;
	}

	public void setMusicality9(int musicality9) {
		this.musicality9 = musicality9;
	}

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}