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
import static org.hamcrest.Matchers.isA;

public class CreditAccountTest {
    CreditAccount sut;

    @BeforeEach
    public void beforeEach(){
        System.out.println("BeforeEach");
        sut = new CreditAccount(-300_000);
        sut.setBalance(-20_000);

    }
    @AfterEach
    public void afterEach(){
        System.out.println("AfterEach");
        sut = null;
    }

    public static Stream<Arguments> testCreditAccountAdd() {
        return Stream.of(
                Arguments.of(21_000, false),
                Arguments.of(5_000, true),
                Arguments.of(19_500, true)
        );
    }
    @ParameterizedTest
    @MethodSource
    public void testCreditAccountAdd(long amount, boolean expected) {
        // arrange

        //act
        boolean result = sut.add(amount);
        //assert
        //Assertions.assertEquals(expected, result);
        assertThat(expected, equalTo(result));
    }


    public static Stream<Arguments> testCreditAccountPay() {
        return Stream.of(
                Arguments.of(300_000, false),
                Arguments.of(5_000, true),
                Arguments.of(280_000, true)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testCreditAccountPay(long amount, boolean expected) {
        // arrange

        //act
        boolean result = sut.pay(amount);
        //assert
        //Assertions.assertEquals(expected, result);
        assertThat(expected, equalTo(result));
    }
    @Test
    public void methodHamcrestNew2() {
        assertThat(sut, isA(Account.class)); //проверка, что данный объект является экземпляром класса Account или его
        // подкласса
    }
}
