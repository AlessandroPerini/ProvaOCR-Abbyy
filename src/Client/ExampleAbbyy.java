
package Client;

import Utils.Supporto;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author aless
 */
public class ExampleAbbyy {
    
    public static void main(String[] args) throws Exception {
        
        Supporto prova = new Supporto("Prova");
        prova.timerStart();
        int i;
        String estensione[] = {"","png","jpg","tif","tif","tif","tif","png",
                                  "jpg","jpg","png","jpg","jpg","jpg","tif",
                                  "tif","png","gif","gif","png","png"};
        
        for (i = 1; i < 21; i++) {
            
            Ocr ocr = new Ocr();
            Supporto supporto = new Supporto("Abbyy");
            String fileIn = "C:\\Users\\aless\\Desktop\\scanned_doc\\dir"+i+"\\img"+i+"."+estensione[i];
            String fileOut = "src/File/output.txt";
            
            args = new String[2];
            args[0] = fileIn;
            args[1] = fileOut;            
            Vector<String> argList = new Vector<String>(Arrays.asList(args));
            
            supporto.timerStart();
            ocr.performRecognition(argList);
            supporto.timerStop();
            System.out.println("\n - "+fileIn);
            supporto.fileOut(fileIn, new File(fileOut));
        }
        
        System.out.println("\nTempo totale: "+prova.timerStop());
    }
    
}
