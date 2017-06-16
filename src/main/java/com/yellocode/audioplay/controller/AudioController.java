package com.yellocode.audioplay.controller;


import com.yellocode.audioplay.model.Track;
import com.yellocode.audioplay.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AudioController {

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "tracks", method = RequestMethod.GET)
    public String listTracks(Model model){
        model.addAttribute("track", new Track());
        model.addAttribute("listTracks", this.trackService.listTracks());
        return "tracks";
    }

    @RequestMapping(value = "/tracks/add", method = RequestMethod.POST)
    public String addTrack(@ModelAttribute("track") Track track){
        if(track.getId() == 0){
            this.trackService.addTrack(track);
        }else {
            this.trackService.updateTrack(track);
        }

        return "redirect:/tracks";
    }

    @RequestMapping("/remove/{id}")
    public String removeTrack(@PathVariable("id") int id){
        this.trackService.removeTrack(id);

        return "redirect:/tracks";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("track", this.trackService.getTrackById(id));
        model.addAttribute("listTracks", this.trackService.listTracks());
        return "tracks";
    }

    @RequestMapping("trackdata/{id}")
    public String trackData(@PathVariable("id") int id, Model model){
        model.addAttribute("track", this.trackService.getTrackById(id));

        return "trackdata";
    }

}
