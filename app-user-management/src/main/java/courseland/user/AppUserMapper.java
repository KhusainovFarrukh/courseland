package courseland.user;

import courseland.user.dtos.AppUserResponseDto;
import courseland.user.dtos.AppUserRequestDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    @Mapping(target = "id", ignore = true)
    AppUser toEntity(AppUserRequestDto request);

    AppUserResponseDto toResponse(AppUser user);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(AppUserRequestDto request, @MappingTarget AppUser user);
}
