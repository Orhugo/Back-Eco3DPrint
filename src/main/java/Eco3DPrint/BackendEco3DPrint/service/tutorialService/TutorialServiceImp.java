package Eco3DPrint.BackendEco3DPrint.service.tutorialService;

import Eco3DPrint.BackendEco3DPrint.model.Tutorial;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.model.TutorialVote;
import Eco3DPrint.BackendEco3DPrint.repository.TutorialRepository;
import Eco3DPrint.BackendEco3DPrint.repository.UsuarioRepository;
import Eco3DPrint.BackendEco3DPrint.repository.TutorialVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImp implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private TutorialVoteRepository tutorialVoteRepository;

    @Override
    public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) {
        tutorialRepository.save(tutorial);
        return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        return new ResponseEntity<>(tutorialRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tutorial> getTutorialsById(int tutorialId) {
        Optional<Tutorial> foundTutorial = Optional.ofNullable(tutorialRepository.findById(tutorialId));
        if(foundTutorial.isPresent()){
            Tutorial tutorial = foundTutorial.get();
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteTutorial(long tutorialId) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(tutorialId);
        if (tutorial.isPresent()) {
            Optional<List<TutorialVote>> userVotes = tutorialVoteRepository.findByTutorialId(tutorial.get().getId());
            userVotes.ifPresent(votes -> tutorialVoteRepository.deleteAll(votes));
            tutorialRepository.delete(tutorial.get());
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }

//    @Override
//    public ResponseEntity<Tutorial> likeTutorial(int tutorialId, int userId) {
//        Optional<TutorialVote> tutorialVote = tutorialVoteRepository.findByTutorialIdAndUserId(tutorialId, userId);
//        if (tutorialVote.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            Optional<Tutorial> existingTutorial = tutorialRepository.findById((long) tutorialId);
//            if (existingTutorial.isPresent()) {
//                Tutorial tutorial = existingTutorial.get();
//                tutorial.setLikeCounter(tutorial.getLikeCounter() + 1);
//                tutorialVoteRepository.save(new TutorialVote(tutorialId, userId));
//                return new ResponseEntity<>(tutorial, HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<Boolean> dislikeTutorial(int tutorialId, int userId) {
//        Optional<TutorialVote> userVote = tutorialVoteRepository.findByTutorialIdAndUserId(tutorialId, userId);
//        if (userVote.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            Optional<Tutorial> existingTutorial = tutorialRepository.findById((long) tutorialId);
//            if (existingTutorial.isPresent()) {
//                Tutorial tutorial = existingTutorial.get();
//                tutorial.setLikeCounter(tutorial.getLikeCounter() - 1);
//                tutorialVoteRepository.delete(userVote.get());
//                return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<List<Integer>> getLikedTutorials(int userId) {
//        Optional<List<Integer>> likedTutorialsForUser = tutorialVoteRepository.findByUserId(userId);
//        return likedTutorialsForUser.map(tutorials -> new ResponseEntity<>(tutorials, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @Override
//    public ResponseEntity<List<Usuario>> getUsersThatLikedTutorial(int tutorialId) {
//        Optional<List<Usuario>> userList = tutorialVoteRepository.findUsersByTutorialId(tutorialId);
//        if (userList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            List<Usuario> usersThatInteracted = userList.get();
//            return new ResponseEntity<>(usersThatInteracted, HttpStatus.OK);
//        }
//    }
//
//    @Override
//    public ResponseEntity<Integer> likeCountForTutorial(int tutorialId) {
//        Optional<Integer> likeCount = tutorialVoteRepository.findLikesByTutorialId(tutorialId);
//        if(likeCount.isPresent()){
//            int likes = likeCount.get();
//            return new ResponseEntity<>(likes, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @Override
    public ResponseEntity<Tutorial> getTutorialFromId(int tutorialId) {
        Optional<Tutorial> tutorial = tutorialRepository.findById((long) tutorialId);
        if(tutorial.isPresent()){
            Tutorial foundTutorial = tutorial.get();
            return new ResponseEntity<>(foundTutorial, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Tutorial> enterTutorial(int tutorialId) {
        Optional<Tutorial> tutorial = tutorialRepository.findById((long) tutorialId);
        if(tutorial.isPresent()){
            Tutorial foundTutorial = tutorial.get();
            foundTutorial.setViews(foundTutorial.getViews() + 1);
            Tutorial updatedTutorial = tutorialRepository.save(foundTutorial);
            return new ResponseEntity<>(updatedTutorial, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Tutorial>> getMostPopularTutorials() {
        List<Tutorial> mostPopularTutorials = tutorialRepository.getMostPopularTutorials(7);
        return new ResponseEntity<>(mostPopularTutorials, HttpStatus.OK);
    }
}
