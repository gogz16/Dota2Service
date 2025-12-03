package a.syrov.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtTokenGatewayFilterFactory.Config> {

    public JwtTokenGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) ->
            exchange.getPrincipal()
                    .flatMap(principal -> {
                        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) principal;
                        DefaultOidcUser defaultOidcUser = (DefaultOidcUser) oAuth2AuthenticationToken.getPrincipal();
                        String tokenValue = defaultOidcUser.getIdToken().getTokenValue();
                        if (tokenValue != null) {
                            exchange.getRequest().mutate()
                                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenValue)
                                    .build();
                        }
                        return chain.filter(exchange);
                    });
    }

    public static class Config{

    }
}
