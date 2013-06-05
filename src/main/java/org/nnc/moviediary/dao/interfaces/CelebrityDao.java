package org.nnc.moviediary.dao.interfaces;

import java.util.List;

import org.nnc.moviediary.domain.entities.Celebrity;

public interface CelebrityDao {

	void saveCelebrity(Celebrity celebrity);

	List<Celebrity> getAllCelebrities();

}
