package com.schlaepfer.health.patientcommand.aggregates;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schlaepfer.health.patientcommand.commands.AddPatientCommand;
import com.schlaepfer.health.patientevents.events.PratientAddedEvent;

public class PatientAggregate extends AbstractAnnotatedAggregateRoot {

	private static final Logger LOG = LoggerFactory.getLogger(PatientAggregate.class);

	@AggregateIdentifier
	private String id;
	private String name;

	public PatientAggregate() {
	}

	@CommandHandler
	public PatientAggregate(AddPatientCommand command) {
		LOG.debug("Command: 'AddPatientCommand' received.");
		LOG.debug("Queuing up a new PatientAddedEvent for patient '{}'", command.getId());
		apply(new PratientAddedEvent(command.getId(), command.getName()));
	}

	@EventSourcingHandler
	public void on(PratientAddedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		LOG.debug("Applied: 'PatientAddedEvent' [{}] '{}'", event.getId(), event.getName());
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
