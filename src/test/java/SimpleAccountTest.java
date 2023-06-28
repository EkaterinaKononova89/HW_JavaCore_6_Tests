import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.typeCompatibleWith;

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
        //Assertions.assertTrue(result);
        assert(result); // boolean в хамкрете не особо выразительный
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
        //Assertions.assertEquals(expected, result);
        assertThat(expected, equalTo(result));
    }
    @Test
    public void methodHamcrestNew1() {
        assertThat(SimpleAccount.class, typeCompatibleWith(Account.class)); //Проверка, что класс SimpleAccount явлется
        // подтипом класса Account
    }
}
