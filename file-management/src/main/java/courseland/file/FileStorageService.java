package courseland.file;

import courseland.file.dtos.FileResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileStorageService {

    FileResponseDto store(MultipartFile file) throws IOException;

    byte[] downloadFile(Long id);

    List<FileResponseDto> getAllFiles();

    void deleteFile(Long id);
}
