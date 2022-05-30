package org.azd.teamcalendar;

import org.azd.exceptions.AzDException;
import org.azd.teamcalendar.types.EventList;


public interface TeamCalendar {
	EventList getEvents(final String teamId, final int month, final int year) throws AzDException;
}
