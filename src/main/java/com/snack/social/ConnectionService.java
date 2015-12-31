package com.snack.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {
	@Autowired
	ConnectionRepository connectionRepository;

	public String getImageUrl() {
		String imageUrl = null;
		List<Connection<?>> connections = connectionRepository.findConnections("facebook");
		if (!connections.isEmpty()) {
			imageUrl = connections.get(0).getImageUrl();
		}
		return imageUrl;
	}
}
