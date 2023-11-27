package Eco3DPrint.BackendEco3DPrint;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.PrintSettings;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTests {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testIdGetterSetter() {
        model.setId(1);
        assertEquals(1, model.getId());
    }

    @Test
    public void testTitleGetterSetter() {
        model.setTitle("Test Title");
        assertEquals("Test Title", model.getTitle());
    }

    @Test
    public void testDescriptionGetterSetter() {
        model.setDescription("Test Description");
        assertEquals("Test Description", model.getDescription());
    }

    @Test
    public void testCategoryGetterSetter() {
        model.setCategory("Test Category");
        assertEquals("Test Category", model.getCategory());
    }

    @Test
    public void testTagsGetterSetter() {
        model.setTags("tag1, tag2, tag3");
        assertEquals("tag1, tag2, tag3", model.getTags());
    }

    @Test
    public void testPrintSettingsGetterSetter() {
        PrintSettings printSettings = new PrintSettings();
        model.setPrintSettings(printSettings);
        assertEquals(printSettings, model.getPrintSettings());
    }

    @Test
    public void testAuthorGetterSetter() {
        Usuario author = new Usuario();
        model.setAuthor(author);
        assertEquals(author, model.getAuthor());
    }

    @Test
    public void testMainUrlGetterSetter() {
        model.setMainUrl("http://example.com/model");
        assertEquals("http://example.com/model", model.getMainUrl());
    }

    @Test
    public void testLikeCounterGetterSetter() {
        model.setLikeCounter(42);
        assertEquals(42, model.getLikeCounter());
    }
}
