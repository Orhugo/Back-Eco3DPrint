package Eco3DPrint.BackendEco3DPrint.service.userService;

import Eco3DPrint.BackendEco3DPrint.model.Login;
import Eco3DPrint.BackendEco3DPrint.model.LoginMessage;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UsuarioService {
    /**
     * Saves all given entities.
     *
     * @param user must not be {@literal null} nor must it contain {@literal null}.
     * @return the saved entities; will never be {@literal null}. The returned {@literal Iterable} will have the same size
     *         as the {@literal Iterable} passed as an argument.
     * @throws IllegalArgumentException in case the given {@link Iterable entities} or one of its entities is
     *           {@literal null}.
     * @throws OptimisticLockingFailureException when at least one entity uses optimistic locking and has a version
     *           attribute with a different value from that found in the persistence store. Also thrown if at least one
     *           entity is assumed to be present but does not exist in the database.
     */
    public Usuario saveUser(Usuario user);

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     */
    public Optional<Usuario> getUserbyId(int id);

    /**
     * Deletes the entity with the given id.
     * <p>
     * If the entity is not found in the persistence store it is silently ignored.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
     */
    public void deleteUserbyId(int id);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    public List<Usuario> getAllUsers();

    /**
     * Returns the message after trying to login ("Login success/failed, boolean, user)
     * @param login of type Login which is mail and password
     * @return LoginMessage
     */
    public LoginMessage loginUser(Login login);

    /**
     * Retrieves an optional user by their email address.
     *
     * @param email The email address of the user to retrieve.
     * @return An {@link Optional} containing the user if found, or an empty {@link Optional} otherwise.
     */
    public Optional<Usuario> getUserByEmail(String email);

    /**
    Updates the associated image url for the user of the given id
     */
    public void updateProfileImage(int idUsuario, String nuevaImagen);
}
