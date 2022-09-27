using Business.Exceptions;

namespace Business.Entities {
    public class Employee {

        protected static readonly byte MaxLength = 20;
        protected static int _nextId = 0;

        protected int _id;
        protected int? _managerId;
        protected string _name;
        protected string _departmentName;
        protected double _salary;

        public bool DataCorruption { get; set; }
        public int Id {
            get => _id;
            private set => _id = value;
        }
        public int? ManagerId {
            get => _managerId; 
            set => _managerId = value; 
        }
        public string Name {
            get => _name;
            set {
                if (value.Length > MaxLength) {
                    throw new FieldLengthLimitException
                        ("Занадте довге ім'я!");
                }
                _name = value;
            }
        }
        public string DepartmentName {
            get => _departmentName;
            set {
                if (value.Length > MaxLength) {
                    throw new FieldLengthLimitException
                        ("Занадте довга назва департаменту!");
                }
                _departmentName = value;
            }
        }
        public double Salary {
            get => _salary;
            set {
                if (value < 0) {
                    throw new IncorrectSalaryException
                        ("Зарплата не може бути від'ємною");
                }
                _salary = value;
            }
        }

        public Employee
        (string name, string departmentName, double salary, int? managerId) {
            DataCorruption = false;

            Id = _nextId++;
            ManagerId = managerId;

            try {
                Name = name;
                DepartmentName = departmentName;
            } catch (FieldLengthLimitException e) {
                DataCorruption = true;
                Console.WriteLine(e.Message);
            }

            try {
                Salary = salary;
            } catch (IncorrectSalaryException e) {
                DataCorruption = true;
                Console.WriteLine(e.Message);
            }
        }

        public override string ToString()
        {
            string toStr;
            if (DataCorruption) {
                toStr = "Об'єкт був неправильно створений!";
            } else {
                toStr =
                    $"\nІнформація про працівника \"{Name}\":\n" +
                    $"Id: {Id}\n" +
                    $"Id менеджеру: {ManagerId}\n" +
                    $"Назва департаменту: {DepartmentName}\n" +
                    $"Зарплатня: {Salary:0.00}\n";
            }
            return toStr;
        }

        public override bool Equals(object? obj)
        {
            return base.Equals(obj);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
