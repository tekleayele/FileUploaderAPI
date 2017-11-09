package com.fileuploaderapi.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Tekle Ayele
 *
 */

@RestController
@RequestMapping(value = "/FileUploaderAPI")
@Api(
        name = "File Uploader API",
        description = "Provides a list of methods to upload Filter and store meta data in reference to the file.",
        stage = ApiStage.RC)
public class FileUploaderWSController {

    private FileMetaDataRepository fileMetaDataRepository;

    @Autowired
    public FileUploaderWSController(FileMetaDataRepository fileMetaDataRepository){
        this.fileMetaDataRepository = fileMetaDataRepository;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all the meta data info's of all the uploaded files.")
    public List<FileMetaDataVO> getAll(){
        return fileMetaDataRepository.findAll();
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiMethod(description = "Uploads a specific file to the server and stores the meta data info in the db.")
    public ModelAndView  uploadFile(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, HttpServletResponse response) throws NumberFormatException, IOException {

    	FileMetaDataVO fileMetaDataVO = new FileMetaDataVO();
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	fileMetaDataVO.setName(file.getOriginalFilename());
    	fileMetaDataVO.setType(file.getContentType());
    	fileMetaDataVO.setSize(file.getSize());
    	fileMetaDataVO.setCreatedTimeStamp(timestamp);
    	
    	fileMetaDataRepository.save(fileMetaDataVO);
    	
    	return new ModelAndView("redirect:" + "/");
    }
    
    @RequestMapping(value = "/search/{fileName}", method = RequestMethod.GET)
    @ApiMethod(description = "Search File Meta Data DB based on the file name")
    public List<FileMetaDataVO> searchFileByName(@ApiPathParam(name = "fileName") @PathVariable String fileName){
        return fileMetaDataRepository.findByNameIgnoreCaseContaining(fileName);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove the file from the meta data db.")
    public ModelAndView deleteFile(@ApiPathParam(name = "id") @PathVariable long id){
    	System.out.println(id);
    	fileMetaDataRepository.delete(id);

    	return new ModelAndView("redirect:" + "/");
    }
    
}