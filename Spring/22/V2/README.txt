-> 
Amazon recommends AWS SDK v2.

1) Updated to use jdk 21

2) <dependency>
			<groupId>io.awspring.cloud</groupId>
			<artifactId>spring-cloud-aws-context</artifactId>
			<version>2.4.4</version>
		</dependency>

		<dependency>
			<groupId>io.awspring.cloud</groupId>
			<artifactId>spring-cloud-aws-autoconfigure</artifactId>
			<version>3.3.0</version>
		</dependency>
		
Removed the above two AWS SDK V1 dependencies


2) pom.xml has only the AWS SDK v2 dependency,

<dependency>
			<groupId>software.amazon.awssdk</groupId>
			<artifactId>s3</artifactId>
			<version>2.31.16</version>
			<scope>compile</scope>
		</dependency>
		

3) In AWSS3Service.java removed all com.amazonaws.services.s3.* imports and add v2 imports:

4) Added AwsConfig.java that produces a S3Client bean.

__________________________________________________________________________________________________

-> Unsatisfied dependency expressed through field 's3Client': 
No qualifying bean of type 'software.amazon.awssdk.services.s3.S3Client' available

This means Spring can’t find a S3Client bean to inject. In AWS SDK v2, you must manually create and register the S3Client bean (unlike v1’s Spring Cloud AWS autoconfiguration).

Below is a minimal setup to fix this:


Define a Configuration Class

Create a class (e.g. AwsConfig.java) that produces a S3Client bean:

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                            AwsBasicCredentials.create(accessKey, secretKey)
                        )
                )
                .region(Region.of(region))
                .build();
    }
}


This class defines how to build and return a S3Client object.

Spring Boot will pick it up if the package is scanned (e.g., same package or a subpackage of your main application class).
__________________________________________________________________________________________________
