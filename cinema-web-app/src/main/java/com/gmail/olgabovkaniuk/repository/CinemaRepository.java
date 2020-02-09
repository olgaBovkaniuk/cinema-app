package com.gmail.olgabovkaniuk.repository;

import com.gmail.olgabovkaniuk.domain.Director;
import com.gmail.olgabovkaniuk.domain.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CinemaRepository {

    private static Logger log = Logger.getLogger("CinemaRepository");

    @PersistenceContext
    private EntityManager entityManager;

    public List<Film> getFilms(Date from, Date to, Long directorId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> film = query.from(Film.class);
        Join<Film, Director> director = film.join("director", JoinType.INNER);

        query.select(film);

        List<Predicate> predicates = new ArrayList<>();

        if (directorId != null) {
            predicates.add(cb.equal(director.get("id"), directorId));
        }
        if (from != null) {
            predicates.add(cb.greaterThanOrEqualTo(film.get("releaseDate"), from));
        }
        if (to != null) {
            predicates.add(cb.lessThanOrEqualTo(film.get("releaseDate"), to));
        }

        if (!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[0]));
        }
        TypedQuery<Film> query1 = entityManager.createQuery(query);
        List<Film> results = query1.getResultList();

        return results;
    }

    public Director findDirectorById(Long directorId) {
        try {
            return entityManager
                    .createQuery("from director where id =:dirId", Director.class)
                    .setParameter("dirId", directorId)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}
