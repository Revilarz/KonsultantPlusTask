package suits;

import tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//запуск тестов в строгой последовательности
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FirstTest.class,
        SecondTest.class,
        ThirdTest.class,
        FourthTest.class,
        FifthTest.class,
        SixthText.class,
        SeventhTest.class,
        EighthTest.class,
        NinthTest.class,
        TenthTest.class
})

public class SuitForTest {

}