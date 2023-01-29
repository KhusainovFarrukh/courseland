package courseland.user;

import courseland.user.dtos.AppUserRequestDto;
import courseland.user.dtos.AppUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;
    private final AppUserMapper userMapper;

    @Override
    public AppUserResponseDto createUser(AppUserRequestDto userRequestDto) {
        AppUser user = userRepository.save(userMapper.toEntity(userRequestDto));
        return userMapper.toResponse(user);
    }

    @Override
    public AppUserResponseDto updateUser(Long id, AppUserRequestDto userRequestDto) {
        AppUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        userMapper.partialUpdate(userRequestDto, user);
        return userMapper.toResponse(user);
    }

    @Override
    public List<AppUserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public AppUserResponseDto getUsers(Long id) {
        AppUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        return userMapper.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        userRepository.deleteById(id);
    }
}
