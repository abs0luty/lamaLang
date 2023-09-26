package ast;

public class ByteLocation {

    private final String filepath;
    private final int lineNumber, column, offset;

    public ByteLocation(String filepath, int line, int column, int offset) {
        this.filepath = filepath;
        this.lineNumber = line;
        this.column = column;
        this.offset = offset;
    }

    /**
     * @return the path of the file containing the byte
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @return the line number
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * @return the column number
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return the offset of the byte in the file contents string
     */
    public int getOffset() {
        return offset;
    }

    /**
     * <p>Retrieves the location of the next byte with the given offset.</p>
     * <p><b>NOTE</b>: Returns location of the byte with incremented column number, but line numbers
     * are not processed.</p>
     *
     * @param offset    the offset of the byte relative to the current one
     * @return          the location of the next byte
     */
    public ByteLocation locationOfNextByte(int offset) {
        return new ByteLocation(filepath, lineNumber, column + offset, this.offset + offset);
    }

    /**
     * <p>Retrieves the location of the next byte.</p>
     * <p><b>NOTE</b>: Returns location of the byte with incremented column number, but line numbers
     * are not processed.</p>
     *
     * @return          the location of the next byte
     */
    public ByteLocation locationOfNextByte() {
        return new ByteLocation(filepath, lineNumber, column + 1, offset + 1);
    }
}
