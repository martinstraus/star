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
import ar.org.star.collections.SetMergeAcummulator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Martín Straus
 */
public class DefaultFlow implements Flow {

    private final Set<Step> initialSteps;
    private final Set<Step> currentSteps;

    public DefaultFlow(Set<Step> initialSteps) {
        this.initialSteps = initialSteps;
        this.currentSteps = new HashSet<>(initialSteps);
    }

    @Override
    public Set<Action> availableActions() {
        return currentSteps.stream().map(Step::actions).reduce(new HashSet<>(), new SetMergeAcummulator<>());
    }

    @Override
    public void transitionTo(Step from, Set<Step> to) {
        if (!currentSteps.contains(from)) {
            throw new RuntimeException("Invalid transition");
        }
        currentSteps.remove(from);
        currentSteps.addAll(to);
    }

    @Override
    public boolean isFinished() {
        return currentSteps.isEmpty();
    }

}
