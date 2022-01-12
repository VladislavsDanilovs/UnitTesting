
import org.assertj.core.util.Streams;
import org.junit.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;


public class DataServiceTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Run before every test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run after each test");
    }

    @BeforeClass
    public static void setUpAll(){
        // will be executed 1 time before methods
    }
    @AfterClass
    public static void afterAll(){
        // After compliting all tests, this method will be executed
    }

    @Test
    public void test() {
        System.out.println("Test passed");
    }

    @Test
    public void testFindMax() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 3, 54, 8, 24, 51, 56, 0,56);
        int max = DataService.findMax(numbers);
        int max2 = DataService.findMax(numbers2);

        assertThat(max).isEqualTo(7);
        assertThat(max2).isNotNull().isGreaterThan(50).isLessThan(100).isEqualTo(56);
    }

    @Test(expected = Exception.class) //NullPointerException.class or other exception
    public void testFindMaxException() throws Exception {
        List<Integer> numbers = Arrays.asList();
        DataService.findMax(numbers);

    }

    @Test(expected = Exception.class) //NullPointerException.class or other exception
    public void testFindMaxExceptionByStreams_Null_List() throws Exception {
        List<Integer> numbers = null;
        DataService.findMaxByStreams(numbers);

    }

    @Test(timeout = 100)
    public void testPerformance() throws Exception {
      List<Integer> numbers = Stream.iterate(0, n->n+1).limit(2000)
                        .collect(Collectors.toList());

        DataService.findMaxByStreams(numbers);
    }

    @Test
    public void testFindMaxByStreams() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 3, 54, 8, 24, 51, 56, 0);
        int max = DataService.findMaxByStreams(numbers);
        int max2 = DataService.findMaxByStreams(numbers2);

        assertThat(max).isEqualTo(7);
        assertThat(max2).isEqualTo(56);
    }
}