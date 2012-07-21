package pl.edu.mimuw.javabytecodestaticchecker.context;

/**
 *
 * @author M. Ziemba
 */
public class ClassContext {

    private String className;

    public ClassContext(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public static class Builder {
        private String className;

        public Builder setClassName(String className) {
            this.className = className;
            return this;
        }

        public ClassContext build() {
            return new ClassContext(className);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
