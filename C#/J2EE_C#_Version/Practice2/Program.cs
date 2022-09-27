// See https://aka.ms/new-console-template for more information
// TODO:
// 1. Nullable warnings
// 2. Equals
using Business.Entities;
using Business;

// Positive
Manager first_manager = new ("Максим Черв'яков", "IT", 25_000, 2_000, null);
Employee first_employeer = new 
    ("Ярослав Горлач", "IT", 15_000.20, first_manager.Id);
Employee second_employeer = new 
    ("Бондар Владислав", "IT", 20_000, first_manager.Id);

var registry = Registry.GetInstance();
registry.AddEmployeer(first_employeer);
registry.AddEmployeer(second_employeer);
registry.AddEmployeer(first_manager);

registry.PrintList();