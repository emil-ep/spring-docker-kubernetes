package com.innoventes.jukebox.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.innoventes.jukebox.models.request.AlbumRequest;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;

@JsonComponent
public class AlbumRequestSerializer extends JsonSerializer<AlbumRequest> {
    private static String getLocalDateAsString(LocalDate localDate) {
        String day;
        String month;
        String year;
        day = localDate.getDayOfMonth() < 10 ? "0" + localDate.getDayOfMonth() : String.valueOf(localDate.getDayOfMonth());
        month = localDate.getMonthValue() < 10 ? "0" + localDate.getMonthValue() : String.valueOf(localDate.getMonthValue());
        year = String.valueOf(localDate.getYear());
        return day + "-" + month + "-" + year;
    }

    @Override
    public void serialize(AlbumRequest albumRequest, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        if (albumRequest.getId() != null)
            jsonGenerator.writeNumberField("id", albumRequest.getId());
        if (albumRequest.getName() != null)
            jsonGenerator.writeStringField("name", albumRequest.getName());
        if (albumRequest.getGenre() != null)
            jsonGenerator.writeStringField("genre", albumRequest.getGenre());
        if (albumRequest.getPrice() != null)
            jsonGenerator.writeNumberField("price", albumRequest.getPrice());
        if (albumRequest.getDescription() != null)
            jsonGenerator.writeStringField("description", albumRequest.getDescription());
//        if (albumRequest.getDateOfRelease() != null)
//            jsonGenerator.writeStringField("dateOfRelease", getLocalDateAsString(albumRequest.getDateOfRelease()));
        if (albumRequest.getMusicianId() != null && albumRequest.getMusicianId().size() != 0) {
            jsonGenerator.writeArrayFieldStart("musicianId");
            for (Long id : albumRequest.getMusicianId()) {
                jsonGenerator.writeNumber(id);
            }
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndObject();
    }
}
