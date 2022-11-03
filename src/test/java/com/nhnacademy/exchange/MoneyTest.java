package com.nhnacademy.exchange;

import com.nhnacademy.exchange.exception.NoMatchCurrencyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


import static org.assertj.core.api.Assertions.*;

class MoneyTest {
    // SUT
    ExchangeService service;

    @BeforeEach
    void setUp() {
        service = new ExchangeService();
        Money money = mock(Money.class);
    }

    /*
    같은 통화의 돈을 더했을 때 값이 일치하는 경우
     */
    @Test
    void check_addAmount_equal() {
        Money money1 = new Money(1000.0, "won");
        Money money2 = new Money(1000.0, "won");

        money1.addAmount(money2);
        assertThat(money1.getAmount()).isEqualTo(2000.0);
    }

    /*
    다른 통화의 돈을 더했을 때 NoMatchCurrencyException 발생
     */
    @Test
    void check_addAmount_NotEqualCurrency_ThenthrowNoMatchCurrencyException() {
        Money money1 = new Money(1000.0, "won");
        Money money2 = new Money(1000.0, "dollar");

        assertThatThrownBy(() -> money1.addAmount(money2))
            .isInstanceOf(NoMatchCurrencyException.class)
                .hasMessageContainingAll("No Match Currency :", money1.getCurrency(), money2.getCurrency());
    }

    /*
    같은 통화의 돈을 뺐을 때 값이 일치하는 경우
     */
    @Test
    void check_subAmount_equal() {
        Money money1 = new Money(1000.0, "won");
        Money money2 = new Money(500.0, "won");

        money1.subAmount(money2);
        assertThat(money1.getAmount()).isEqualTo(500);
    }

    /*
    돈을 뺐을 때 음수가 발생하는 경우 예외 발생
     */
//    @Test
//    void check_subAmount_ifNegative_thenThrowNegativeAmountException() {
//        Money money1 = new Won(1000.0);




//        assertThatThrownBy(() -> money1.subAmount(money2))
//            .isInstanceOf(NegativeAmountException.class)
//                .hasMessageContainingAll("Amount is Negative Number: ", Double.toString(money1.getAmount()));
    }
//
//    @Test
//    void check_Equal_
//}