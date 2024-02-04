class Author {

    private String name;
    private String yearActive;


    public Author(String name, String yearActive) {
        this.name = name;
        this.yearActive = yearActive;
    }

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

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", yearActive='" + yearActive + '\'' +
                '}';
    }
}