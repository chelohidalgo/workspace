package exceptions.catchblock;

class DataAccessException extends RuntimeException {
    public DataAccessException(String message) {
        super(message);
    }
}
