import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Info {
	Info () {}
    private static final String FILEPATH = "C:/Users/Pavilion/Desktop/TP_lab/Tema2/";
		public void Scriere(String A, String B) {
			BufferedWriter bw =null;

			try {

				File file = new File(A);
				 
				// if file doesnt exists, then create it
				if (!file.exists()) 
				file.createNewFile();
				
				FileWriter fw =new FileWriter(file,true);
				bw = new BufferedWriter(fw);
				bw.write(B);
				bw.newLine();
				bw.close();
				

			} catch (IOException e) {

				System.err.println("Error writing the file : ");
				e.printStackTrace();
			}
		}
		

		}
	