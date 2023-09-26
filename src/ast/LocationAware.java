package ast;

public interface LocationAware {

    /**
     * @return the location of the node in the source code
     */
    SegmentLocation getLocation();
}
