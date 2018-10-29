package com.homework.multifilecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadFileCopy implements Runnable {
	private File source;
	private File targetDir;

	

	public ThreadFileCopy(File source, File targetDir) {
		super();
		this.source = source;
		this.targetDir = targetDir;
	}


	public ThreadFileCopy() {
		super();
		// TODO Auto-generated constructor stub
	}


	public File getSource() {
		return source;
	}


	public void setSource(File source) {
		this.source = source;
	}



	public File getTargetDir() {
		return targetDir;
	}


	public void setTargetDir(File targetDir) {
		this.targetDir = targetDir;
	}

	
	private void FileCopyThread(File source, File targetDir) throws IOException {
		
		
			
			File tmpOne = new File (targetDir,"" + source.getName());

				if (!tmpOne.exists()) {
				
				FileInputStream tmp = new FileInputStream(source);
				FileOutputStream finish = new FileOutputStream(tmpOne);
				byte[] b = new byte[(int)source.length()];
					while ((tmp.read(b)) != -1) {
						finish.write(b);
					}
					finish.close();
					tmp.close();
					
				};
		
			
	}


	@Override
	public void run() {
		
			
		
		long start = System.currentTimeMillis();
		File[] paths;
		
		
		paths = getSource().listFiles();
		
		
		
		for (File path : paths) {

			
			File tmpOne = new File (targetDir,"" + path.getName());
			
						try {
							if (!tmpOne.exists()) {
							FileCopyThread(path,getTargetDir());
							System.out.println(Thread.currentThread().getName() + " " + path.getName());
							}
						} catch (IOException e) {
							System.out.println("!");
						}
						
		}
					
		
			
			
		

		System.out.println(Thread.currentThread().getName() + " " + (System.currentTimeMillis() - start) + "ms");
		
	}


}
