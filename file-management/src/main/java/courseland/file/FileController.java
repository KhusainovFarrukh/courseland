package courseland.file;

import courseland.clients.FileResponseDto;
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
        return ResponseEntity.status(HttpStatus.OK).body(fileStorageService.uploadFile(file));
    }

    @GetMapping(value = "download/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        return ResponseEntity.ok().body(fileStorageService.downloadFile(id));
    }

    @GetMapping()
    public ResponseEntity<List<FileResponseDto>> getFiles() {
        return ResponseEntity.status(HttpStatus.OK).body(fileStorageService.getAllFiles());
    }

    @GetMapping("{id}")
    public ResponseEntity<FileResponseDto> getFile(@PathVariable Long id) {
        return ResponseEntity.ok(fileStorageService.getFile(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        fileStorageService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("check-file-id/{id}")
    public void checkFileId(@PathVariable Long id) {
        fileStorageService.checkFileId(id);
    }
}
