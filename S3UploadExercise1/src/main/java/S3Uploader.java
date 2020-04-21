import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;

public class S3Uploader
{
    public static void main(String[] args)
    {
        //Create an Amazon object for doing s3 operations
        AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();

        //1. get name of file to be copied from the command line
        String fileName = args[0];

        //2. get name of S3 bucket from the command line
        String bucketName = args[1];

        //3. upload file to the specified S3 bucket using the file name as the S3 key
        File fileToUpload = new File(fileName);

        if (!fileToUpload.exists())
        {
            System.err.println("File not found...");
            return;
        }

        String S3Key = args[2];

        PutObjectResult result = s3.putObject(bucketName, S3Key, fileToUpload);

        System.out.println(result.toString());
    }
}
