package com.mustafa.examplewebservice.Service;

import com.mustafa.examplewebservice.DTO.AlbumDTO;
import com.mustafa.examplewebservice.DTO.PhotosDTO;
import com.mustafa.examplewebservice.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;


    public UserDTO[] getAllUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        return this.restTemplate.getForObject(url, UserDTO[].class);
    }

    public List<UserDTO> getFilterEmails(List<String> emails) {
        return Arrays.stream(getAllUsers())
                .filter((userDTO) -> {
                    return emails.stream().anyMatch(email -> userDTO.getEmail().endsWith(email));
                })
                .collect(Collectors.toList());
    }

    public AlbumDTO[] getUserAlbums(Long id) {
        String url = "https://jsonplaceholder.typicode.com/albums?userId={id}";
        return this.restTemplate.getForObject(url, AlbumDTO[].class, id);
    }

    public List<AlbumDTO> getUserAlbumsWithDetails(Long id) {
        return Arrays.stream(getUserAlbums(id)).map((albumDTO) -> {
            String url = "https://jsonplaceholder.typicode.com/photos?albumId=" + albumDTO.getId();
            PhotosDTO[] photosDTOS = restTemplate.getForObject(url, PhotosDTO[].class);
            albumDTO.setPhotos(Arrays.asList(photosDTOS));
            return albumDTO;
        })
                .collect(Collectors.toList());
    }


}
