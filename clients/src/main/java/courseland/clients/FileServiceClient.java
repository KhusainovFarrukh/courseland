package courseland.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("file-management")
public interface FileServiceClient {

    @GetMapping("/api/v1/files/{id}")
    ResponseEntity<FileResponseDto> getFile(@PathVariable Long id);

    @GetMapping("/api/v1/files/check-file-id/{id}")
    void checkFileId(@PathVariable Long id);
}
