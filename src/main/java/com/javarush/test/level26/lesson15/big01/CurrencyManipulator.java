package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mykhailo on 07.08.2016.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;                // - это Map<номинал, количество>

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = createTreeMap();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        Integer quantity = denominations.get(denomination);
        if (quantity == null)
            quantity = 0;
        denominations.put(denomination, quantity + count);
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }
        return totalAmount;
    }

    public boolean hasMoney() {
        if (denominations.isEmpty())
            return false;
        return true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        if (expectedAmount > getTotalAmount())
            return false;
        return true;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        Map<Integer, Integer> withDrawDenominations = createTreeMap();

        if (!chooseDenominations(expectedAmount, withDrawDenominations))
        {
            throw new NotEnoughMoneyException();
        }

        withdrawAll(withDrawDenominations);

        return withDrawDenominations;
    }

    private void withdrawAll(Map<Integer, Integer> withDrawDenominations) {
        for (Map.Entry<Integer, Integer> item : withDrawDenominations.entrySet()) {
            int key = item.getKey();
            int value = denominations.get(key) - item.getValue();
            if (value == 0)
                denominations.remove(key);
            else
                denominations.put(key, value);
        }
    }

    private boolean chooseDenominations(int expectedAmount, Map<Integer, Integer> withDrawDenominations) {
        for (Map.Entry<Integer, Integer> item : denominations.entrySet()) {
            int amountOfDenomination = expectedAmount / item.getKey();

            if (amountOfDenomination == 0)
                continue;

            int avalibleAmount = item.getValue();

            if (amountOfDenomination >= avalibleAmount) {
                expectedAmount -= item.getKey() * avalibleAmount;
                withDrawDenominations.put(item.getKey(), avalibleAmount);
            } else {
                expectedAmount -= item.getKey() * amountOfDenomination;
                withDrawDenominations.put(item.getKey(), amountOfDenomination);
            }

            if (expectedAmount == 0)
                return true;
        }
        return false;
    }

    private Map<Integer, Integer> createTreeMap() {
        return new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
}
