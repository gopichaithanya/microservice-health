package com.schlaepfer.health.patientcommand.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class AddPatientCommand {

	@TargetAggregateIdentifier
	private final String id;
	private final String name;

	public AddPatientCommand(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
