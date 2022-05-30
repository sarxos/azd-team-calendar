package org.azd.teamcalendar.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class EventList {
	private @JsonProperty("count") int count;
	private @JsonProperty("value") List<Event> events;
}
