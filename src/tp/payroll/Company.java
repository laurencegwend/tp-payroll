package tp.payroll;

import java.util.Collection;
import java.util.Optional;

/**
 * Cette interface ne doit pas être modifiée
 * Vous devez en fournir une implémentation, appelée CompanyImpl
 */
public interface Company {

    /**
     * A la création d'une société, la première chose à faire est
     * de désigner un gérant. Il sera le responsable direct
     * ou indirect de tous les employés de l'entreprise.
     * On suppose que cette méthode ne sera appelée qu'une seule fois
     * immédiatement après l'appel du constructeur.
     * On suppose donc que le gérant ne changera pas.
     * La méthode retourne l'instance qui représente le nouveau gérant/CEO.
     */
    Employee nominateCEO(String name);

    /**
     * Retourne le gérant/CEO de l'entreprise, ou lève
     * une exception s'il n'a pas encore été nominé
     */
    Employee getCEO();

    /**
     * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
     */
    Optional<Employee> findEmployeeByName(String name);

    /**
     * Une nouvelle personne est embauchée.
     * Tous les employés doivent avoir un manager, sauf le gérant/CEO.
     * On ne tolère pas d'avoir deux employés avec le même nom. Si l'on
     * appelle cette méthode avec une personne qui a le même nom qu'un
     * employé existant, cela n'a aucun effet.
     * La méthode retourne l'instance qui représente le nouvel employé.
     */
    Employee hireEmployee(String name, Employee manager);

    /**
     * Supprime toute référence à l'employé. Une fois cette méthode appelée,
     * tout se passe comme si l'employé n'avait jamais existé.
     * Si l'employé renvoyé est le manager d'autres employés, l'ancien manager
     * de l'employé renvoyé devient leur nouveau manager
     */
    void fire(Employee employee);

    /**
     * Le n+2 (manager du manager) de l'employé promu devient
     * son n+1 (manager direct)
     * Un employé ne peut être promu si son manager direct est
     * le gérant/CEO(la méthode est sans effet dans ce cas)
     */
    void promote(Employee employee);

    /**
     * Retourne true s'il existe au moins un autre employé dont il est
     * le manager
     */
    boolean isManager(Employee employee);

    /**
     * Retourne tous les employés qui sont managers d'au moins un autre employé
     */
    Collection<Employee> getManagers();

    /**
     * Retourne tous les employés qui ne sont pas managers
     */
    Collection<Employee> getNonManagers();

    /**
     * Retourne tous les employés dont il est le responsable DIRECT
     * S'il n'est pas manager, on retourne une collection vide
     */
    Collection<Employee> getDirectSubordinates(Employee manager);

    /**
     * Retourne tous les employés dont il est le responsable DIRECT OU INDIRECT
     * S'il n'est pas manager, on retourne une collection vide
     * !!! ATTENTION !!!
     * La collection retournée ne doit pas contenir deux fois le même employé
     */
    Collection<Employee> getSubordinates(Employee manager);

    /**
     * Retourne tous les employés dont il est le responsable INDIRECT
     * S'il n'est pas manager, on retourne une collection vide
     * !!! ATTENTION !!!
     * La collection retournée ne doit pas contenir deux fois le même employé
     */
    Collection<Employee> getIndirectSubordinates(Employee manager);

    /**
     * Calcule et retourne le salaire d'un employé.
     * Le salaire d'un employé est calculé de la façon suivante :
     * - le salaire de base est de 1000
     * - si l'employé est un manager, on ajoute au salaire de base :
     * - - 100 par employé dont il est le responsable DIRECT
     * - - 12 par employé dont il est le responsable INDIRECT
     */
    int computeSalary(Employee employee);

    /**
     * Retourne tous les employés qui sont mieux payés que le CEO
     */
    Collection<Employee> getOverpaidSubordinates();

    /**
     * Retourne tous les managers dont un subordonné au moins est mieux payé que lui
     */
    Collection<Employee> getUnderpaidSubordinates();

    /**
     * Retourne tous les employés dont au moins un manager est moins payé que lui
     */
    Collection<Employee> getWellPaidEmployees();

}
