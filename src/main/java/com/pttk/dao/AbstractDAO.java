package com.pttk.dao;

import java.util.List;

/**
 *
 * @author HOANGHA
 */
public class AbstractDAO<T> {

    public T findLastItem(List<T> list) {
        return list.get(list.size() - 1);
    }

    public String generatedID(String prefix, String lastID) {
        if (lastID == null || lastID.isEmpty()) {
            return prefix + "001";
        }

        String numberPart = lastID.substring(prefix.length());
        int number = Integer.parseInt(numberPart);
        number++; // tăng lên 1

        return String.format("%s%03d", prefix, number);
    }
}
