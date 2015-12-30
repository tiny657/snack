package com.snack.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/*
CREATE TABLE `UserConnection` (
  `userId` varchar(255) NOT NULL,
  `providerId` varchar(255) NOT NULL,
  `providerUserId` varchar(255) NOT NULL DEFAULT '',
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(512) NOT NULL,
  `secret` varchar(512) DEFAULT NULL,
  `refreshToken` varchar(512) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

@Getter
@Setter
@Entity
@IdClass(ProjectId.class)
@Table(name = "UserConnection", uniqueConstraints = {
	@UniqueConstraint(name = "UserConnectionRank", columnNames = { "userId", "providerId", "rank" }) })
public class UserConnection {
	@Id
	@Column(nullable = false, name = "userId")
	private String userId;

	@Id
	@Column(nullable = false, name = "providerId")
	private String providerId;

	@Id
	@Column(nullable = false, name = "providerUserId", columnDefinition = "VARCHAR(255) DEFAULT ''")
	private String providerUserId;

	@Column(nullable = false)
	private Integer rank;

	@Column(nullable = false, name = "displayName")
	private String displayName;

	@Column(nullable = false, name = "profileUrl", length = 512)
	private String profileUrl;

	@Column(nullable = false, name = "imageUrl", length = 512)
	private String imageUrl;

	@Column(nullable = false, name = "accessToken", length = 512)
	private String accessToken;

	@Column(nullable = false, length = 512)
	private String secret;

	@Column(nullable = false, name = "refreshToken", length = 512)
	private String refreshToken;

	@Column(nullable = false, name = "expireTime")
	private Long expireTime;
}
