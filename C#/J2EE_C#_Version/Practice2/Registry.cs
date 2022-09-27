using Business.Entities;
using Business.Exceptions;

namespace Business {
    public class Registry {
        private static readonly Registry WorkersRegistry = new ();

        private readonly LinkedList<Employee> workers;

        private Registry() {
            workers = new LinkedList<Employee>();
        }

        public static Registry GetInstance() {
            return WorkersRegistry;
        }

        public void AddEmployeer(Employee employeer) {
            if (workers.Contains(employeer)) {
                throw new EmployeeInRegistryException
                    ("Не можна найняти двічі одну й ту саму людину!");
            }
            workers.AddFirst(employeer);
        }

        public void PrintList() {
            Console.WriteLine("Список всіх працівників:");
            foreach (var employeer in workers) {
                Console.WriteLine(employeer);
            }
        }
    }
}