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
package ar.org.star.flow;

import ar.org.star.Action;
import ar.org.star.Entity;
import ar.org.star.EventListener;
import ar.org.star.simple.Listeners;
import java.util.Set;

/**
 *
 * @author Martín Straus
 */
public class FlowEntity implements Entity {

    private final Listeners listeners;
    private final Flow flow;

    public FlowEntity(Flow flow) {
        this.listeners = new Listeners(this);
        this.flow = flow;
    }

    public Set<Action> availableActions() {
        return flow.availableActions();
    }

    @Override
    public Entity notifyEventsTo(EventListener listener) {
        listeners.register(listener);
        return this;
    }

    @Override
    public Entity stopNotifyingEventsTo(EventListener listener) {
        listeners.remove(listener);
        return this;
    }

}
