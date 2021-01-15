package com.example.entities.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.entities.Film;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FilmDetailsDTO {
	private int filmId;
	private String description;
	private int length;
	private String rating;
	private Short releaseYear;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private BigDecimal replacementCost;
	private String title;
	private String language;
	private String languageVO;
	private List<String> actors;
	private List<String> categories;
	
	public FilmDetailsDTO(Film source) {
		this(
			source.getFilmId(), 
			source.getDescription(),
			source.getLength(),
			source.getRating().getCode(),
			source.getReleaseYear(),
			source.getRentalDuration(),
			source.getRentalRate(),
			source.getReplacementCost(),
			source.getTitle(),
			source.getLanguage() == null ? null : source.getLanguage().getName(),
			source.getLanguageVO() == null ? null : source.getLanguageVO().getName(),
			source.getFilmActors().stream().map(item -> item.getActor().getFirstName() + " " + item.getActor().getLastName())
				.collect(Collectors.toList()),
			source.getFilmCategories().stream().map(item -> item.getCategory().getName())
				.collect(Collectors.toList())
			);
	}
	public static FilmDetailsDTO from(Film source) {
		return new FilmDetailsDTO(source);
	}

}
