package in.bushansirgur.springbootfileupload.service;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Utilities;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class AWSS3Service implements FileService {

	@Autowired
	private S3Client s3Client;  // v2 S3Client

	private final String BUCKET_NAME = "nbarres3"; // or read from app properties

	@Override
	public String uploadFile(MultipartFile file) {
		String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
		String key = UUID.randomUUID().toString() + "." + filenameExtension;

		PutObjectRequest putObjectRequest = PutObjectRequest.builder()
				.bucket(BUCKET_NAME)
				.key(key)
				.acl(ObjectCannedACL.PUBLIC_READ)
				.contentType(file.getContentType())
				.build();

		try {
			s3Client.putObject(
					putObjectRequest,
					RequestBody.fromInputStream(file.getInputStream(), file.getSize())
			);
		} catch (IOException ex) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR,
					"An exception occurred while uploading the file",
					ex
			);
		}

		// Generate a public URL for the uploaded object
		S3Utilities utilities = s3Client.utilities();
		URL url = utilities.getUrl(
				GetUrlRequest.builder()
						.bucket(BUCKET_NAME)
						.key(key)
						.build()
		);

		return url.toString();
	}
}
