package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PWD = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Film> findFilmsByKeyword(String keyword){
		List<Film> films = new ArrayList<>();
		
		  try {
		    Connection conn = DriverManager.getConnection(URL, USER, PWD);
		    String sql = "SELECT * "
		               + " FROM film "
		               + " WHERE "
		               + " title LIKE ?" //1
		               + " OR description LIKE ?	" //2
		               + " OR releas_year LIKE ?	" //3
		               + " OR language_id LIKE ?	" //4
		               + " OR rating LIKE ?	"  //5
		               + " OR special_features LIKE ?	"; //6
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, "%"+keyword+"%");
		    stmt.setString(2, "%"+keyword+"%");
		    stmt.setString(3, "%"+keyword+"%");
		    stmt.setString(4, "%"+keyword+"%");
		    stmt.setString(5, "%"+keyword+"%");
		    stmt.setString(6, "%"+keyword+"%");
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
//		      int filmId = rs.getInt("id");
//		      String title = rs.getString("title");
//		      String desc = rs.getString("description");
//		      short releaseYear = rs.getShort("release_year");
//		      int langId = rs.getInt("language_id");
//		      int rentDur = rs.getInt("rental_duration");
//		      double rate = rs.getDouble("rental_rate");
//		      int length = rs.getInt("length");
//		      double repCost = rs.getDouble("replacement_cost");
//		      String rating = rs.getString("rating");
//		      String features = rs.getString("special_features");
//		      
//		     Film film = new Film(filmId, title, desc, releaseYear, langId,
//		                           rentDur, rate, length, repCost, rating, features);
//		      films.add(film);
		    } 
		    rs.close();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return films;
		}


	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		 try {
			    Connection conn = DriverManager.getConnection(URL, USER, PWD);
			    String sql = "SELECT * "
			               + " FROM actor "
			               + " JOIN film_actor "
			               + " ON actor.id = film_actor.actor_id "
			               + " WHERE film_id = ?";
			    PreparedStatement stmt = conn.prepareStatement(sql);
			    stmt.setInt(1, filmId);
			    ResultSet rs = stmt.executeQuery();
			    while (rs.next()) {
			      int actorId = rs.getInt("id");
			      String fn = rs.getString("first_name");
			      String ln = rs.getString("last_name");
			    
			      Actor actor = new Actor(actorId, fn, ln);
			      actors.add(actor);
			    } 
			    rs.close();
			    stmt.close();
			    conn.close();
			  } catch (SQLException e) {
			    e.printStackTrace();
			  }
		return actors;
	}
	
	public List<Film> findFilmsByActorId(int actorId) {
		  List<Film> films = new ArrayList<>();
		  try {
		    Connection conn = DriverManager.getConnection(URL, USER, PWD);
		    String sql = "SELECT * "
		               + " FROM film "
		               + " JOIN film_actor "
		               + " ON film.id = film_actor.actor_id "
		               + " WHERE actor_id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, actorId);
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		      int filmId = rs.getInt("id");
		      String title = rs.getString("title");
		      String desc = rs.getString("description");
		      short releaseYear = rs.getShort("release_year");
		      int langId = rs.getInt("language_id");
		      int rentDur = rs.getInt("rental_duration");
		      double rate = rs.getDouble("rental_rate");
		      int length = rs.getInt("length");
		      double repCost = rs.getDouble("replacement_cost");
		      String rating = rs.getString("rating");
		      String features = rs.getString("special_features");
		      
		     Film film = new Film(filmId, title, desc, releaseYear, langId,
		                           rentDur, rate, length, repCost, rating, features);
		      films.add(film);
		    } 
		    rs.close();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return films;
		}
	@Override
	public Film findFilmById(int fId) {
		Film film = null;

		try {
			String sql = "SELECT * FROM film WHERE id = ?";
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, fId);
			ResultSet rs = stmt.executeQuery();
			// 5)iterate through results and display
			if (rs.next()) {
				int filmId = rs.getInt("id");
			      String title = rs.getString("title");
			      String desc = rs.getString("description");
			      short releaseYear = rs.getShort("release_year");
			      int langId = rs.getInt("language_id");
			      int rentDur = rs.getInt("rental_duration");
			      double rate = rs.getDouble("rental_rate");
			      int length = rs.getInt("length");
			      double repCost = rs.getDouble("replacement_cost");
			      String rating = rs.getString("rating");
			      String features = rs.getString("special_features");
			      film = new Film(filmId, title, desc, releaseYear, langId,
			                      rentDur, rate, length, repCost, rating, features);

			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			// 5)iterate through results and display
			if (actorResult.next()) {
				int id = actorResult.getInt("id");
				String fn = actorResult.getString("first_name");
				String ln = actorResult.getString("last_name");

				actor = new Actor(id, fn, ln);

				actor.setFilms(findFilmsByActorId(actorId));
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

}
