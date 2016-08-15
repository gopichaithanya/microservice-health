package com.schlaepfer.health.patientquery.handlers;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.schlaepfer.health.patientevents.events.PratientAddedEvent;
import com.schlaepfer.health.patientquery.domain.Patient;
import com.schlaepfer.health.patientquery.repository.PatientRepository;

public class PatientViewEventHandler implements ReplayAware {

	private static final Logger LOG = LoggerFactory.getLogger(PatientViewEventHandler.class);

	@Autowired
	private PatientRepository patientRepository;

	@EventHandler
	public void handle(PratientAddedEvent event) {
		LOG.info("PatientAddedEvent: [{}] '{}'", event.getId(), event.getName());
		patientRepository.save(new Patient(event.getId(), event.getName()));
	}

	public void beforeReplay() {
		LOG.info("Event Replay is about to START. Clearing the View...");
	}

	public void afterReplay() {
		LOG.info("Event Replay has FINISHED.");
	}

	public void onReplayFailed(Throwable cause) {
		LOG.error("Event Replay has FAILED.");
	}
}
