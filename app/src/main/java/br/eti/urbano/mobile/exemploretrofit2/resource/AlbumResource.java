package br.eti.urbano.mobile.exemploretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.model.Album;
import br.eti.urbano.mobile.exemploretrofit2.model.Post;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AlbumResource {

    @GET("/albums")
    Call<List<Album>> get();

    @POST("/albums")
    Call<Album> post(Album album);

    @PUT("/albums")
    Call<Void> put(Album album);

    @DELETE("/albums")
    Call<Void> delete(Album album);

    @PATCH("/albums")
    Call<Void> patch(Album album);

    @GET("/posts/{id}")
    Call<List<Post>> get(Integer id);
}