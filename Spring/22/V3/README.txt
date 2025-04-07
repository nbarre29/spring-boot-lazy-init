
-> AWSS3Service.java is updated so that it reads the bucket name from application.properties rather than hardcoding it. Defined a property aws.s3.bucket-name in application.properties, then injected it with Spring’s @Value annotation.

1) application.properties

aws.s3.bucket-name=nbarres3


2) AWSS3Service.java

@Value("${aws.s3.bucket-name}")
    private String bucketName;  // read from application.properties