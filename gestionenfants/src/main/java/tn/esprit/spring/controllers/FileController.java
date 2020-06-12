package tn.esprit.spring.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import tn.esprit.spring.entity.DBFile;
import tn.esprit.spring.entity.UploadFileResponse;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.DBFileStorageService;
@RequestMapping(value = "/file")
@RestController
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;
    @Autowired
    UserRepository userRepository;
    
    
    @GetMapping(path = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable(name = "id") int id) throws IOException {

		User club = userRepository.getOne((long) id);
		String imagePath = club.getIdImage();
		File f = new File(imagePath);
		Path path = Paths.get(f.toURI());
		return Files.readAllBytes(path);

	}
    
    
    
    
    
    @PostMapping("/add")
	public User UploasdFile(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("C:\\khaoulaFile\\" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		User user = new User();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		user.setImageName(fileName);
		user.setIdImage(convertFile.toString());
		userRepository.save(user);
		return user;
	}
    
    
    
    
    
    
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        DBFile dbFile = dbFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

}
