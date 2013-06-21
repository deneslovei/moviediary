package org.nnc.moviediary.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.nnc.moviediary.domain.entities.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceUtil {

	private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);

	public static <E extends BaseEntity> List<E> convertIdsToDummyEntitiesToSave(final String[] ids, final Class<E> clazz) {
		if (ids == null) {
			return null;
		}
		List<E> list = new ArrayList<>(ids.length);
		for (String itemId : ids) {
			long id = Long.parseLong(itemId);
			try {
				E item = clazz.newInstance();
				item.setId(id);
				list.add(item);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
			}
		}
		return list;
	}

	public static List<String> validateCelebrity(final String celebrityId, final Boolean visible, final String name, final String imdbLink,
			final String[] featuredInIds, final String[] directedMoviesIds) {
		List<String> errors = new ArrayList<>();
		// TODO validateCelebrity
		return errors;
	}

	public static List<String> validateGenre(final String genreId, final Boolean visible, final String name, final String description, final String[] moviesIds) {
		List<String> errors = new ArrayList<>();
		// TODO validateGenre
		return errors;
	}
}
