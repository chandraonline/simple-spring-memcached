package net.nelz.simplesm.aop;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.*;
import net.nelz.simplesm.exceptions.InvalidAnnotationException;

/**
Copyright (c) 2008  Nelson Carpentier

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
public class InvalidateMultiCacheAdviceTest {

    private InvalidateMultiCacheAdvice cut;

    @BeforeClass
    public void beforeClass() {
        cut = new InvalidateMultiCacheAdvice();
        cut.invalidateMulti();
    }

    @Test
    public void testConvertToKeyObjects() throws Exception {
        cut.convertToKeyObjects(new ArrayList<String>(), 2, "randomMethodName");

        try {
            cut.convertToKeyObjects("Not A List", 2, "randomMethodName");
            fail("Expected Exception.");
        } catch (InvalidAnnotationException ex) {
            assertTrue(ex.getMessage().contains("does not fulfill"));
        }
    }
}
