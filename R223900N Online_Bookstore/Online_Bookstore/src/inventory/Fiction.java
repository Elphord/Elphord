package inventory;

class FictionCategory extends Category {
    public FictionCategory(String name, String description) {
        super(name, description);
    }

    @Override
    public String getDescription() {
        return "Fiction Category: " + super.getDescription();
    }
}