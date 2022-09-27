namespace Business.Exceptions {
    public class EmployeeInRegistryException: Exception {
        public EmployeeInRegistryException(string message)
            : base(message) {}
    }
}