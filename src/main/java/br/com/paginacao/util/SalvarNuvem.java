package br.com.paginacao.util;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.microsoft.azure.storage.core.Base64;

public class SalvarNuvem {
	
	public static final String storageConnectionString = "DefaultEndpointsProtocol=http;"
			+ "AccountName=portalvhdsjg19kbq1q36k1;"
			+ "AccountKey=x3cW/427NHEp3OtXtuSYMTM2IgvhuC00JkASFPHJx6YcXFXEu9qvx2YWxm4cuRUsL7uwtN5bO7CK0P4hSu8wZg==";

	public String uploadFoto(String file, String nome, HttpServletRequest request) {
		String path = "";
		try {
			byte[] bytes = DatatypeConverter.parseBase64Binary((file.split(",")[1]));
			
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

			CloudBlobContainer container = blobClient.getContainerReference("togo");
			container.createIfNotExists();

			CloudBlockBlob blob = container.getBlockBlobReference(nome);
			blob.uploadFromByteArray(bytes, 0, bytes.length);
			
			path = "http://portalvhdsjg19kbq1q36k1.blob.core.windows.net/togo/" + blob.getName() + ".jpg";
		} catch (Exception e) {
			throw new RuntimeException();
		}

		return path;
	}

	public String downloadFoto(String nome, HttpServletRequest request){
		String file = "";
		byte[] buffer = null;
		try{
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
			
			CloudBlobContainer container = blobClient.getContainerReference("togo");
			
			 for (ListBlobItem blobItem : container.listBlobs()) {
			        
			        if (blobItem instanceof CloudBlob) {
			            
			            CloudBlob blob = (CloudBlob) blobItem;
			            if(blob.getName().equals(nome)){
			            	blob.downloadToByteArray(buffer, 0);
			            	
			            	file = Base64.encode(buffer);
			            }
			            
			        }
			  }
			 
			 
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return file;
	}

}

