import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SimpleAccountTest {
    SimpleAccount sut;

    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach");
        sut = new SimpleAccount();
        sut.setBalance(7_000);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach");
        sut = null;
    }

    @Test
    public void testSimpleAccountAdd() {
        // arrange
        long amount = 1000;
        //act
        boolean result = sut.add(amount);
        //assert
        Assertions.assertTrue(result);
    }

    public static Stream<Arguments> testSimpleAccountPay() {
        return Stream.of(
                Arguments.of(7_600, false),
                Arguments.of(500, true)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testSimpleAccountPay(long amount, boolean expected) {
        // arrange

        //act
        boolean result = sut.pay(amount);
        //assert
        Assertions.assertEquals(expected, result);
    }
}
