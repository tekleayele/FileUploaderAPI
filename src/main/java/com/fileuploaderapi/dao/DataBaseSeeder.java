package com.fileuploaderapi.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fileuploaderapi.controller.FileMetaDataRepository;
import com.fileuploaderapi.controller.FileMetaDataVO;

/**
 * @author Tekle Ayele
 *
 */


@Component
public class DataBaseSeeder implements CommandLineRunner {

	private FileMetaDataRepository fileMetaDataRepository;

	public FileMetaDataRepository getFileMetaDataRepository() {
		return fileMetaDataRepository;
	}

	public void setFileMetaDataRepository(FileMetaDataRepository fileMetaDataRepository) {
		this.fileMetaDataRepository = fileMetaDataRepository;
	}

	@Autowired
	public DataBaseSeeder(FileMetaDataRepository fileMetaDataRepository) {
		this.fileMetaDataRepository = fileMetaDataRepository;
	}

	public void addMetaData(FileMetaDataVO fileMetaDataVO) throws Exception {
		List<FileMetaDataVO> fileMetaDataList = new ArrayList<FileMetaDataVO>();
		fileMetaDataList.add(fileMetaDataVO);

		fileMetaDataRepository.save(fileMetaDataList);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*
		 * Uncomment this line of code to add a sample data.
		 * 
		List<FileMetaDataVO> fileMetaDataList = new ArrayList<FileMetaDataVO>();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		fileMetaDataList.add(new FileMetaDataVO("Word File ", ".doc", 50, timestamp));
		fileMetaDataList.add(new FileMetaDataVO("Excel File ", ".xls", 70, timestamp));
		fileMetaDataList.add(new FileMetaDataVO("Power Point File ", ".ppt", 350, timestamp));
		fileMetaDataList.add(new FileMetaDataVO("Imgae File ", ".jpg", 1204, timestamp));
		fileMetaDataRepository.save(fileMetaDataList);
		*/
	}

}
