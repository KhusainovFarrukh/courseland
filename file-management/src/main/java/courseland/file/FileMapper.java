package courseland.file;

import courseland.file.dtos.FileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileMapper {

    @Mapping(target = "size", ignore = true)
    FileResponseDto toResponse(File file);
}
