package Eco3DPrint.BackendEco3DPrint.service.tutorialService;

import Eco3DPrint.BackendEco3DPrint.model.Tutorial;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * This interface defines the methods for managing tutorials.
 */
public interface TutorialService {

    /**
     * Create a new tutorial.
     *
     * @param tutorial The tutorial to be created.
     * @return A ResponseEntity containing the created tutorial.
     */
    ResponseEntity<Tutorial> createTutorial(Tutorial tutorial);

    /**
     * Get a list of all tutorials.
     *
     * @return A ResponseEntity containing a list of all tutorials.
     */
    ResponseEntity<List<Tutorial>> getAllTutorials();

    /**
     * Get a list of tutorials associated with a specific model.
     *
     * @param tutorialId The ID of the tutorial.
     * @return A ResponseEntity containing a list of tutorials for the specified model.
     */
    ResponseEntity<Tutorial> getTutorialsById(int tutorialId);

    /**
     * Delete a tutorial by its ID.
     *
     * @param tutorialId The ID of the tutorial to be deleted.
     * @return A ResponseEntity indicating the success of the operation.
     */
    ResponseEntity<Boolean> deleteTutorial(long tutorialId);

    /**
     * Get details of a tutorial based on its ID.
     *
     * @param tutorialId The ID of the tutorial.
     * @return A ResponseEntity containing details of the specified tutorial.
     */
    ResponseEntity<Tutorial> getTutorialFromId(int tutorialId);

    ResponseEntity<Tutorial> enterTutorial(int tutorialId);

    ResponseEntity<List<Tutorial>> getMostPopularTutorials();
}

