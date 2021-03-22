/*
 * The MIT License
 *
 * Copyright 2017 Martín Gaspar Straus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ar.org.star.simple;

import ar.org.star.Action;
import ar.org.star.EventListener;
import java.util.Collections;
import java.util.Set;

/**
 * This simple entity is designed to be composed into an object of higher order, in the specific domain of the target
 * system. It implements the most basic behavior possible, disregarding notions of location, latency, and concurrency.
 * Events are sychronously notified to listeners.
 *
 * @author Martín Straus
 */
public class Entity implements ar.org.star.Entity {

    private final Listeners listeners;

    public Entity() {
        this.listeners = new Listeners(this);
    }

    @Override
    public Set<Action> availableActions() {
        return Collections.EMPTY_SET;
    }

    @Override
    public ar.org.star.Entity notifyEventsTo(EventListener listener) {
        listeners.register(listener);
        return this;
    }

    @Override
    public ar.org.star.Entity stopNotifyingEventsTo(EventListener listener) {
        listeners.remove(listener);
        return this;
    }

}
