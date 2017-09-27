import io.entity.Student;
import io.util.ReflectionUtil;
import org.junit.Test;


public class ReflectionTest {
    @Test
    public void printFieldObject() throws IllegalAccessException {
        Student student=new Student();
        student.setName("Kari");
        student.setLastName("Lazner Shafert");
        student.setUniversity("UPM");
        ReflectionUtil.printObjectField(student);
    }
    @Test
    public void testGetObject() throws InstantiationException, IllegalAccessException {
        String input="Jhoan$Garrer$MIT";
        String[] dat=input.split("$");
        Student student=ReflectionUtil.getObject(Student.class,dat);
        ReflectionUtil.printObjectField(student);
    }
}
