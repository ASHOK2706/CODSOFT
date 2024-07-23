class Courses {
    private String course_code;
    private String course_title;
    private int capacity;
    public Courses(String course_code,String course_title,int capacity) {
        this.course_code = course_code;
        this.course_title = course_title;
        this.capacity = capacity;
    }
    public String getCourse_code() {
        return this.course_code;
    }
    public String getCourse_titlle() {
        return this.course_title;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return "[  Course code : " + course_code + ", Course_Title : " + course_title + ", Capacity : " + capacity
                + "  ]";
    }
}