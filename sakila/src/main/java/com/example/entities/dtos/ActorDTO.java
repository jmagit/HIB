package com.example.entities.dtos;

import com.example.entities.Actor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDTO {
	int id;
	String nombre;
	
	public ActorDTO(Actor source) {
		this(source.getActorId(), source.getFirstName() + " " + source.getLastName());
	}
}
