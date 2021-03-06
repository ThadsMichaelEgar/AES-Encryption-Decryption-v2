import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.security.*;
import javax.crypto.*;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException
	{
		//create temp key and encryptor
		String key = "5d3d2d5d8g4b1g3d";
		Encryptor e = new Encryptor(key);
		Decryptor d = new Decryptor(key);
		
		//Test file
		File file = new File("Test.txt");
		
		try{
		//create new file for input encrypted text to go in
		File newFile = new File("Encrypted.txt");
		
		if(file.createNewFile())
		{
			
		}else{
			System.out.println("File already exists.");
		}
		
		//create file writer for encrypted file
		FileWriter write = new FileWriter(newFile);

			
		//Input string and encrypted string
		String input;
		String encrypt;
		
		Scanner scan = new Scanner(file);
		
		//go through entire text file and encrypt line by line
		//after insert it into encrypted text
		while(scan.hasNext()){
			input = scan.nextLine();
			encrypt = e.encrypt(input);
			
			write.write(encrypt+"\n");
		}
		write.close();
		//decrypt
		String decrypt;
		
		File newFile2 = new File("Decrypted.txt");
		FileWriter write2 = new FileWriter(newFile2);
		if(newFile2.createNewFile())
		{
			
		}else{
			System.out.println("File already exists.");
		}
		//scan encryptedfile
		Scanner scan2 = new Scanner(newFile);
		while(scan2.hasNext())
		{
			input = scan2.nextLine();
			decrypt = d.decrypt(input);
			
			write2.write(decrypt+"\n");
		}
		write2.close();
	
		
			
		}catch(Exception exception)
		{
			System.out.println(exception.toString());
		}	
	}

}