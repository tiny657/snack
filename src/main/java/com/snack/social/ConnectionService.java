package com.snack.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {

	@Autowired
	private ConnectionRepository connectionRepository;

	public Connection<?> getConnection() {
		Connection<?> connection = null;
		List<Connection<?>> connections = connectionRepository.findConnections("facebook");
		if (!connections.isEmpty()) {
			connection = connections.get(0);
		}
		return connection;
	}
}
