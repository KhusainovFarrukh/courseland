package courseland.file;

import courseland.clients.FileResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileStorageService {

    FileResponseDto uploadFile(MultipartFile file) throws IOException;

    byte[] downloadFile(Long id);

    List<FileResponseDto> getAllFiles();

    FileResponseDto getFile(Long id);

    void deleteFile(Long id);

    void checkFileId(Long id);
}
