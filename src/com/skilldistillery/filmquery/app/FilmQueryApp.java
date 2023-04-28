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

	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);


		input.close();
	}

	private void startUserInterface(Scanner input) {
		int choice;
		do {
		System.out.println("Choose  one " 
		        + "\n 1 : look up film by film ID " 
				+ "\n 2 : look up film by keyword " 
		        + "\n 3 : exit ");
		
		choice= input.nextInt();
		
		switch (choice) {
		case 1:
			filmByFilmId();
			break;
		case 2:
			filmByKeyword();
			break;
		case 3:
			exit();
			break;
		default:
			System.out.println("Invalid input");
			}
		} while (choice != 3);
	}

	private void filmByFilmId() {
		System.out.println("enter film ID ");
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();

		Film film = db.findFilmById(in);
		if (film != null) {
			System.out.println(film);
		} else {
			System.out.println("no such film exists");

		}
	}
	private void filmByKeyword() {
		
	}
	private void exit() {
		System.out.println("thank you come again! ");
	}
}
