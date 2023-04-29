package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();
	
	private int in ;
	private String keyword;
	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Actor actor = db.findActorById(1);
		if (actor != null) {
			System.out.println(actor);
		} else {
			System.out.println("no such actor exists");
		}

		Film film = db.findFilmById(1);
		if (film != null) {
			System.out.println(film);
		} else {
			System.out.println("no such film exists");

		}

		List<Actor> actors = db.findActorsByFilmId(3);
		if (actors != null) {
			System.out.println(actors);
		} else {
			System.out.println("there were no actors in this film");
		}

		List<Film> films = db.findFilmsByActorId(3);
		if (films != null) {
			System.out.println(films);
		} else {
			System.out.println("this actor has not appeared in any films");
		}
		
		List<Film> films2 = db.findFilmsByKeyword("dog");
		if (films2 != null) {
			System.out.println(films2);
		}else {
			System.out.println("sorry no match, please try again ");
		}

	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) {
		int choice;
		do {
		System.out.println(" ----------------------------"
				+ "\n Choose  one " 
		        + "\n 1 : look up film by film ID " 
				+ "\n 2 : look up film by keyword " 
		        + "\n 3 : exit ");
		
		choice= input.nextInt();
		
		switch (choice) {
		case 1:
			
			filmByFilmId(input);
			
			break;
		case 2:
			
			filmByKeyword(input);
			
			break;
		case 3:
			exit();
			break;
		default:
			System.out.println("Invalid input");
			}
		} while (choice != 3);
	}
	private void subMenu(Scanner input) {

		System.out.println(" ----------------------------\n"
				+ "\n Choose  one "
				+ "\n 1 : Show all film details "
				+ "\n 2 : Return to Main Menu ");
		int choice;
		choice = input.nextInt();
		do {
		switch(choice) {
		case 1:
			filmDetails(input);
			break;
		case 2:
			System.out.println("returning to main menu");
			break;
		default:
			System.out.println("Invalid input, choose 1 or 2");
			break;
			}	
		} while (choice != 1);
		
	}
	private void filmDetails(Scanner input) {
		
		
		List<Film> films = filmKeyQuery(keyword);
		
		Film film = db.findFilmById(in);
		
		if (film != null) {
			System.out.println(film);
			System.out.print("Language :"); 
			langIdTranslator(film.getLangId());
		}
		
		if (films != null ) {
			for(Film films1 : films) {
				System.out.println(films1);
				System.out.print("Language :"); 
				langIdTranslator(film.getLangId());
			}
		}
	}
	
	private List<Film> filmKeyQuery(String keyword){
		return db.findFilmsByKeyword(keyword);
	}
	private void filmByFilmId(Scanner input) {
		
		System.out.println("enter film ID ");
		
		in = input.nextInt();

		Film film = db.findFilmById(in);
		if (film != null) {
			System.out.println(film.getTitle());
			System.out.println(film.getDesc());
			System.out.print("Language :"); 
			langIdTranslator(film.getLangId());
			System.out.println("Release year :"+film.getReleaseYear());
			System.out.println("Rating :"+film.getRating());
			List<Actor> actors = db.findActorsByFilmId(film.getFilmId());
			if (actors != null) {
				System.out.println("Actors : ");
				for(Actor actor : actors) {
					System.out.println("-"+actor.getFirstName() + " " + actor.getLastName());
				}
			} else {
				System.out.println("there were no actors in this film");
			
			} subMenu(input);
			
			System.out.println("\n");
			
		} else {
			System.out.println("no such film exists");

		}
		
	}
	
	
	private void filmByKeyword(Scanner input) {
		System.out.println("enter keyword ");
		
		keyword = input.next();
		//                                            1
		List<Film> films = db.findFilmsByKeyword(keyword);
		if (films != null) {
			for( Film film : films) {
				
				in = film.getFilmId();
				
				System.out.println(film.getTitle());
				System.out.println(film.getDesc());
				System.out.print("Language :"); 
				langIdTranslator(film.getLangId());
				System.out.println("Release year :"+film.getReleaseYear());
				System.out.println("Rating :"+film.getRating());
				List<Actor> actors = db.findActorsByFilmId(film.getFilmId());
				if (actors != null) {
					System.out.println("Actors : ");
					for(Actor actor : actors) {
						System.out.println("-"+actor.getFirstName() + " " + actor.getLastName());
					}
				} else {
					System.out.println("there were no actors in this film");
				}
			} subMenu(input);
			
		}else {
			System.out.println("sorry no match, please try again ");
		}		
	
	}
	
	private void langIdTranslator(int lang) {
		if (lang == 1) {
			System.out.println("English");
		}
		if (lang == 2) {
			System.out.println("Italian");
		}
		if (lang == 3) {
			System.out.println("Japanese");
		}
		if (lang == 4) {
			System.out.println("Mandrin");
		}
		if (lang == 5) {
			System.out.println("French");
		}
		if (lang == 6) {
			System.out.println("German");
		}
		
	}
	private void exit() {
		System.out.println("thank you come again! ");
	}
}
