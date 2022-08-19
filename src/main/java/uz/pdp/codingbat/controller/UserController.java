package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;

import java.util.List;
@RequestMapping("/users")
public interface UserController{
    @PostMapping
    ApiResult add(@RequestBody UserDTO userDTO);

    @PostMapping( "/sign-in")
    UserDTO signIn(@RequestBody UserDTO userDTO);

    @GetMapping
    List<UserDTO> getAll();

    @GetMapping("/{id}")
    UserDTO get(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id,
                   @RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);

}
