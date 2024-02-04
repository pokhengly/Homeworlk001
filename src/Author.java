class Author {

    // TODO: Add the instance variables
    private String name;
    private String yearActive;

    // TODO: Add the constructor
    public Author(String name, String yearActive) {
        this.name = name;
        this.yearActive = yearActive;
    }

    // TODO: Add the getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearActive() {
        return yearActive;
    }

    public void setYearActive(String yearActive) {
        this.yearActive = yearActive;
    }

    // TODO: Add the toString method
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", yearActive='" + yearActive + '\'' +
                '}';
    }
}