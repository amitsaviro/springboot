package com.firstProject.tvMaze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "TvMazeService",
        url = "${tvmaze.url}"
)
public interface TvMazeService {

    @GetMapping("/shows/{tvShowId}")
    TvMazeShowResponse getTvShowById(@PathVariable Long tvShowId);
}
