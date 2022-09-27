using Business.Exceptions;

namespace Business.Entities {
    public class Manager : Employee {

        private double _bonus;

        public double Bonus {
            get => _bonus;
            set {
                if (value < 0) {
                    throw new IncorrectSalaryException
                        ("Премія не може бути від'ємною!");
                }
                _bonus = value;
            }
        }
        public Manager
        (
            string name,
            string departmentName,
            double salary,
            double bonus,
            int? managerId
        ) : base(name, departmentName, salary, managerId) {
            
            try {
                Bonus = bonus;
            } catch (IncorrectSalaryException e) {
                Console.WriteLine(e.Message);
            }
        }

        public override string ToString()
        {
            return base.ToString() + $"Премія: {Bonus}\n";
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