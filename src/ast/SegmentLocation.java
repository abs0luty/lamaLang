package ast;

public class SegmentLocation {

    private final ByteLocation firstByteLocation, lastByteLocation;

    public SegmentLocation(ByteLocation firstByteLocation, ByteLocation lastByteLocation) {
        assert firstByteLocation.getFilepath().equals(lastByteLocation.getFilepath());

        this.firstByteLocation = firstByteLocation;
        this.lastByteLocation = lastByteLocation;
    }

    /**
     * @return the location of the first byte in the code segment
     */
    public ByteLocation getFirstByteLocation() {
        return firstByteLocation;
    }

    /**
     * @return the location of the last byte in the code segment
     */
    public ByteLocation getLastByteLocation() {
        return lastByteLocation;
    }

    /**
     * Checks if the start and end positions of a code segment aren't on the
     * same line.
     *
     * @return true if the start and end line numbers aren't on the same
     * line, false otherwise
     */
    public boolean isMultiLine() {
        return !isSingleLine();
    }

    /**
     * Checks if the start and end positions of a code segment are on the
     * same line.
     *
     * @return true if the start and end line numbers are on the same
     * line, false otherwise
     */
    public boolean isSingleLine() {
        return firstByteLocation.getLineNumber() == lastByteLocation.getLineNumber();
    }

    /**
     * @return the path of the file containing the code segment
     */
    public String getFilepath() {
        return firstByteLocation.getFilepath();
    }
}
