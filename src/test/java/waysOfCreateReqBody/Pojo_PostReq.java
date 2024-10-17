package waysOfCreateReqBody;

public class Pojo_PostReq {
    int age ;
    String name ;
    String[] courses ;
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseArr(String[] courses) {
        this.courses = courses;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String[] getCourseArr() {
        return courses;
    }


}
