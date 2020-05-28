package oleh.kyrychenko.lab3.controllers;

import oleh.kyrychenko.lab3.models.Plane;
import oleh.kyrychenko.lab3.dto.PlaneDto;
import oleh.kyrychenko.lab3.services.PlaneService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/planes")
public class PlaneMvcController {

    @Autowired
    private PlaneService planeService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAllPlanes(Model model) {
        model.addAttribute("planes", (Collection<Plane>)planeService.getAllPlanes());
        return "planelist";
    }

    @RequestMapping(value = "/create/form")
    public String createPlaneForm(Model model) {
        model.addAttribute("planeDto", new PlaneDto());
        return "addplane";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPlane(@ModelAttribute("planeDto") PlaneDto planeDto) {
        Plane plane = planeService.createPlane(planeDto);
        return "redirect:/planes/get";
    }

    @RequestMapping(value = "/edit/form", params = "id")
    public String editPlaneForm(Model model, int id) {
        Plane plane = planeService.getPlaneById(id);

        if(plane == null) {
            return "redirect:/error/404";
        }

        model.addAttribute("planeDto", new PlaneDto(plane));
        model.addAttribute("id", id);

        return "editplane";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPlane(@ModelAttribute("planeDto") PlaneDto planeDto, @Param("id") int id) {
        try {
            Plane edited = planeService.editPlaneWithId(id, planeDto);
            return "redirect:/planes/get";
        } catch (NoSuchElementException ex) {
            return "redirect:/error/404";
        }
    }

    @RequestMapping(value = "/delete", params = "id")
    public String deletePlane(int id) {
        try {
            Plane deleted = planeService.deletePlane(id);
            return "redirect:/planes/get";
        } catch (NoSuchElementException ex) {
            return "redirect:/error/404";
        }
    }
}
