package uz.pdp.codingbat.service;

import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;
import uz.pdp.codingbat.repository.UserRepository;

import java.util.List;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApiResult add(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return new ApiResult(false, "Bunday email mavjud");
        }
        userRepository.save(userDTOToUser(new User(), userDTO));
        return new ApiResult(true, "saved");
    }

    @Override
    public List<UserDTO> getAll() {
        Function<User, UserDTO> function = (user -> userToUserDTO(user, new UserDTO()));
        return userRepository.findAll()
                .stream()
                .map(function)
                .toList();
    }


    @Override
    public UserDTO get(Integer id) {
        return userToUserDTO(userRepository.findById(id).orElseThrow(IllegalStateException::new), new UserDTO());
    }

    @Override
    public ApiResult edit(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(IllegalStateException::new);
        User userByEmail = userRepository.findByEmail(userDTO.getEmail());

        if (user == null) {
            return new ApiResult(false, "User not found");
        }


        if (userByEmail != null && user.getEmail().equals(userByEmail.getEmail())) {
            return new ApiResult(false, "Bunday email mavjud");
        }

        userRepository.save(userDTOToUser(userRepository.findById(id).orElseThrow(IllegalStateException::new), userDTO));
        return new ApiResult(true, "success");
    }

    @Override
    public ApiResult delete(Integer id) {
        if (userRepository.findByIdIsBefore(id)) {
            userRepository.delete(userRepository.findById(id).orElseThrow(IllegalStateException::new));
            return new ApiResult(true, "success");
        } else {
            return new ApiResult(false, "user not found");
        }
    }

    @Override
    public UserDTO signIn(UserDTO userDTO) {
        User byEmailAndPassword = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        if (byEmailAndPassword == null)
            return null;
        return userToUserDTO(byEmailAndPassword, userDTO);
    }

    private User userDTOToUser(User user, UserDTO userDTO) {
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    private UserDTO userToUserDTO(User user, UserDTO userDTO) {
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setId(user.getId());
        return userDTO;
    }

}
