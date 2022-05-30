package org.azd.teamcalendar;

import static org.azd.enums.RequestMethod.GET;
import static org.azd.utils.Client.send;

import org.azd.connection.Connection;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.teamcalendar.types.EventList;
import org.azd.utils.AzDAsyncApi;


/***
 * API to manage Team Calendar extension data.
 *
 * @author Bartosz Firyn (sarxos)
 */
public class TeamCalendarApi extends AzDAsyncApi<TeamCalendarApi> implements TeamCalendar {

	private static final String API_VERSION = "6.1-preview.1";
	private static final String RESOURCE_ID = "extensionmanagement";
	private static final JsonMapper MAPPER = new JsonMapper();

	private final Connection conn;

	/**
	 * Pass the connection object to work with Team Calendar API.
	 *
	 * @param conn the {@link Connection} object
	 */
	public TeamCalendarApi(final Connection conn) {
		this.conn = conn;
	}

	@Override
	public EventList getEvents(final String teamId, final int month, final int year) throws AzDException {

		final var area = "extensionmanagement/installedextensions";
		final var id = "ms-devlabs/team-calendar";
		final var calendar = teamId + "." + month + "." + year;
		final var resource = "Data/Scopes/Default/Current/Collections/" + calendar + "/Documents";

		final var response = send(GET, conn, RESOURCE_ID, null, area, id, resource, API_VERSION, null, null);

		return MAPPER.mapJsonResponse(response, EventList.class);
	}
}
