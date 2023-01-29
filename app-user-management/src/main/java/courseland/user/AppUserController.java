package courseland.user;

import courseland.user.dtos.AppUserRequestDto;
import courseland.user.dtos.AppUserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class AppUserController {

    private final AppUserService userService;

    @PostMapping
    public AppUserResponseDto createUser(@RequestBody AppUserRequestDto requestDto) {
        log.info("Request to create user");
        return userService.createUser(requestDto);
    }

    @PatchMapping("{id}")
    public AppUserResponseDto updateUser(
            @PathVariable Long id,
            @RequestBody AppUserRequestDto requestDto
    ) {
        log.info("Request to update user");
        return userService.updateUser(id, requestDto);
    }

    @GetMapping
    public List<AppUserResponseDto> getAllUsers() {
        log.info("Request to get all users");
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public AppUserResponseDto getUser(@PathVariable Long id) {
        log.info("Request to get a user");
        return userService.getUsers(id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("Request to delete a user");
        userService.deleteUser(id);
    }
}
