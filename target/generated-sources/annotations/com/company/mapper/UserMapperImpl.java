package com.company.mapper;

import com.company.dto.request.UserRequest;
import com.company.dto.response.UserResponse;
import com.company.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T00:17:56+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRequest convertUserToUserRequest(User user) {
        if ( user == null ) {
            return null;
        }

        String username = null;
        String name = null;
        String surname = null;
        String email = null;

        username = user.getUsername();
        name = user.getName();
        surname = user.getSurname();
        email = user.getEmail();

        UserRequest userRequest = new UserRequest( username, name, surname, email );

        return userRequest;
    }

    @Override
    public User convertUserRequestToUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.name( userRequest.name() );
        user.surname( userRequest.surname() );
        user.username( userRequest.username() );
        user.email( userRequest.email() );

        return user.build();
    }

    @Override
    public UserResponse convertUserToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String username = null;
        String name = null;
        String surname = null;
        String email = null;

        id = user.getId();
        username = user.getUsername();
        name = user.getName();
        surname = user.getSurname();
        email = user.getEmail();

        UserResponse userResponse = new UserResponse( id, username, name, surname, email );

        return userResponse;
    }

    @Override
    public User convertUserResponseToUser(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.id( userResponse.id() );
        user.name( userResponse.name() );
        user.surname( userResponse.surname() );
        user.username( userResponse.username() );
        user.email( userResponse.email() );

        return user.build();
    }
}
