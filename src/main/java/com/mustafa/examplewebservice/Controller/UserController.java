package com.mustafa.examplewebservice.Controller;

import com.mustafa.examplewebservice.DTO.AlbumDTO;
import com.mustafa.examplewebservice.DTO.UserDTO;
import com.mustafa.examplewebservice.Enum.RequestType;
import com.mustafa.examplewebservice.Service.RequestInfoHolder;
import com.mustafa.examplewebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webservice")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestInfoHolder requestInfoHolder;

    @GetMapping("/allUsers")
    public UserDTO[] getAllUsers(){
        requestInfoHolder.incrementRequestCount(RequestType.GET_ALL_USERS);
        return userService.getAllUsers();

    }

    @PostMapping("/email/{emails}")
    public List<UserDTO> getMailUser(@PathVariable List<String> emails){
        if (emails.size() == 1)
            requestInfoHolder.incrementRequestCount(RequestType.GET_USERS_BY_MAIL);
        else
            requestInfoHolder.incrementRequestCount(RequestType.GET_USER_BY_MULTIPLE_MAIL);
        return userService.getFilterEmails(emails);

    }

    @PutMapping("/userAlbums/{id}")
    public AlbumDTO[] getUserAlbums(@PathVariable Long id){
        requestInfoHolder.incrementRequestCount(RequestType.GET_USERS_ALBUMS);
        return userService.getUserAlbums(id);

    }

    @PutMapping("/userAlbumsWithDetails/{id}")
    public List<AlbumDTO> getUserAlbumsWithDetails(@PathVariable Long id){
        requestInfoHolder.incrementRequestCount(RequestType.GET_USER_ALBUMS_PHOTOS);
        return   userService.getUserAlbumsWithDetails(id);
    }
}
