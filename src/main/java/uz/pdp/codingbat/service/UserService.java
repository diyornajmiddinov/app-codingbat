package uz.pdp.codingbat.service;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO signIn(UserDTO userDTO);
    ApiResult add(UserDTO userDTO);

    List<UserDTO> getAll();

    UserDTO get(Integer id);

    ApiResult edit(Integer id, UserDTO userDTO);

    ApiResult delete(Integer id);
}
