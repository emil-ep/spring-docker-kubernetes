package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.ApiConstants;
import com.innoventes.jukebox.controller.helper.MusicianHelper;
import com.innoventes.jukebox.models.MusicianTypes;
import com.innoventes.jukebox.models.request.MusicianRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.util.CommonUtils;
import com.innoventes.jukebox.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Objects;

import static com.innoventes.jukebox.constants.ApiConstants.MUSICIAN_SORT_BY_NAME;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@WebAppConfiguration
public class MusicianControllerTest extends AbstractControllerTest{

    @Autowired
    private TestAuthHelper testAuthHelper;

    @Autowired
    private MusicianHelper musicianHelper;

    @Test
    public void callAddMusicianWithoutAlbumId() throws Exception {
        MusicianRequest musicianRequest = new MusicianRequest();
        musicianRequest.setName("Test Musician");
        musicianRequest.setType(MusicianTypes.POP.getMusicianType());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(musicianRequest)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void callAddMusicianWithEmptyName() throws Exception {
        MusicianRequest request = new MusicianRequest();
        request.setType(MusicianTypes.POP.getMusicianType());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(request)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void callAddMusicianWithInvalidName() throws Exception{
        MusicianRequest request = new MusicianRequest();
        request.setType(MusicianTypes.POP.getMusicianType());
        request.setName("1");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(request)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void callAddMusicianWithInvalidMusicianType() throws Exception{
        MusicianRequest request = new MusicianRequest();
        request.setType("Invalid type");
        request.setName("1");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(request)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void callUpdateMusicianWithInvalidName() throws Exception{
        MusicianRequest request = new MusicianRequest();
        request.setType(MusicianTypes.POP.getMusicianType());
        request.setName("1");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER, testAuthHelper.getAuthHeader("admin@jukebox.com",
                        "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(request)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void callUpdateMusicianWithEmptyName() throws Exception{
        MusicianRequest request = new MusicianRequest();
        request.setType(MusicianTypes.POP.getMusicianType());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(request)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void callCreateMusicianWithValidData() throws Exception{
        MusicianRequest request = new MusicianRequest();
        request.setType(MusicianTypes.POP.getMusicianType());
        request.setName("Musician");
        request.setAlbumIds(Arrays.asList(1L, 2L));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ApiConstants.MUSICIAN_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(request)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void fetchMusicianListWithInvalidAlbumId() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(MUSICIAN_SORT_BY_NAME)
                .param("albumId", String.valueOf(1000))
                .param("pageNo", String.valueOf(1))
                .param("size", String.valueOf(10))
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .accept(MediaType.APPLICATION_JSON);
        when(musicianHelper.fetchMusicianWithPagination(1000, 1, 10))
                .thenReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Not found")));
        mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void fetchMusicianListWithValidData() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(MUSICIAN_SORT_BY_NAME )
                .param("albumId", String.valueOf(1))
                .param("pageNo", String.valueOf(1))
                .param("size", String.valueOf(10))
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
