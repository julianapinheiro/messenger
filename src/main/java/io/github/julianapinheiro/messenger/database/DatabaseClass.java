package io.github.julianapinheiro.messenger.database;

import io.github.julianapinheiro.messenger.model.Message;
import io.github.julianapinheiro.messenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}

