package com.rvkb.ecahier.woko

import woko.hbcompass.CompassResultIterator
import org.compass.core.CompassHitsOperations

class CompassResultIteratorWithHighlight<T> extends CompassResultIterator<T> {

    private final List<String> highlightedFragments = []

    CompassResultIteratorWithHighlight(
      CompassHitsOperations compassHits,
      int start,
      int limit,
      int totalSize,
      List<String> highlightedFragments) {
        super(compassHits, start, limit, totalSize)
        if (highlightedFragments) {
            this.highlightedFragments.addAll(highlightedFragments)
        }
    }

    String getHighlightedFragment(int i) {
        if (i<0 || i>=highlightedFragments.size()) {
            throw new ArrayIndexOutOfBoundsException()
        }
        return highlightedFragments[i]
    }
}
