/*
 * * Copyright (C) 2018-2019 Matt Baxter https://kitteh.org
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.kitteh.pastegg;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        PasteBuilder.PasteResult result = new PasteBuilder()
                .name("TEST!")
                .addFile(new PasteFile("jkcclemens.txt", new PasteContent(PasteContent.ContentType.TEXT, "HELLO WORLD")))
                .addFile(new PasteFile("paste.txt", new PasteContent(PasteContent.ContentType.TEXT, "HELLO PASTE")))
                .visibility(Visibility.UNLISTED)
                .expires(ZonedDateTime.now( ZoneOffset.UTC ).plusSeconds(10))
                .build();

        System.out.println(result.getMessage());
        System.out.println(result.getPaste().isPresent() ? result.getPaste().get().getId() : "NOPE");
        result.getPaste().ifPresent(p -> p.getDeletionKey().ifPresent(System.out::println));

        System.out.println("https://paste.gg/anonymous/" + result.getPaste().get().getId());

        System.out.println(Yolk.shorten("https://paste.gg/anonymous/" + result.getPaste().get().getId()));
    }
}
