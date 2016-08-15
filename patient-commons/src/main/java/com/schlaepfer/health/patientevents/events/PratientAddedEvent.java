package com.schlaepfer.health.patientevents.events;

public class PratientAddedEvent extends AbstractEvent {

	private String name;

	public PratientAddedEvent() {
	}

	public PratientAddedEvent(String id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
