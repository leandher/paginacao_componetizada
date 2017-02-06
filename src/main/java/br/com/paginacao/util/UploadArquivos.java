package br.com.paginacao.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

public class UploadArquivos {

	public String uploadAnexo(MultipartFile file, String nome, String pasta, HttpServletRequest request) {

		String path = "";
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String uploadsDir = "/public/" + pasta + "/";
			String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
			File dir = new File(realPathtoUploads);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + nome);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			System.out.println("Server File Location=" + serverFile.getAbsolutePath());
			path = pasta + "/" + nome;
		} catch (Exception e) {
			throw new RuntimeException();
		}

		return path;
	}

	public Boolean deleteAnexo(String anexo, HttpServletRequest request) {
		boolean delete = true;
		try {
			String uploadsDir = "/" + anexo;
			String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
			File inFile = new File(realPathtoUploads);
			delete = inFile.delete();

		} catch (Exception e) {
			throw new RuntimeException();
		}

		return delete;
	}

	public String uploadAnexo(FileItem file, String nome, String pasta, HttpServletRequest request) {

		String path = "";
		try {
			// Creating the directory to store file
			String uploadsDir = "/resources/" + pasta + "/";
			String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);

			File dir = new File(realPathtoUploads);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server

			nome = new StringHash().randomString(50) + nome;

			File serverFile = new File(dir.getAbsolutePath() + File.separator + nome);
			file.write(serverFile);
			System.err.println("Server File Location= " + serverFile.getAbsolutePath());
			path = pasta + "/" + nome;
		} catch (Exception e) {
			throw new RuntimeException();
		}

		return path;
	}

	public String uploadFoto(String file, String nome, String pasta, HttpServletRequest request){
		String path = "";
		try {
			byte[] bytes  = DatatypeConverter.parseBase64Binary((file.split(",")[1]));
			// Creating the directory to store file
			String uploadsDir = "/"+ pasta+ "/";
			String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
			File dir = new File(realPathtoUploads);
			if (!dir.exists())
				dir.mkdirs();
			
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + nome);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			
			System.out.println("Server File Location=" + serverFile.getAbsolutePath());
			path = pasta +"/"+nome;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return path;
	}
}
