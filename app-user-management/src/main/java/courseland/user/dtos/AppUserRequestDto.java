package courseland.user.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    private Long avatarId;
}
