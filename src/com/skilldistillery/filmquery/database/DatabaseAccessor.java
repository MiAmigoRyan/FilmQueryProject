package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Copies;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  Film findFilmById(int filmId);
  Actor findActorById(int actorId) ;
  List<Actor> findActorsByFilmId(int filmId);
  List<Film> findFilmsByActorId(int actorId);
  List<Film> findFilmsByKeyword(String keyword);
  Category findCategoryByFilmId(Integer filmId) ;
  List<Copies> findCopiesById(int filmId);

}
