package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Tutorial;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.service.tutorialService.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @PostMapping("/create")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        return tutorialService.createTutorial(tutorial);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        return tutorialService.getAllTutorials();
    }

    @GetMapping("/get/{tutorialId}")
    public ResponseEntity<Tutorial> getTutorialsByUserId(@PathVariable int tutorialId) {
        return tutorialService.getTutorialsById(tutorialId);
    }

    @DeleteMapping("/delete/{tutorialId}")
    public ResponseEntity<Boolean> deleteTutorial(@PathVariable long tutorialId) {
        return tutorialService.deleteTutorial(tutorialId);
    }

    @PostMapping("/enter/{tutorialId}")
    public ResponseEntity<Tutorial> enterTutorial(@PathVariable int tutorialId){
        return tutorialService.enterTutorial(tutorialId);
    }

    @GetMapping("/mostPopular")
    public ResponseEntity<List<Tutorial>> getMostPopularTutorials(){
        return tutorialService.getMostPopularTutorials();
    }

//    @PostMapping("/like/{tutorialId}")
//    public ResponseEntity<Tutorial> likeTutorial(@PathVariable int tutorialId, @RequestParam int userId) {
//        return tutorialService.likeTutorial(tutorialId, userId);
//    }
//
//    @DeleteMapping("/dislike/{tutorialId}")
//    public ResponseEntity<Boolean> dislikeTutorial(@PathVariable int tutorialId, @RequestParam int userId) {
//        return tutorialService.dislikeTutorial(tutorialId, userId);
//    }
//
//    @GetMapping("/liked/{userId}")
//    public ResponseEntity<List<Integer>> getLikedTutorials(@PathVariable int userId){
//        return tutorialService.getLikedTutorials(userId);
//    }
//
//    @GetMapping("/userInteractions/{tutorialId}")
//    public ResponseEntity<List<Usuario>> getUsersThatLikedTutorial(@PathVariable int tutorialId){
//        return tutorialService.getUsersThatLikedTutorial(tutorialId);
//    }
//
//    @GetMapping("/likeCount/{tutorialId}")
//    public ResponseEntity<Integer> likeCountForTutorial(@PathVariable int tutorialId){
//        return tutorialService.likeCountForTutorial(tutorialId);
//    }

    @GetMapping("/getDetails/{tutorialId}")
    public ResponseEntity<Tutorial> getTutorialFromId(@PathVariable int tutorialId){
        return tutorialService.getTutorialFromId(tutorialId);
    }
}
