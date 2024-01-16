package inventory;

 class NonFictionCategory extends Category {
    public NonFictionCategory(String name, String description) {
        super(name, description);
    }

    @Override
    public String getDescription() {
        return "Non-Fiction Category: " + super.getDescription();
    }
}