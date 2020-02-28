package org.kitteh.pastegg;

import static org.junit.Assert.*;

/**
 * Created for the Charlton IT Project.
 * Created by benjicharlton on 28/02/2020.
 */
public class PasteBuilderTest {

    @org.junit.Test
    public void build() {
        PasteContent content = new PasteContent(PasteContent.ContentType.TEXT, "HELLO WORLD");
        assertEquals(content.getValue(),"HELLO WORLD");
        PasteBuilder.PasteResult result = new PasteBuilder().name("TEST!").addFile(
              new PasteFile("jkcclemens.txt",
                    new PasteContent(PasteContent.ContentType.TEXT, "HELLO WORLD")))
              .visibility(Visibility.UNLISTED)
              .build();
        assertTrue(result.getPaste().isPresent());
        Paste paste = result.getPaste().get();
        assertNotNull(paste.getId());
        assert(paste.getVisibility().equals(Visibility.UNLISTED));
        assertTrue(paste.getDeletionKey().isPresent());
    }
}