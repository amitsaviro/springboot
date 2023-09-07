package com.firstProject.controller;

import com.firstProject.tvMaze.TvMazeService;
import com.firstProject.tvMaze.TvMazeShowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tvMaze")
public class TvMazeController {

    @Autowired
    private TvMazeService tvMazeService;

    @GetMapping("/show/{tvShowId}")
    public TvMazeShowResponse getCustomerById(@PathVariable Long tvShowId){
        return tvMazeService.getTvShowById(tvShowId);
    }
}
