namespace Business.Exceptions {
    public class IncorrectSalaryException: Exception {
        public IncorrectSalaryException(string message)
            : base(message) {}
    }
}