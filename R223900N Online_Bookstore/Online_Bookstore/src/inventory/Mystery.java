package inventory;

 class MysteryCategory extends Category {
    public MysteryCategory(String name, String description) {
        super(name, description);
    }

    @Override
    public String getDescription() {
        return "Mystery Category: " + super.getDescription();
    }
}