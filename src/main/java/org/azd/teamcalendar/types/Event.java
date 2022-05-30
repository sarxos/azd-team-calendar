package org.azd.teamcalendar.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
	private @JsonProperty("category") String category;
	private @JsonProperty("description") String description;
	private @JsonProperty("endDate") String endDate;
	private @JsonProperty("startDate") String startDate;
	private @JsonProperty("title") String title;
	private @JsonProperty("id") String id;
	private @JsonProperty("__etag") int eTag;
}
