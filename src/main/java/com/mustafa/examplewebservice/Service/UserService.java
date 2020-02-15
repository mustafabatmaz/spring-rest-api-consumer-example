package com.mustafa.examplewebservice.Service;

import com.mustafa.examplewebservice.DTO.AlbumDTO;
import com.mustafa.examplewebservice.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO[] getAllUsers();
    List<UserDTO> getFilterEmails(List<String> emails);
    AlbumDTO[] getUserAlbums(Long id);
    List<AlbumDTO> getUserAlbumsWithDetails(Long id);
}
