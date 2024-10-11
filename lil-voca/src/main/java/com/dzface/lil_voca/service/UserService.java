package com.dzface.lil_voca.service;

import com.dzface.lil_voca.dto.UserRequestDTO;
import com.dzface.lil_voca.dto.UserResponseDTO;
import com.dzface.lil_voca.entitiy.User;
import com.dzface.lil_voca.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public ResponseEntity<String> createUser(UserRequestDTO userRequestDTO) {
        // 중복 조회 로직
        Optional<User> isDuplicatedUser = userRepository.findByUserId(userRequestDTO.getUserId());
        if (isDuplicatedUser.isPresent()) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }

        // User 객체 생성
        User user = User.builder()
                .userId(userRequestDTO.getUserId())
                .userPassword(userRequestDTO.getUserPassword())
                .userNick(userRequestDTO.getUserNick())
                .build();

        // 사용자 저장
        userRepository.save(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<List<UserResponseDTO>> getAllUsersInfo() {
        // User 엔티티 리스트를 가져옴
        List<User> userList = userRepository.findAll();
        // UserResponseDTO 리스트 초기화
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        for(User user : userList) {
            UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserId(), user.getUserPassword(), user.getUserNick());
            userResponseDTOList.add(userResponseDTO);
        }

        // 변환된 리스트를 ResponseEntity로 반환
        return new ResponseEntity<>(userResponseDTOList, HttpStatus.OK);
    }
}
