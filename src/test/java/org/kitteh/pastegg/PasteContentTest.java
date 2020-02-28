package org.kitteh.pastegg;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created for the Charlton IT Project.
 * Created by benjicharlton on 28/02/2020.
 */
public class PasteContentTest {

    @Test
    public void getValue() {
        PasteContent content = new PasteContent(PasteContent.ContentType.TEXT, "HELLO WORLD");
        assertEquals(content.getValue(),"HELLO WORLD");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getException() {
        new PasteContent(PasteContent.ContentType.XZ, "HELLO WORLD");
    }
}