package br.eti.urbano.mobile.exemploretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PostResource {

    @GET("/posts")
    Call<List<Post>> get();

    @GET("/posts/{id}")
    Call<Post> get(Integer id);

    @POST("/posts")
    Call<Post> post(@Body Post post);

    @PUT("/posts/{id}")
    Call<Post> put(@Body Post post);

    @DELETE("/posts/{id}")
    Call<Void> delete(Integer id);

    @PATCH("/posts/{id}")
    Call<Post> patch(Integer id, @Body Post post);


}