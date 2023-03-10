package courseland.file;

import courseland.file.dtos.FileResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<FileResponseDto> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(fileStorageService.store(file));
    }

    @GetMapping()
    public ResponseEntity<List<FileResponseDto>> getListFiles() {
        List<FileResponseDto> files = fileStorageService.getAllFiles();
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        return ResponseEntity.ok().body(fileStorageService.downloadFile(id));
    }

    @DeleteMapping("{file-name}")
    public ResponseEntity<?> deleteFile(@PathVariable(value = "file-name") Long id) {
        fileStorageService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}
