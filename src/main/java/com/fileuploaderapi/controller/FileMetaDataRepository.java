package com.fileuploaderapi.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tekle Ayele
 *
 */


@Repository
public interface FileMetaDataRepository extends JpaRepository<FileMetaDataVO, Long> {
	
	// Search Functionality by file name. 
	List<FileMetaDataVO> findByNameIgnoreCaseContaining(String name); 
	
}
