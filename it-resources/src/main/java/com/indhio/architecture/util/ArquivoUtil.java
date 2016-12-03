package com.indhio.architecture.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * ArquivUtil Utilitario para arquivos
 * 
 * @author Vinicius Nascimento
 * @version 1.0
 * 
 */
@Singleton
public final class ArquivoUtil {

	@PostConstruct
	public void init() {

	}

	public String getTmpDir() {
		return System.getProperty("java.io.tmpdir");
	}

	public File criarArquivoPorBytes(byte[] bytes) {
		File file = new File(this.getTmpDir() + File.separator + "arquivoTmp");
		try {
			FileOutputStream fileOuputStream = new FileOutputStream(file);
			fileOuputStream.write(bytes);
			fileOuputStream.close();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String encodeBase64(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}

	public byte[] decodeBase64(String str) {
		return Base64.getDecoder().decode(str);
	}

	public byte[] getBytes(File file) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		FileInputStream in = new FileInputStream(file);
		int b;
		while ((b = in.read()) > -1) {
			out.write(b);
		}
		out.close();
		in.close();
		return out.toByteArray();
	}

	/**
	 * Descompacta arquivos .ZIP e obtem o arquivo do mesmo
	 * 
	 * @param bytes
	 * @return
	 * @throws IOException
	 */
	public File descompactarArquivoZip(byte[] bytes) throws IOException {
		File ret = null;
		File origem = this.criarArquivoPorBytes(bytes);
		FileInputStream in = new FileInputStream(origem);

		ZipEntry ze = null;
		FileOutputStream out = null;
		ZipInputStream zin = new ZipInputStream(in);
		while ((ze = zin.getNextEntry()) != null) {
			ret = new File(ze.getName());
			out = new FileOutputStream(ret);
			for (int c = zin.read(); c != -1; c = zin.read()) {
				out.write(c);
			}
			zin.closeEntry();
			out.close();
			break;
		}
		zin.close();
		return ret;
	}

}
