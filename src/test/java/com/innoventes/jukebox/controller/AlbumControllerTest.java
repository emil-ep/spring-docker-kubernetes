package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.AlbumHelper;
import com.innoventes.jukebox.util.CommonUtils;
import com.innoventes.jukebox.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.innoventes.jukebox.constants.ApiConstants.ALBUM_BASE_PATH;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class AlbumControllerTest extends AbstractControllerTest {

    @Autowired
    private TestAuthHelper testAuthHelper;

    @MockBean
    private AlbumHelper albumHelper;

    @Test
    public void addAlbumWithEmptyName() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ALBUM_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(getAlbumRequest(
                        null, "", getValidDateOfRelease(), "test description", "POP", 100
                        )
                )))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void addAlbumWithEmptyPrice() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ALBUM_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(getAlbumRequest(
                        null, "Test Album", getValidDateOfRelease(), "Sample description", "POP", null
                        )
                )))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void addAlbumWithInvalidDateFormat() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfRelease = LocalDate.parse("2021-05-05", formatter);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(ALBUM_BASE_PATH)
                .header(TestUtils.AUTHORIZATION_HEADER,
                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(getAlbumRequest(
                        null, "Test album", dateOfRelease, "Test description", "POP", 100
                        )
                )))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

//    @Test
//    public void updateAlbumWithInvalidId() throws Exception{
//        AlbumRequest request = getAlbumRequest(
//                1L, "", getValidDateOfRelease(), "test description", "POP", 100
//        );
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .patch(ALBUM_BASE_PATH)
//                .header(TestUtils.AUTHORIZATION_HEADER,
//                        testAuthHelper.getAuthHeader("admin@jukebox.com", "password"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(Objects.requireNonNull(CommonUtils.convertToJson(getAlbumRequest(
//                        1L, "Album Name", getValidDateOfRelease(), "test description", "POP", 100
//                        )
//                )))
//                .accept(MediaType.APPLICATION_JSON);
//        when(albumHelper.updateAlbum(request)).thenReturn(ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ErrorResponse("Not found")));
//        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isNotFound());
//    }


}
