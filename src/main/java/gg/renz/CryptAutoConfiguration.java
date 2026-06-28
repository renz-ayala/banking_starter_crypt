package gg.renz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class CryptAutoConfiguration {
    // ./gradlew publishToMavenLocal

    @Value("${secret_keys.codes.crypt_key}")
    private String cryptoKey;

    @Bean
    public CryptUtil cryptUtil() {
        return new CryptUtil(cryptoKey);
    }
}
