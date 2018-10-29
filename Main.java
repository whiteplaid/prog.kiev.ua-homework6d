package com.homework.multifilecopy;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File file = null;
		File target = null;
		ThreadFileCopy[] copy = new ThreadFileCopy[4];
		Thread[] tmp = new Thread[4];
		
			file = new File("src/com/homework/multifilecopy/folder/");
			target = new File("src/com/homework/multifilecopy/new folder/");
			if (!target.exists()) target.mkdirs();
					
			for (int i = 0; i < tmp.length; i++) {
				
				copy[i] = new ThreadFileCopy(file,target);
				tmp[i] = new Thread(copy[i]);
				
			}
			for (int i = 0; i < tmp.length;i++) {
				tmp[i].start();
			}

	}

}
