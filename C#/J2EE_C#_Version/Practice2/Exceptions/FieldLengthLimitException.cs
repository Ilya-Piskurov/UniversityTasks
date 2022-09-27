namespace Business.Exceptions {
    public class FieldLengthLimitException: Exception {
        public FieldLengthLimitException(string message)
            : base(message) {}
    }
}