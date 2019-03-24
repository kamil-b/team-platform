package pl.kassad.teamplatform.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import pl.kassad.teamplatform.services.UserService;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final String secret;
    private final String clientId;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService customUserDetailsService;

    public AuthorizationServerConfiguration(@Value("${security.oauth2.client.client-id}") String secret,
                                            @Value("${security.oauth2.client.client-secret}") String clientId) {
        this.secret = secret;
        this.clientId = clientId;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(secret)
                .secret("{noop}" + clientId)
                .scopes("read", "write")
                .authorizedGrantTypes("password", "client_credentials");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer configurer) {
        configurer.authenticationManager(authenticationManager);
        configurer.userDetailsService(customUserDetailsService);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

}