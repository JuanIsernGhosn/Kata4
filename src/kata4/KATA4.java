/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class KATA4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String path = "C:\\Users\\usuario\\Documents\\";
        File file = new File(path);
        
        String[] fileList = file.list();
        
        for (String fileList1 : fileList) {
            //System.out.println(fileList1);
        }
        
        //print(file.listFiles(),"");
        
        String from = "C:\\Users\\usuario\\Downloads\\SDCardStandardv1.9.pdf";
        String to = "C:\\Users\\usuario\\Downloads\\SDCardStandardv1.9(1).pdf";
        
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        
        byte[] buffer = new byte[1024];
        
        Date date = new Date();
        
        while (true){
            int read = input.read(buffer);
            if (read < 0){
                break;
            }
            output.write(buffer);
        }
        
        System.out.println(new Date().getTime()-date.getTime()+"mseg");
        
        input.close();
        output.flush();
        output.close();
    }

    private static void print(File[] listFiles, String ident) {
        if (listFiles == null){
            return;
        }
        for (File listFile : listFiles) {
            System.out.println(ident+(listFile.isDirectory()?"+":"  ")+listFile.getName());
            if (listFile.isFile()||listFile.isHidden()) continue;
                print(listFile.listFiles(), ident+" ");
            
        }
    }

}
