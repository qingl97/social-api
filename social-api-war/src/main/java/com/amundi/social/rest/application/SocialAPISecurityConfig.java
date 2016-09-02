//package com.amundi.social.rest.application;
//
//import com.amundi.services.server.AmundiMessages;
//import com.amundi.services.server.config.security.DefaultAmundiSecurityFeatureConfig;
//import com.amundi.services.server.security.authenticator.session.DeprecatedHttpSessionAuthenticator;
//
//import net.active.services.common.security.HttpAuthenticationScheme;
//import net.active.services.server.security.HttpAuthenticationFilter.AuthenticationConfig;
//import net.active.services.server.security.core.authenticator.HttpAuthenticator;
//import net.active.services.server.security.core.authenticator.basic.HttpBasicCustomAuthenticator;
//
//public class SocialAPISecurityConfig extends DefaultAmundiSecurityFeatureConfig {
//
//	public static final String REALM="SOCIAL.API";
//
//	@Override
//	protected HttpAuthenticator[] buildAvailableHttpAuthenticators() {
//		return new HttpAuthenticator[] {
//				new DeprecatedHttpSessionAuthenticator.Builder(
//						new HttpBasicCustomAuthenticator()).useXsrfToken(false).build() };
//	}
//
//	@Override
//	protected AuthenticationConfig buildDefaultAuthenticationConfig() {
//		return new AuthenticationConfig(
//				REALM,
//				new String[] { HttpAuthenticationScheme.BASIC },
//				AmundiMessages.NOT_AUTHORIZED_MESSAGE);
//	}
//
//}
