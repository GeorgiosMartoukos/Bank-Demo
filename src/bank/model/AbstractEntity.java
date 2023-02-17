package bank.model;

public abstract class AbstractEntity implements IdentifiableEntity {
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
