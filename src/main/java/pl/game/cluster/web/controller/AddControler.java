package pl.game.cluster.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.game.cluster.entity.Games;
import pl.game.cluster.entity.Status;
import pl.game.cluster.services.GamesService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AddControler {

    @Autowired
    private GamesService gamesService;

    @RequestMapping(value ="/add" , method = RequestMethod.GET)
    public String addGame(Model model) {
        Games game = new Games();
        model.addAttribute("Games" , game);
        return "add";
    }
    @ModelAttribute("getStatus")
    public List<Status> populateStatusy() {
        return Arrays.asList(Status.ALL);
    }

    @RequestMapping(value = "/add", params = {"createOrUpdate"}, method = RequestMethod.POST)
    public String createGame(@Valid @ModelAttribute(value = "Games") Games games, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add";
        }
        gamesService.saveOrUpdate(games);
        return "redirect:/gamelist";
    }

    @RequestMapping(value = "/add", params = {"remove"}, method = RequestMethod.POST)
    public String removeRow(final Games games, HttpServletRequest request) {

        Integer id = Integer.valueOf(request.getParameter("remove"));
        gamesService.deleteById(id);
        return "redirect:/gamelist";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String passId(@PathVariable("id") int id, final ModelMap model) {

        Games game = gamesService.getById(id);
        model.addAttribute("Games", game);
        return "add";
    }
}
