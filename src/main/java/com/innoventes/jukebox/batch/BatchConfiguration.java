package com.innoventes.jukebox.batch;

import com.innoventes.jukebox.batch.step1.MusicianInput;
import com.innoventes.jukebox.batch.step1.MusicianProcessor;
import com.innoventes.jukebox.batch.step1.MusicianWriter;
import com.innoventes.jukebox.batch.step2.AlbumInput;
import com.innoventes.jukebox.batch.step2.MusicAlbumProcessor;
import com.innoventes.jukebox.batch.step2.MusicAlbumWriter;
import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private static String[] MUSICIAN_FIELDS = {"id", "real_name", "art_name", "role", "year_of_birth", "country", "city", "email", "zip_code"};
    private static String[] ALBUM_FIELDS = {"id","artist_id", "album_title", "genre", "year_of_pub", "num_of_tracks", "num_of_sales", "rolling_stone_critic", "mtv_critic", "music_maniac_critic"};


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<MusicianInput> musicianReader() {
        return new FlatFileItemReaderBuilder<MusicianInput>()
                .name("musicianItemReader")
                .resource(new ClassPathResource("dataset/artists.csv"))
                .delimited()
                .names(MUSICIAN_FIELDS)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MusicianInput>() {{
                    setTargetType(MusicianInput.class);
                }})
                .build();
    }

    @Bean
    public FlatFileItemReader<AlbumInput> albumReader() {
        return new FlatFileItemReaderBuilder<AlbumInput>()
                .name("albumReader")
                .resource(new ClassPathResource("dataset/albums.csv"))
                .delimited()
                .names(ALBUM_FIELDS)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<AlbumInput>() {{
                    setTargetType(AlbumInput.class);
                }})
                .build();
    }

    @Bean
    public MusicianProcessor musicianProcessor() {
        return new MusicianProcessor();
    }

    @Bean
    public MusicAlbumProcessor musicAlbumProcessor() {
        return new MusicAlbumProcessor();
    }

    @Bean
    public MusicianWriter musicianWriter() {
        return new MusicianWriter();
    }


    @Bean
    public Step step1(MusicianWriter writer) {
        return stepBuilderFactory.get("step1")
                .<MusicianInput, Musician>chunk(10)
                .reader(musicianReader())
                .processor(musicianProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step2(MusicAlbumWriter writer) {
        return stepBuilderFactory.get("step2")
                .<AlbumInput, MusicAlbum>chunk(10)
                .reader(albumReader())
                .processor(musicAlbumProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Job importVehicleJob(JobCompletionNotificationListener listener, Step step1, Step step2) {
        return jobBuilderFactory.get("importMusicianJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1)
                .next(step2)
                .build();
    }

}
