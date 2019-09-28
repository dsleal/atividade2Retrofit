package br.eti.urbano.mobile.exemploretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.model.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserResource {

    @GET("/users")
    Call<List<Users>> get();

    @POST("/users")
    Call<Users> post(@Body Users users);

    @PUT("/users/{id}")
    Call<Users> put(@Body Users users);

    @DELETE("/users/{id}")
    Call<Void> delete(Integer id);

    @PATCH("/users/{id}")
    Call<Users> patch(Integer id, @Body Users users);

}
