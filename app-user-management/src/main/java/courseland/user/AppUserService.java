package courseland.user;

import courseland.user.dtos.AppUserRequestDto;
import courseland.user.dtos.AppUserResponseDto;

import java.util.List;

public interface AppUserService {

    AppUserResponseDto createUser(AppUserRequestDto userRequestDto);

    AppUserResponseDto updateUser(Long id, AppUserRequestDto userRequestDto);

    List<AppUserResponseDto> getAllUsers();

    AppUserResponseDto getUsers(Long id);

    void deleteUser(Long id);
}
