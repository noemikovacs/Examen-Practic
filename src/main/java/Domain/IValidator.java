package Domain;


public interface IValidator<T extends Entity> {

    /**
     * Validates an entity
     * @param entity
     */
    void validate(T entity);
}
