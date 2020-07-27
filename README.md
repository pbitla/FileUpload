This example uses the Jsch library to connect and to do sftp operations.

we do have other libraries available to perform same operations.

Maven library:
		<dependency>
			<groupId>com.jcraft</groupId>
			<artifactId>jsch</artifactId>
			<version>0.1.55</version>
		</dependency>

steps:

step 1:
Simplest docker run example
docker run -p 22:22 -d atmoz/sftp foo:pass:::upload

step 2:
change config params in the code

step 3:
use filezilla to view the uploaded files
connect with these params in fileZilla
host : sftp://127.0.0.1
username: foo
password: pass


