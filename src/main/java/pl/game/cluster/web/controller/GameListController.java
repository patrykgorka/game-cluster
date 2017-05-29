package pl.game.cluster.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.game.cluster.entity.Status;
import pl.game.cluster.entity.Games;
import pl.game.cluster.services.GamesService;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameListController {

    @Autowired
    private GamesService gamesService;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/gamelist")
    public String add() {
        return "gamelist";
    }

    @RequestMapping(value = "/gamelist/exchange", method = RequestMethod.GET)
    public String asdd(ModelMap model) {

        List<Games> list = gamesService.getByStatus(Status.WYMIANA);
        model.replace("getAllGames", list);
        return "gamelist";
    }

    @ModelAttribute("getAllGames")
    public List<Games> gamesList() {
        return this.gamesService.getAll();
    }

    @ModelAttribute("getStatus")
    public List<Status> statusArray() {
        return Arrays.asList(Status.ALL);
    }
    
}