package kafka.entry;

import java.util.Objects;

public class Company {
    private String name ;
    private String address;

    Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public static Company.CompanyBuilder builder(){
        return new Company.CompanyBuilder();
    }

    public static class CompanyBuilder {
        private String name ;
        private String address;

        public CompanyBuilder() {
        }

        public Company.CompanyBuilder companyName(String name){
            this.name = name;
            return this;
        }

        public Company.CompanyBuilder companyAddress(String address) {
            this.address = address;
            return this;
        }
        public Company build(){
            return new Company(this.name, this.address);
        }

        public String toString(){
            return "Company.CompanyBuilder(name="+this.name+", address = )"+this.address;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
