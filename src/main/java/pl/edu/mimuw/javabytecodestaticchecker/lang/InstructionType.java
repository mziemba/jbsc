/**
 * InstructionType class
 * @version 1.0.0
 * 2012-02-11, 17:13
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.lang;

/**
 * Enumeration representing different instruction types, that is:
 *  * i	integer,
 *  * l long,
 *  * s short,
 *  * b byte,
 *  * c character,
 *  * f float,
 *  * d double,
 *  * a reference.
 *
 */
public enum InstructionType {

    INTEGER(0),
    LONG(1),
    SHORT(2),
    BYTE(3),
    CHARACTER(4),
    FLOAT(5),
    DOUBLE(6),
    REFERENCE(7);

    private int type;

    private InstructionType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
