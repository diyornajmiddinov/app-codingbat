package uz.pdp.codingbat.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.exception.ApiRequestException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApiResult register(SignDTO signDTO) {

        //BUNDAY EMAIL BORMI?
        if (userRepository.existsByUsername(signDTO.getUsername()))
            throw new ApiRequestException("Bunday email mavjud");

        User user = new User(
                signDTO.getUsername(),
                passwordEncoder.encode(signDTO.getPassword()));

        userRepository.save(user);
        return new ApiResult(true, "OK");
    }

    public ApiResult signIn(SignDTO signDTO) {


        User user = userRepository.findByUsername(signDTO.getUsername())
                .orElseThrow(() -> new ApiRequestException("Bunday emaillik user mavjud emas"));

        if (!user.isAccountNonExpired()
                || !user.isAccountNonLocked()
                || !user.isCredentialsNonExpired()
                || !user.isEnabled())
            throw new ApiRequestException("Userning 4 ta boolean idan qaysidir false");

        if (!passwordEncoder.matches(signDTO.getPassword(), user.getPassword()))
            throw new ApiRequestException("Parol yoki login xato");

        return new ApiResult(true, "Oka keyingi darsda sizga token qyataraman");
    }
}
