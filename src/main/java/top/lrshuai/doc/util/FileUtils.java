package top.lrshuai.doc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.util.ResourceUtils;

public class FileUtils {

	public static String getText(String path){
		String result="";
		FileReader fr =null;
		BufferedReader bfr = null;
		try {
			File file = ResourceUtils.getFile("classpath:"+path);
			fr = new FileReader(file);
			bfr = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line="";
			while((line=bfr.readLine()) != null){
				sb.append(line);
			}
			result = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bfr.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
