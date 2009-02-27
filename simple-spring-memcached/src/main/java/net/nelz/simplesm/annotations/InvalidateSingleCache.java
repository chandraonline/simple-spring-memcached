package net.nelz.simplesm.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InvalidateSingleCache {
    /**
     * A namespace that is added to the key as it is stored in the distributed cache.
     * This allows differing object that may have the same ID to coexist.
     * This value must be assigned.
     * @return the namespace for the objects cached in the given method.
     */
    String namespace() default AnnotationConstants.DEFAULT_STRING;

    /**
     * Of the arguments passed into the cached method, this identifies which
     * argument provides the id by which the object will be cached. This is a
     * 0-based array index. This annotation also takes a special value of -1 to signify
     * that the object being returned is the object responsible for providing the cache key.
     * @return the index into the arguments array for the item that will provide the id
     */
    int keyIndex() default 0;

}
