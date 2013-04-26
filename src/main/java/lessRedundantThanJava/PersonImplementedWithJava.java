package lessRedundantThanJava;

class PersonImplementedWithJava implements Person {
    private int age;
    private String name;
    private String countryOfBirth;

    public PersonImplementedWithJava(String name, int age, String countryOfBirth) {
        this.age = age;
        this.name = name;
        this.countryOfBirth = countryOfBirth;
    }

    public PersonImplementedWithJava(String name, int age) {
        this(name, age, "SWEDEN");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }
}
